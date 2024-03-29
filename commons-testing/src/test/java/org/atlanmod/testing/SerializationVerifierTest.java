/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class SerializationVerifierTest {

    @Test
    void check() throws IOException, ClassNotFoundException {
        Verifier.verifySerialization(Person.class)
                .withArguments("Anna",25)
                .check();
    }
}
