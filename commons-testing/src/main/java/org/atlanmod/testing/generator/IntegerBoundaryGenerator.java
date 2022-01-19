/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing.generator;

import org.atlanmod.commons.Guards;
import org.atlanmod.testing.Generator;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * Generator class for bound values of the type Integer.
 */
public class IntegerBoundaryGenerator implements Generator<Integer> {

    private int[] values;
    private Random random = new Random();

    public IntegerBoundaryGenerator(){
        this(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE});
    }

    public IntegerBoundaryGenerator(int[] values) {
        Guards.checkGreaterThan(values.length, 0);
        this.values = Arrays.copyOfRange(values, 0, values.length) ;
    }

    /**
     * Generates a single integer at a time
     * Produced values are random using class java.util.Random
     *
     * @return a single integer value
     */
    @Override
    public Integer generate() {
        int index = random.nextInt(values.length);
        return this.values[index];
    }

    /**
     *  Returns all of the variation of the integer data type the current class is able to generate.
     *
     * @return an array of class types.
     */
    @Override
    public Class<Integer>[] types() {
        return new Class[]{Integer.class, int.class};
    }
}
