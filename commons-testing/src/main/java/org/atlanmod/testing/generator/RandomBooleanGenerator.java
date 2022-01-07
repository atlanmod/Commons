/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing.generator;

import org.atlanmod.testing.Generator;

import java.util.Random;

/**
 *
 *  Generator class for values of the type Boolean.
 *
 */
public class RandomBooleanGenerator implements Generator<Boolean> {

    @Override
    /**
     * Generates a random boolean value.
     *
     * @return a boolean value
     */
    public Boolean generate() {
        Random r = new Random();
        boolean bool = r.nextBoolean();
        return bool;
    }

    @Override
    /**
     * Returns all of the variation of the boolean data type the current class is able to generate.
     *
     * @return an array of class types.
     */
    public Class<Boolean>[] types() {
        Class[] types={Boolean.class};
        return types;
    }
}
