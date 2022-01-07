/*
 * Copyright (c) 2022 Naomod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */
package org.atlanmod.testing;

import org.atlanmod.commons.reflect.MoreReflection;

import java.io.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Verifies that the {@code serializable()} interface of a class was correctly implemented, checking that:
 *
 * - An object is serializable and serialize it by converting it into a sequence (stream) of bytes
 * - Deserialize by reading the stream of bytes and convert it back into a Java object
 * - The resulting object is equals to the object we want to test.
 *
 * @param <T>
 */
public class SerializationVerifier<T extends Serializable> {
    private Class<T> type;
    private Object[] arguments;
    private  static  final  long serialVersionUID = 1623437;

    /**
     * Creates an instance of {@code SerializationVerifier} for class {@code type}.
     *
     * @param type the class to be verified.
     */
    SerializationVerifier(Class<T> type) {
        this.type = type;
    }

    /**
     * Arguments are used to create a reference instance of class {@code type}. The reference instance is used
     * to be serialized,deserialized in another object and compare it to the resulting object.
     *
     * The types and the length of {@code arguments} must match either a visible constructor or a static
     * method (a factory) that returns an instance of {@code type}.
     *
     *
     * @param arguments an array of instances of {@link Object}.
     * @return the current verifier.
     */
    public SerializationVerifier<T> withArguments(Object... arguments) {
        this.arguments = arguments;
        return this;
    }

    private static Class[] mapToClasses(Object[] objects) {
        return Stream.of(objects)
                .map(Object::getClass)
                .toArray(Class[]::new);
    }

    /**
     * Verifies the implementation of interface {@code serializable()}.
     *
     */
    public void check() throws IOException, ClassNotFoundException {
        Class[] argumentTypes = mapToClasses(arguments);
        Function<Object[], T> instantiator = MoreReflection.getInstantiator(type, argumentTypes);
        Object object = instantiator.apply(arguments);
        // serialiser object
        ByteArrayOutputStream boos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(boos);
        oos.writeObject(object);
        //deserialiser object
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(boos.toByteArray()));
        Object object2 = (Object) ois.readObject();
        assertIsEqual(object,object2);
    }

    public static void assertIsEqual(Object one, Object other) {
        if (!one.equals(other)) {
            throw new AssertionError("Expecting objects to be equal");
        } else if (!other.equals(one)) {
            throw new AssertionError("Equals is supposed to be symmetric");
        } else if (one.hashCode() != other.hashCode()) {
            throw new AssertionError("Equal objects must have the same hash code");
        }
    }
}
