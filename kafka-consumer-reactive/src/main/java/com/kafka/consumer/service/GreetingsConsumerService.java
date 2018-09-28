package com.kafka.consumer.service;

import com.kafka.consumer.streams.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class GreetingsConsumerService {


    public Flux<Greetings> getAll() {
        return Flux.empty();
    }


}
