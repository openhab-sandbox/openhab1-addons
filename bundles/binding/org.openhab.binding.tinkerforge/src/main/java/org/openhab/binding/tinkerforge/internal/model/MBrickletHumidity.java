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
/**
 */
package org.openhab.binding.tinkerforge.internal.model;

import java.math.BigDecimal;

import org.openhab.binding.tinkerforge.internal.types.DecimalValue;

import com.tinkerforge.BrickletHumidity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MBricklet Humidity</b></em>'.
 *
 * @author Theo Weiss
 * @since 1.3.0
 *        <!-- end-user-doc -->
 *
 *        <p>
 *        The following features are supported:
 *        </p>
 *        <ul>
 *        <li>{@link org.openhab.binding.tinkerforge.internal.model.MBrickletHumidity#getDeviceType <em>Device
 *        Type</em>}</li>
 *        <li>{@link org.openhab.binding.tinkerforge.internal.model.MBrickletHumidity#getThreshold
 *        <em>Threshold</em>}</li>
 *        </ul>
 *
 * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getMBrickletHumidity()
 * @model superTypes="org.openhab.binding.tinkerforge.internal.model.MSensor
 *        <org.openhab.binding.tinkerforge.internal.model.MDecimalValue>
 *        org.openhab.binding.tinkerforge.internal.model.MDevice
 *        <org.openhab.binding.tinkerforge.internal.model.MTinkerBrickletHumidity>
 *        org.openhab.binding.tinkerforge.internal.model.MTFConfigConsumer
 *        <org.openhab.binding.tinkerforge.internal.model.TFBaseConfiguration>
 *        org.openhab.binding.tinkerforge.internal.model.CallbackListener"
 * @generated
 */
public interface MBrickletHumidity extends MSensor<DecimalValue>, MDevice<BrickletHumidity>,
        MTFConfigConsumer<TFBaseConfiguration>, CallbackListener {
    /**
     * Returns the value of the '<em><b>Device Type</b></em>' attribute.
     * The default value is <code>"bricklet_humidity"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Device Type</em>' attribute.
     * @see #setDeviceType(String)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getMBrickletHumidity_DeviceType()
     * @model default="bricklet_humidity" unique="false"
     * @generated
     */
    String getDeviceType();

    /**
     * Sets the value of the '{@link org.openhab.binding.tinkerforge.internal.model.MBrickletHumidity#getDeviceType
     * <em>Device Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Device Type</em>' attribute.
     * @see #getDeviceType()
     * @generated
     */
    void setDeviceType(String value);

    /**
     * Returns the value of the '<em><b>Threshold</b></em>' attribute.
     * The default value is <code>"0.5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Threshold</em>' attribute.
     * @see #setThreshold(BigDecimal)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getMBrickletHumidity_Threshold()
     * @model default="0.5" unique="false"
     * @generated
     */
    BigDecimal getThreshold();

    /**
     * Sets the value of the '{@link org.openhab.binding.tinkerforge.internal.model.MBrickletHumidity#getThreshold
     * <em>Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Threshold</em>' attribute.
     * @see #getThreshold()
     * @generated
     */
    void setThreshold(BigDecimal value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
     * @generated
     */
    @Override
    void init();

} // MBrickletHumidity
