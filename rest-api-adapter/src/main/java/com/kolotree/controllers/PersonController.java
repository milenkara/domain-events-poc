package com.kolotree.controllers;

import com.kolotree.service.ports.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    
    Mono<ResponseEntity<?>> getAll() {
        return Mono.just(ResponseEntity.ok(personService.getAll()));
    }
}
