package com.kafka.consumer.controller;

import com.kafka.consumer.service.GreetingsConsumerService;
import com.kafka.consumer.streams.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GreetingConsumerController {

    private final GreetingsConsumerService service;

    public GreetingConsumerController(GreetingsConsumerService service) {
        this.service = service;
    }

    @GetMapping("/greetings")
    public Flux<Greetings> list() {
        return this.service.getAll();
    }


}
