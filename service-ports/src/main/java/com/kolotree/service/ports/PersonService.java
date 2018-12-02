package com.kolotree.service.ports;

import com.kolotree.model.Person;
import io.vavr.collection.List;

public interface PersonService {
    List<Person> getAll();
    Person add(Person person);
}
