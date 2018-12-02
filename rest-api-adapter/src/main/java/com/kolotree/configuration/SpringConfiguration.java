package com.kolotree.configuration;

import com.kolotree.model.Person;
import com.kolotree.persistence.converters.PersonConverter;
import com.kolotree.persistence.repository.PersonMappingRepository;
import com.kolotree.repository.ports.Repository;
import com.kolotree.service.PersonServiceAdapter;
import com.kolotree.service.ports.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public PersonConverter personConverter() {
        return new PersonConverter();
    }

    @Bean
    public Repository<Person> personRepository() {
        return new PersonMappingRepository(personConverter());
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceAdapter(personRepository());
    }
}
