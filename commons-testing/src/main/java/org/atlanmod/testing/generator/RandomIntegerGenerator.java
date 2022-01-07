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
 * Generator class for values of the type Integer.
 */
public class RandomIntegerGenerator implements Generator<Integer> {
    private Random random = new Random();
    /**
     * Generates a single integer at a time
     * Produced values are random using class java.util.Random
     *
     * @return a single integer value
     */
    @Override
    public Integer generate() {
        int min= 0;
        int max= 20;
        return random.nextInt((max - min) + 1);
    }

    @Override
    /**
     *  Returns all of the variation of the integer data type the current class is able to generate.
     *
     * @return an array of class types.
     */
    public Class<Integer>[] types() {
        return new Class[]{Integer.class, int.class};
    }
}
