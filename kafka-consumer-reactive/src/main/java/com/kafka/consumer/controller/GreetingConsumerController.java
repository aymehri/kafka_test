package com.kafka.consumer.controller;

import com.kafka.consumer.streams.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class GreetingConsumerController {

    @GetMapping("/greetings")
    Flux<Greetings> list() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(l -> Greetings.builder()
                        .message("Hello")
                        .timestamp(System.currentTimeMillis())
                        .build());
    }


}
