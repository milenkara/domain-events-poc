package com.kolotree.persistence.repository;

import com.kolotree.model.Person;
import com.kolotree.persistence.converters.ModelConverter;

public class PersonMappingRepository extends MappingRepository<Person, com.kolotree.persistence.model.Person> {
    public PersonMappingRepository(ModelConverter<Person, com.kolotree.persistence.model.Person> converter) {
        super(converter);
    }
}
