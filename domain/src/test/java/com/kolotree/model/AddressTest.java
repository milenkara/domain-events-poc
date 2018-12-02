package com.kolotree.model;

import org.junit.Test;

import static com.kolotree.model.TestObjects.city;
import static com.kolotree.model.TestObjects.number;
import static com.kolotree.model.TestObjects.street;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

public class AddressTest {

    @Test
    public void testCanNotCreateAddressForNullStreet() {
        var addressEither = Address.addressFrom(null, city, number);

        assertThat(addressEither).isLeft();
    }

    @Test
    public void testCanNotCreateAddressForEmptyStreet() {
        var addressEither = Address.addressFrom("", city, number);

        assertThat(addressEither).isLeft();
    }

    @Test
    public void testCanNotCreateAddressForNullCity() {
        var addressEither = Address.addressFrom(street, null, number);

        assertThat(addressEither).isLeft();
    }

    @Test
    public void testCanNotCreateAddressForEmptyCity() {
        var addressEither = Address.addressFrom("", null, number);

        assertThat(addressEither).isLeft();
    }

    @Test
    public void testCreateAddressForValidParameters() {
        var addressEither = Address.addressFrom(street, city, number);

        assertThat(addressEither).isRight();
    }
}
