/*
 * Copyright (c) 2013-2017 Atlanmod INRIA LINA Mines Nantes.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 */

package fr.inria.atlanmod.commons.hash;

import fr.inria.atlanmod.commons.primitive.Strings;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An object that calculates a {@link HashCode} from a value.
 */
@FunctionalInterface
@ParametersAreNonnullByDefault
public interface Hasher {

    /**
     * Calculates the {@link HashCode} of the given {@code byte} array.
     *
     * @param data the {@code byte} array to hash
     *
     * @return a new hash code
     */
    @Nonnull
    HashCode hash(byte[] data);

    /**
     * Calculates the {@link HashCode} of the given {@code data}.
     *
     * @param data the string to hash
     *
     * @return a new hash code
     */
    @Nonnull
    default HashCode hash(String data) {
        return hash(Strings.toBytes(data));
    }
}
