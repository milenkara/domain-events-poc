package com.kolotree.configuration;

import com.kolotree.model.Person;
import com.kolotree.persistence.converters.PersonConverter;
import com.kolotree.persistence.repository.PersonMappingRepository;
import com.kolotree.persistence.repository.PersonRepository;
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
    public Repository<Person> domainPersonRepository(PersonRepository personRepository) {
        return new PersonMappingRepository(personConverter(), personRepository);
    }

    @Bean
    public PersonService personService(PersonRepository personRepository) {
        return new PersonServiceAdapter(domainPersonRepository(personRepository));
    }

}
