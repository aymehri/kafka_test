package com.kafka.consumer.streams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
@EnableBinding({GreetingsSink.class})
public class GreetingsReactorListnerService {

    @StreamListener(GreetingsSink.INPUT)
    public void handleGreetings(@Payload Flux<Greetings> greetings) {
        greetings.subscribe( x -> log.info("Received greetings: {}", x));
    }

}
