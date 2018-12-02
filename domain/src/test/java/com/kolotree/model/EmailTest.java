package com.kolotree.model;

import org.junit.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class EmailTest {
    @Test
    public void testEmailCanNotBeCreatedFromNullString() {
        var emailEither = Email.emailFrom(null);

        assertThat(emailEither).isLeft();
    }

    @Test
    public void testEmailCanNotBeCreatedFromEmptyString() {
        var emailEither = Email.emailFrom("");

        assertThat(emailEither).isLeft();
    }


    @Test
    public void testEmailCanNotBeCreatedFromInvalidEmailString() {
        var emailEither = Email.emailFrom("someString.com");

        assertThat(emailEither).isLeft();
    }

    @Test
    public void testEmailCanNotBeCreatedFromValidEmailString() {
        var emailEither = Email.emailFrom("someAddr@gmail.com");

        assertThat(emailEither).isRight();
    }
}
