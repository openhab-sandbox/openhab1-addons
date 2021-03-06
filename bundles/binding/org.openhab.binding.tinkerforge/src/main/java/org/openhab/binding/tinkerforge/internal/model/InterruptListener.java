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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interrupt Listener</b></em>'.
 *
 * @author Theo Weiss
 * @since 1.4.0
 *        <!-- end-user-doc -->
 *
 *        <p>
 *        The following features are supported:
 *        </p>
 *        <ul>
 *        <li>{@link org.openhab.binding.tinkerforge.internal.model.InterruptListener#getDebouncePeriod <em>Debounce
 *        Period</em>}</li>
 *        </ul>
 *
 * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getInterruptListener()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InterruptListener extends EObject {
    /**
     * Returns the value of the '<em><b>Debounce Period</b></em>' attribute.
     * The default value is <code>"100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Debounce Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Debounce Period</em>' attribute.
     * @see #setDebouncePeriod(long)
     * @see org.openhab.binding.tinkerforge.internal.model.ModelPackage#getInterruptListener_DebouncePeriod()
     * @model default="100" unique="false"
     * @generated
     */
    long getDebouncePeriod();

    /**
     * Sets the value of the '{@link org.openhab.binding.tinkerforge.internal.model.InterruptListener#getDebouncePeriod
     * <em>Debounce Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Debounce Period</em>' attribute.
     * @see #getDebouncePeriod()
     * @generated
     */
    void setDebouncePeriod(long value);

} // InterruptListener
