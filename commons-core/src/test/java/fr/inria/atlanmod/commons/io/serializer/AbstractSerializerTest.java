/*
 * Copyright (c) 2017 Atlanmod, Inria, LS2N, and IMT Nantes.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */

package fr.inria.atlanmod.commons.io.serializer;

import fr.inria.atlanmod.commons.AbstractTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An abstract test-case that checks the behavior of {@link Serializer} instances.
 */
@ParametersAreNonnullByDefault
public abstract class AbstractSerializerTest extends AbstractTest {

    /**
     * Serializes then deserializes the given {@code value} with the specified {@code serializer}, with the basic
     * methods.
     *
     * @param value      the sample value
     * @param serializer the serializer to use
     * @param <T>        the type of the (de)serialized value
     *
     * @return the value after processing
     *
     * @throws IOException if an I/O error occurs during the serialization
     */
    protected <T> T process(T value, Serializer<T> serializer) throws IOException {
        byte[] bytes = serializer.serialize(value);

        return serializer.deserialize(bytes);
    }

    /**
     * Serializes then deserializes the given {@code value} with the specified {@code serializer}, by using a stream.
     *
     * @param value      the sample value
     * @param serializer the serializer to use
     * @param <T>        the type of the (de)serialized value
     *
     * @return the value after processing
     *
     * @throws IOException if an I/O error occurs during the serialization
     */
    protected <T> T processWithStream(T value, Serializer<T> serializer) throws IOException {
        byte[] data;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(baos)) {
            serializer.serialize(value, out);
            out.flush();

            data = baos.toByteArray();
        }

        try (ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return serializer.deserialize(in);
        }
    }
}