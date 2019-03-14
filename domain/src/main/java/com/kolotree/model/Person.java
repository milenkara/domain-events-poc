package com.kolotree.model;

import com.kolotree.common.AggregateRoot;
import com.kolotree.common.Id;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Person extends AggregateRoot {

    private Name firstName;
    private Option<Name> middleName;
    private Name lastName;
    private Email email;
    private Address address;

    private Person(Id id,
                   Name firstName,
                   Option<Name> middleName,
                   Name lastName,
                   Email email,
                   Address address) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public static Either<String, Person> personFrom(Id id,
                                                    Name firstName,
                                                    Option<Name> middleName,
                                                    Name lastName,
                                                    Email email,
                                                    Address address) {
        return Validation.combine(validate(id),
                           validate(firstName),
                           validate(middleName),
                           validate(lastName),
                           validate(email),
                           validate(address))
                .ap(Person::new)
                .toEither()
                .mapLeft(s -> String.join(", ", s));
    }

    public static Either<String, Person> personFrom(Name firstName,
                                                    Option<Name> middleName,
                                                    Name lastName,
                                                    Email email,
                                                    Address address) {

        var id = Id.idFrom(UUID.randomUUID().toString()).get();

        return personFrom(id, firstName, middleName, lastName, email, address);
    }

    private static <T> Validation<String, T> validate(T data) {
        return data == null ?
                Validation.invalid("null argument provided") :
                Validation.valid(data);
    }

}
