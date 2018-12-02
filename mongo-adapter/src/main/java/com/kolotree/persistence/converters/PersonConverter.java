package com.kolotree.persistence.converters;

import com.kolotree.common.Id;
import com.kolotree.model.Address;
import com.kolotree.model.Email;
import com.kolotree.model.Name;
import com.kolotree.persistence.model.Person;
import io.vavr.control.Option;

import static com.kolotree.model.Person.personFrom;

public class PersonConverter implements ModelConverter<com.kolotree.model.Person, Person> {

    @Override
    public com.kolotree.model.Person toDomainModel(Person persistenceObj) {
        return personFrom(Id.idFrom(persistenceObj.getId()).get(),
                          Name.nameFrom(persistenceObj.getFirstName()).get(),
                          Option.of(persistenceObj.getMiddleName()).map(mn -> Name.nameFrom(mn).get()),
                          Name.nameFrom(persistenceObj.getLastName()).get(),
                          Email.emailFrom(persistenceObj.getEmail()).get(),
                          Address.addressFrom(persistenceObj.getAddress().getStreet(),
                                              persistenceObj.getAddress().getCity(),
                                              persistenceObj.getAddress().getNumber()).get()).get();
    }

    @Override
    public Person toPersistenceModel(com.kolotree.model.Person domainObj) {
        return new Person(domainObj.getId().getId(),
                          domainObj.getFirstName().getNameAsString(),
                          domainObj.getMiddleName().map(Name::getNameAsString).getOrNull(),
                          domainObj.getLastName().getNameAsString(),
                          domainObj.getEmail().getEmailAsString(),
                          new com.kolotree.persistence.model.Address(domainObj.getAddress().getStreet(),
                                                                     domainObj.getAddress().getCity(),
                                                                     domainObj.getAddress().getNumber()));

    }
}
