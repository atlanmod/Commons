package org.atlanmod.commons.predicate;

import org.junit.jupiter.api.Test;

import static org.atlanmod.commons.Preconditions.requireThat;
import static org.atlanmod.commons.predicate.TestUtility.throwsPreconditionError;

class StringPredicateTest {

    @Test
    void falseContainsRaisesError() {
        throwsPreconditionError(() ->
                requireThat("atlanmod-commons").contains("other"));
    }

    @Test
    void trueContainsDoesNothing() {
        requireThat("atlanmod-commons")
                .contains("atlanmod");
    }

    @Test
    void trueIsNotEmptyDoesNothing() {
        requireThat("a").isNotEmpty();
    }

    @Test
    void falseIsNotEmptyRaisesError() {
        throwsPreconditionError(() -> requireThat("").isNotEmpty());
    }

    @Test
    void lengthIsGreaterThanDoesNothing() {
        requireThat("aaabbbaaa").lengthIsGreaterThan(5);
    }

    @Test
    void lengthIsNotLessThanRaisesError() {
        throwsPreconditionError( () -> requireThat("abcd").lengthIsGreaterThan(5));
    }

    @Test
    void stringIsBlankDoesNothing() {
        requireThat("   ").isBlank();
    }

    @Test
    void stringIsNotBlankDoesNothing() {
        requireThat("abcd").isNotBlank();
    }

    @Test
    void stringIsBlankRaisesError() {
        throwsPreconditionError( () -> requireThat("abcd").isBlank());
    }

    @Test
    void stringIsNotBlankRaisesError() {
        throwsPreconditionError( () ->  requireThat("     ").isNotBlank());
    }
}
