package com.kolotree.controllers;

import com.kolotree.model.dto.DtoDomainConverter;
import com.kolotree.model.dto.PersonDto;
import com.kolotree.service.ports.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<?>> getAll() {
        return Mono.just(
                ResponseEntity.ok(
                        personService.getAll()
                                .map(DtoDomainConverter::convertDomainToDto)
                                .asJava()
                )
        );
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<String>> add(@RequestBody PersonDto personDto) {
        return Mono.fromSupplier(() -> DtoDomainConverter.convertDtoToDomain(personDto)
                .map(person -> personService.add(person))
                .map(DtoDomainConverter::convertDomainToDto)
                .fold(errString -> ResponseEntity.badRequest().body(errString),
                      person -> ResponseEntity.ok("OK")
                )
        );
    }
}
