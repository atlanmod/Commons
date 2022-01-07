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

public class StringBoundaryGenerator implements Generator<String> {
  private String[] values;
  private int index;

  public StringBoundaryGenerator() {
    this(new String[] {"monsieur", "yassine", "el", "kamel", ""});
  }

  public StringBoundaryGenerator(String[] values) {
    Guards.checkGreaterThan(values.length, 0);
    this.values = Arrays.copyOfRange(values, 0, values.length);
  }

  @Override
  public String generate() {
    return this.values[index % values.length];
  }

  @Override
  public Class<String>[] types() {
    return new Class[0];
  }


}
