package com.kafka.producer.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonSource {

    String OUTPUT = "persons-out";

    @Output(OUTPUT)
    MessageChannel outboundPersons();

}
