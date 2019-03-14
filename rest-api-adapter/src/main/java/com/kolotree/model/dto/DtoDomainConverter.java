package com.kolotree.model.dto;

import com.kolotree.model.Address;
import com.kolotree.model.Email;
import com.kolotree.model.Name;
import com.kolotree.model.Person;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class DtoDomainConverter {
    public static Either<String, Person> convertDtoToDomain(PersonDto personDto) {
        if (personDto == null) {
            return Either.left("Argument personDto is null.");
        }

        if (personDto.getAddress() == null) {
            return Either.left("Argument personDto.address is null.");
        }

        return Address.addressFrom(personDto.getAddress().getStreet(),
                                   personDto.getAddress().getCity(),
                                   personDto.getAddress().getNumber())
                .flatMap(address -> Name.nameFrom(personDto.getFirstName())
                        .flatMap(firstName -> Name.nameFrom(personDto.getLastName())
                                .flatMap(lastName -> Email.emailFrom(personDto.getEmail())
                                        .flatMap(email -> {
                                                     var middleNameOpt = Option.of(personDto.getMiddleName()).map(Name::nameFrom);

                                                     if (middleNameOpt.isDefined() && middleNameOpt.get().isLeft()) {
                                                         return Either.left(middleNameOpt.get().getLeft());
                                                     }
                                                     return Person.personFrom(firstName, middleNameOpt.map(Either::get), lastName, email, address);
                                                 }
                                        )
                                )
                        )
                );
    }

    public static PersonDto convertDomainToDto(Person person) {
        return new PersonDto(person.getFirstName().getNameAsString(),
                             person.getMiddleName().map(Name::getNameAsString).getOrNull(),
                             person.getLastName().getNameAsString(),
                             person.getEmail().getEmailAsString(),
                             new AddressDto(person.getAddress().getStreet(),
                                            person.getAddress().getCity(),
                                            person.getAddress().getNumber()));
    }
}
