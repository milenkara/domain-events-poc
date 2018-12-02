package com.kolotree.common;

import org.junit.jupiter.api.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class IdTest {

    @Test
    public void testFactoryMethodReturnsErrorForNullString() {
        var idEither = Id.idFrom(null);
        assertThat(idEither).isLeft();
    }

    @Test
    public void testFactoryMethodReturnsErrorForEmptyString() {
        var idEither = Id.idFrom("");
        assertThat(idEither).isLeft();
    }

    @Test
    public void testFactoryMethodReturnsValidIdForNonEmptyString() {
        var idEither = Id.idFrom("identity");
        assertThat(idEither).isRight();
    }
}
