package com.kafka.producer.controller;

import com.kafka.producer.service.PersonService;
import com.kafka.producer.streams.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("name") String name,
                          @RequestParam("favoriteNumber") Integer favoriteNumber,
                          @RequestParam("favoriteColor") String favoriteColor) {
        Person person = Person.builder()
                .name(name)
                .favoriteNumber(favoriteNumber)
                .favoriteColor(favoriteColor)
                .build();
        personService.sendPerson(person);
    }
}
