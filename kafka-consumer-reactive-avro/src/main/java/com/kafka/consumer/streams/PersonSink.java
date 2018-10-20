package com.kafka.consumer.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PersonSink {

    String INPUT = "persons-in";

    @Input(INPUT)
    SubscribableChannel inboundPersons();

}
