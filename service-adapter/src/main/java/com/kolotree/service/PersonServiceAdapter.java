package com.kolotree.service;

import com.kolotree.model.Person;
import com.kolotree.repository.ports.Repository;
import com.kolotree.service.ports.PersonService;
import io.vavr.collection.List;

public class PersonServiceAdapter implements PersonService {

    private Repository<Person> personRepository;

    public PersonServiceAdapter(Repository<Person> personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }
}
