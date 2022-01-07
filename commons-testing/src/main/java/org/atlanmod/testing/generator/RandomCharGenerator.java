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
 * Generator class for values of the type Char.
 *
 */
public class RandomCharGenerator implements Generator<Character> {
    @Override
    /**
     * Generates random Char values, alphabets or numerical characters .
     *
     * @return a single char value
     */
    public Character generate() {
        Random random = new Random();
        int randomInt = random.nextInt(10) + 48;
        int randomUpperCaseAlphabet = random.nextInt(26) + 65;
        int randomLowerCaseAlphabet = random.nextInt(26) + 97;
        int[] possibleValues = {randomInt, randomLowerCaseAlphabet, randomUpperCaseAlphabet};
        int choice = random.nextInt(3);
        char generatedChar = (char)possibleValues[choice];
        return generatedChar;
    }

    @Override
    /**
     * Returns all of the variation of the Char data type the current class is able to generate.
     *
     * @return an array of class types.
     */
    public Class[] types() {
        Class[] types={Character.class};
        return types;
    }
}
