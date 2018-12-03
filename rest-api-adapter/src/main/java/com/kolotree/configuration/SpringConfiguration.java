package com.kolotree.configuration;

import com.kolotree.model.Person;
import com.kolotree.persistence.converters.PersonConverter;
import com.kolotree.persistence.repository.PersonMappingRepository;
import com.kolotree.repository.ports.Repository;
import com.kolotree.service.PersonServiceAdapter;
import com.kolotree.service.ports.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public class SpringConfiguration {

    @Bean
    public PersonConverter personConverter() {
        return new PersonConverter();
    }

    @Bean
    public Repository<Person> personRepository(MongoRepository<com.kolotree.persistence.model.Person, String> mongoRepository) {
        return new PersonMappingRepository(personConverter(), mongoRepository);
    }

    @Bean
    public PersonService personService(MongoRepository<com.kolotree.persistence.model.Person, String> mongoRepository) {
        return new PersonServiceAdapter(personRepository(mongoRepository));
    }

}
