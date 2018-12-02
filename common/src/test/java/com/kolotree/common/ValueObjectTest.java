package com.kolotree.common;

import io.vavr.collection.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValueObjectTest {

    private class Number extends ValueObject {

        private final int value;

        private Number(int value) {
            this.value = value;
        }

        @Override
        protected List<Object> GetEqualityComponents() {
            return List.of(value);
        }
    }

    private class Letter extends ValueObject {

        private final char value;

        private Letter(char value) {
            this.value = value;
        }

        @Override
        protected List<Object> GetEqualityComponents() {
            return List.of(value);
        }
    }

    @Test
    public void testTwoNumbersWithTheSameValueAreStructurallyEqual() {
        var numberFive = new Number(5);
        var anotherNumberFive = new Number(5);

        Assertions.assertEquals(numberFive, anotherNumberFive);
    }

    @Test
    public void testTwoNumbersWithDifferentValueAreNotStructurallyEqual() {
        var numberFive = new Number(5);
        var numberEight = new Number(8);

        Assertions.assertNotEquals(numberFive, numberEight);
    }

    @Test
    public void testCompareNumberToNullShouldReturnFalse() {
        var numberFive = new Number(5);

        Assertions.assertNotEquals(null, numberFive);
    }

    @Test
    public void testCompareValueObjectsOfDifferentTypeShouldReturnFalse() {
        var numberFive = new Number(5);
        var letterA = new Letter('A');

        Assertions.assertNotEquals(numberFive, letterA);
    }
}
