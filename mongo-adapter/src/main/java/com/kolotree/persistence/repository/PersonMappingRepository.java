package com.kolotree.persistence.repository;

import com.kolotree.model.Person;
import com.kolotree.persistence.converters.ModelConverter;
import org.springframework.data.mongodb.repository.MongoRepository;

public class PersonMappingRepository extends MappingRepository<Person, com.kolotree.persistence.model.Person> {
    public PersonMappingRepository(ModelConverter<Person, com.kolotree.persistence.model.Person> converter,
                                   MongoRepository<com.kolotree.persistence.model.Person, String> springMongoRepository) {
        super(converter, springMongoRepository);
    }
}
