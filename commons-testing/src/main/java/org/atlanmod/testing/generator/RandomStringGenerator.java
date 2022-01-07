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
 * Generator class for values of the type String.
 *
 */
public class RandomStringGenerator implements Generator<String> {
    private Random random = new Random();

    /**
     * Generates random String values containing a mix of numerical characters and alphabets.
     *
     * @return a single String value
     */
    @Override
 public String generate() {
        int length= random.nextInt(10)+1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(10) + 48;
            int randomUpperCaseAlphabet = random.nextInt(26) + 65;
            int randomLowerCaseAlphabet = random.nextInt(26) + 97;
            int[] possibleValues = {randomInt, randomLowerCaseAlphabet, randomUpperCaseAlphabet};
            int choice = random.nextInt(3);
            char generatedChar = (char)possibleValues[choice];
            sb.append(generatedChar);
        }
        return sb.toString();
    }

    @Override
    /**
     * Returns all of the variations of the String data type the current class is able to generate.
     *
     * @return an array of class types.
     */
    public Class<String>[] types() {
        return new Class[]{String.class};
    }
}
