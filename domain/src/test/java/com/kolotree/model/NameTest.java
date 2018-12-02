package com.kolotree.model;

import org.junit.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class NameTest {

    @Test
    public void testNameCanNotBeCreatedFromNullString() {
        var nameEither = Name.nameFrom(null);

        assertThat(nameEither).isLeft();
    }

    @Test
    public void testNameCanNotBeCreatedFromEmptyString() {
        var nameEither = Name.nameFrom("");

        assertThat(nameEither).isLeft();
    }

    @Test
    public void testCreateValidNameFromValidString() {
        var nameEither = Name.nameFrom("John");

        assertThat(nameEither).isRight();
    }
}
