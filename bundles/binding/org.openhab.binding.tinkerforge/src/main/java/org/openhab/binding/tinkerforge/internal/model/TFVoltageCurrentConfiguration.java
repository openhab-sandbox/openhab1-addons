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
package org.openhab.binding.tinkerforge.internal.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TF Voltage Current Configuration</b></em>'.
 *
 * @author Theo Weiss
 * @since 1.5.0
 *        <!-- end-user-doc -->
 *
 *        <p>
 *        The following features are supported:
 *        </p>
 *        <ul>
 *        <li>{@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getAveraging
 *        <em>Averaging</em>}</li>
 *        <li>
 *        {@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getVoltageConversionTime
 *        <em>Voltage Conversion Time</em>}</li>
 *        <li>
 *        {@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getCurrentConversionTime
 *        <em>Current Conversion Time</em>}</li>
 *        </ul>
 *
 * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getTFVoltageCurrentConfiguration()
 * @model
 * @generated
 */
public interface TFVoltageCurrentConfiguration extends TFConfig {
    /**
     * Returns the value of the '<em><b>Averaging</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Averaging</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Averaging</em>' attribute.
     * @see #setAveraging(Short)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getTFVoltageCurrentConfiguration_Averaging()
     * @model unique="false"
     * @generated
     */
    Short getAveraging();

    /**
     * Sets the value of the
     * '{@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getAveraging
     * <em>Averaging</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Averaging</em>' attribute.
     * @see #getAveraging()
     * @generated
     */
    void setAveraging(Short value);

    /**
     * Returns the value of the '<em><b>Voltage Conversion Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Voltage Conversion Time</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Voltage Conversion Time</em>' attribute.
     * @see #setVoltageConversionTime(Short)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getTFVoltageCurrentConfiguration_VoltageConversionTime()
     * @model unique="false"
     * @generated
     */
    Short getVoltageConversionTime();

    /**
     * Sets the value of the
     * '{@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getVoltageConversionTime
     * <em>Voltage Conversion Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Voltage Conversion Time</em>' attribute.
     * @see #getVoltageConversionTime()
     * @generated
     */
    void setVoltageConversionTime(Short value);

    /**
     * Returns the value of the '<em><b>Current Conversion Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Current Conversion Time</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Current Conversion Time</em>' attribute.
     * @see #setCurrentConversionTime(Short)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getTFVoltageCurrentConfiguration_CurrentConversionTime()
     * @model unique="false"
     * @generated
     */
    Short getCurrentConversionTime();

    /**
     * Sets the value of the
     * '{@link org.openhab.binding.tinkerforge.internal.model.TFVoltageCurrentConfiguration#getCurrentConversionTime
     * <em>Current Conversion Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Current Conversion Time</em>' attribute.
     * @see #getCurrentConversionTime()
     * @generated
     */
    void setCurrentConversionTime(Short value);

} // TFVoltageCurrentConfiguration
