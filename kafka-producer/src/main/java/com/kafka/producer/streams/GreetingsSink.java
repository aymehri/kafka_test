package com.kafka.producer.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsSink {

    String INPUT = "greetings-in";

    @Input(INPUT)
    SubscribableChannel inboundGreetings();


}
