package com.kafka.consumer.controller;

import com.kafka.consumer.streams.Person;
import com.kafka.consumer.streams.PersonListener;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PersonConsumerController {

    private PersonListener personListener;

    public PersonConsumerController(PersonListener personListener) {
        this.personListener = personListener;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/persons")
    public Flux<Person> list() {
        return this.personListener.getRecordFlux();
    }


}
