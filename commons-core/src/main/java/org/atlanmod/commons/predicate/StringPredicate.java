/*
 * Copyright (c) 2021 Atlanmod.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v2.0 which accompanies
 * this distribution, and is available at https://www.eclipse.org/legal/epl-2.0/
 */

package org.atlanmod.commons.predicate;

/**
 *
 * @author sunye
 * @since 1.1.0
 */
public class StringPredicate extends ObjectPredicate<StringPredicate, String> {

    public StringPredicate(PredicateContext context, String value) {
        super(context, value);
    }

    public StringPredicate contains(String substr) {
        boolean expected = value.contains(substr);
        if (!expected) {
            context.send("\nExpecting String value to contain (%s)", substr);
        }
        return this;
    }


    public StringPredicate isNotEmpty() {
        boolean expected = !value.equals("");
        if (!expected) {
            context.send("\nExpecting String value not to be empty");
        }
        return me();
    }
}

