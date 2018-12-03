package com.kolotree.persistence.repository;

import com.kolotree.persistence.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<Person, String> {
}
