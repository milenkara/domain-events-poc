package com.kolotree.model;

import com.kolotree.common.ValueObject;
import io.vavr.collection.List;
import io.vavr.control.Either;
import lombok.Getter;

@Getter
public class Address extends ValueObject {

    private String street;
    private String city;
    private int number;

    private Address(String street, String city, int number) {
        this.street = street;
        this.city = city;
        this.number = number;
    }

    @Override
    protected List<Object> GetEqualityComponents() {
        return List.of(street, city, number);
    }

    public static Either<String, Address> addressFrom(String street, String city, int number) {
        if(street == null || street.isEmpty()) {
            return Either.left("Argument street is null/empty.");
        }
        if(city == null || city.isEmpty()) {
            return Either.left("Argument city is null/empty.");
        }
        if(number <= 0) {
            return Either.left("Argument number cannot be less than zero.");
        }

        return Either.right(new Address(street, city, number));
    }
}
