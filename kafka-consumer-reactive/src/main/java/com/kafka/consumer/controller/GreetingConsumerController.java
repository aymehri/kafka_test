package com.kafka.consumer.controller;

import com.kafka.consumer.service.GreetingsConsumerService;
import com.kafka.consumer.streams.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class GreetingConsumerController {

    private final GreetingsConsumerService service;

    public GreetingConsumerController(GreetingsConsumerService service) {
        this.service = service;
    }

    @GetMapping("/greetings")
    Flux<Greetings> list() {
        Duration time = Duration.ofSeconds(1);
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> Greetings.builder()
                        .message("Hello")
                        .timestamp(System.currentTimeMillis())
                        .build());
        // return this.service.getAll();
    }


}
