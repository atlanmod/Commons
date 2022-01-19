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
public class StringBoundaryGenerator implements Generator<String> {
  private String[] values;
  private Random random = new Random();
  public StringBoundaryGenerator() {
    this(new String[]{"monsieur", "yassine", "el", "kamel", ""});
  }

  public StringBoundaryGenerator(String[] values) {
    Guards.checkGreaterThan(values.length, 0);
    this.values = Arrays.copyOfRange(values, 0, values.length);
  }

  /**
   * Generates random String values containing a mix of numerical characters and alphabets.
   *
   * @return a single String value
   */
  @Override
  public String generate() {
    int index = random.nextInt(values.length);
    return this.values[index];
  }

  /**
   * Returns all of the variations of the String data type the current class is able to generate.
   *
   * @return an array of class types.
   */
  @Override
  public Class<String>[] types() {
    return new Class[]{String.class};
  }
}