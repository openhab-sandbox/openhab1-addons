/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.neohub.internal;

import java.math.BigDecimal;
import java.util.Dictionary;

import org.apache.commons.lang.StringUtils;
import org.openhab.binding.neohub.NeoHubBindingProvider;
import org.openhab.binding.neohub.internal.InfoResponse.Device;
import org.openhab.core.binding.AbstractActiveBinding;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.library.types.StringType;
import org.openhab.core.types.Command;
import org.openhab.core.types.State;
import org.openhab.core.types.UnDefType;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Actively polls neohub for status of all devices.
 *
 * @author Sebastian Prehn
 * @since 1.5.0
 */
public class NeoHubBinding extends AbstractActiveBinding<NeoHubBindingProvider> implements ManagedService {

    private static final Logger logger = LoggerFactory.getLogger(NeoHubBinding.class);

    /**
     * The refresh interval which is used to poll values from the neohub server
     * (optional, defaults to 60000ms).
     */
    private long refreshInterval = 60000;

    /**
     * Hostname or IP address of neohub on tcp network.
     */
    private String hostname;

    /**
     * Port of neohub on tcp network. (optional, defaults to 4242).
     */
    private int port = 4242;

    public NeoHubBinding() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void deactivate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return "neohub Refresh Service";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void execute() {
        try {
            // send info request
            final InfoResponse response = createProtocol().info();
            if (response == null) {
                // already logged
                return;
            }
            for (NeoHubBindingProvider provider : providers) {
                for (String itemName : provider.getItemNames()) {
                    final String device = provider.getNeoStatDevice(itemName);
                    final NeoStatProperty property = provider.getNeoStatProperty(itemName);
                    final State result = mapResponseToState(response, device, property);

                    if (eventPublisher != null) {
                        eventPublisher.postUpdate(itemName, result);
                    }
                }
            }

        } catch (final RuntimeException e) {
            logger.warn("Failed to fetch info from neo hub.", e);
        }

    }

    private State mapResponseToState(final InfoResponse infoResponse, final String deviceName,
            final NeoStatProperty property) {
        final Device deviceInfo = infoResponse.getDevice(deviceName);
        if (deviceInfo == null) {
            logger.warn("Failed to find device info for {}", deviceName);
            return UnDefType.NULL;
        }
        switch (property) {
            case CurrentTemperature:
                BigDecimal currentTemperature = deviceInfo.getCurrentTemperature();
                if (currentTemperature.intValue() == 255) {
                    // when device is off or just reset we will get 255.255
                    logger.debug("Current temperature for device {} is out of range (is device off?): {}", deviceName,
                            currentTemperature);
                    return UnDefType.UNDEF;
                }
                return new DecimalType(currentTemperature);
            case CurrentFloorTemperature:
                BigDecimal currentFloortemperature = deviceInfo.getCurrentFloorTemperature();
                // when floor sensor is off we will get 127
                if (currentFloortemperature.intValue() == 127) {
                    logger.debug("Current floor temperature for device {} is out of range (is floor sensor off?): {}",
                            deviceName, currentFloortemperature);
                    return UnDefType.UNDEF;
                }
                return new DecimalType(deviceInfo.getCurrentFloorTemperature());
            case CurrentSetTemperature:
                return new DecimalType(deviceInfo.getCurrentSetTemperature());
            case DeviceName:
                return new StringType(deviceInfo.getDeviceName());
            case Away:
                return deviceInfo.isAway() ? OnOffType.ON : OnOffType.OFF;
            case Holiday:
                return deviceInfo.isHoliday() ? OnOffType.ON : OnOffType.OFF;
            case HolidayDays:
                return new DecimalType(deviceInfo.getHolidayDays());
            case Standby:
                return deviceInfo.isStandby() ? OnOffType.ON : OnOffType.OFF;
            case Heating:
                return (deviceInfo.isHeating() || deviceInfo.isPreHeat()) ? OnOffType.ON : OnOffType.OFF;
            default:
                throw new IllegalStateException(
                        String.format("No result mapping configured for this neo stat property: %s", property));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void internalReceiveCommand(String itemName, Command command) {
        for (NeoHubBindingProvider provider : providers) {
            if (!provider.providesBindingFor(itemName)) {
                continue;
            }

            final String device = provider.getNeoStatDevice(itemName);
            switch (provider.getNeoStatProperty(itemName)) {
                case Away:
                    if (command instanceof OnOffType) {
                        OnOffType onOffType = (OnOffType) command;
                        createProtocol().setAway(OnOffType.ON == onOffType, device);
                    }
                    break;
                case Standby:
                    if (command instanceof OnOffType) {
                        OnOffType onOffType = (OnOffType) command;
                        createProtocol().setStandby(OnOffType.ON == onOffType, device);
                    }
                default:
                    break;
            }
        }

    }

    private NeoHubProtocol createProtocol() {
        return new NeoHubProtocol(new NeoHubConnector(hostname, port));
    }

    protected void addBindingProvider(NeoHubBindingProvider bindingProvider) {
        super.addBindingProvider(bindingProvider);
    }

    protected void removeBindingProvider(NeoHubBindingProvider bindingProvider) {
        super.removeBindingProvider(bindingProvider);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updated(final Dictionary<String, ?> config) throws ConfigurationException {
        if (config != null) {
            final String refreshIntervalString = (String) config.get("refresh");
            if (StringUtils.isNotBlank(refreshIntervalString)) {
                try {
                    refreshInterval = Long.parseLong(refreshIntervalString);
                } catch (NumberFormatException e) {
                    throw new ConfigurationException("refresh",
                            String.format("Provided value (%s) cannot be parsed to an long integer.", port));
                }
            }

            final String host = (String) config.get("hostname");
            if (StringUtils.isNotBlank(host)) {
                this.hostname = host;
            } else {
                throw new ConfigurationException("hostname", "Required configuration parameter is not set.");
            }

            final String port = (String) config.get("port");
            if (StringUtils.isNotBlank(port)) {
                try {
                    this.port = Integer.parseInt(port);
                } catch (NumberFormatException e) {
                    throw new ConfigurationException("port",
                            String.format("Provided value (%s) cannot be parsed to an integer.", port));
                }
            }

            setProperlyConfigured(true);
        }
    }

}
