package com.kolotree.model;

import org.junit.Test;

import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class PersonTest {

    @Test
    public void testCanNotCreatePersonForNullId() {
        var personEither = Person.personFrom(null,
                                             TestObjects.firstName,
                                             TestObjects.middleName,
                                             TestObjects.lastName,
                                             TestObjects.email,
                                             TestObjects.address);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCanNotCreatePersonForNullFirstName() {
        var personEither = Person.personFrom(TestObjects.id,
                                             null,
                                             TestObjects.middleName,
                                             TestObjects.lastName,
                                             TestObjects.email,
                                             TestObjects.address);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCanNotCreatePersonForNullMiddleName() {
        var personEither = Person.personFrom(TestObjects.id,
                                             TestObjects.firstName,
                                             null,
                                             TestObjects.lastName,
                                             TestObjects.email,
                                             TestObjects.address);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCanNotCreatePersonForNullLastName() {
        var personEither = Person.personFrom(TestObjects.id,
                                             TestObjects.firstName,
                                             TestObjects.middleName,
                                             null,
                                             TestObjects.email,
                                             TestObjects.address);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCanNotCreatePersonForNullEmail() {
        var personEither = Person.personFrom(TestObjects.id,
                                             TestObjects.firstName,
                                             TestObjects.middleName,
                                             TestObjects.lastName,
                                             null,
                                             TestObjects.address);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCanNotCreatePersonForNullAddress() {
        var personEither = Person.personFrom(TestObjects.id,
                                             TestObjects.firstName,
                                             TestObjects.middleName,
                                             TestObjects.lastName,
                                             TestObjects.email,
                                             null);

        assertThat(personEither).isLeft();
    }

    @Test
    public void testCreatePersonForValidData() {
        var personEither = Person.personFrom(TestObjects.id,
                                             TestObjects.firstName,
                                             TestObjects.middleName,
                                             TestObjects.lastName,
                                             TestObjects.email,
                                             TestObjects.address);

        assertThat(personEither).isRight();
    }
}
