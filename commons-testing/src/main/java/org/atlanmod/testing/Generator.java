/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing;

/**
 *
 * An object able to randomly generate values of different data types
 *
 * @param <T> the type of the values to be generated
 */
public interface Generator <T>  {

    /**
     * function responsible for generating values
     *
     * @return single value of the type T
     */
    T generate() ;
    
    /**
     * Returns all of the data types the current class is able to generate.
     *
     * @return an array of class types.
     */
    Class<T>[] types();

}
