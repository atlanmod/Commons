/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing.generator;

public class SimpleStringGenerator extends StringGenerator {

  public void initializeValues() {
    this.setValues(new String[] {"To be or not to be, this is the question",
            "", "Atlanmod", "Commons", "Testing"});
  }
}
