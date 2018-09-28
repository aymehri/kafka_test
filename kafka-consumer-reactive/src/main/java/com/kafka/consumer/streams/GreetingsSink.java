package com.kafka.consumer.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsSink {

    String INPUT = "greetings-in";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();


}
