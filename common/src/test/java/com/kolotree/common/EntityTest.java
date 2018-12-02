package com.kolotree.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {

    public class Person extends Entity {
        private final String name;

        protected Person(Id id, String name) {
            super(id);
            this.name = name;
        }
    }

    @Test
    public void testTwoPersonWithSameIdsAreEqual() {
        var personOne = new Person(Id.idFrom("1234").get(), "John");
        var personTwo = new Person(Id.idFrom("1234").get(), "Joe");

        Assertions.assertEquals(personOne, personTwo);
    }

    @Test
    public void testTwoPersonWithDifferentIdsAreNotEqual() {
        var personOne = new Person(Id.idFrom("1234").get(), "John");
        var personTwo = new Person(Id.idFrom("5678").get(), "John");

        Assertions.assertNotEquals(personOne, personTwo);
    }

}
