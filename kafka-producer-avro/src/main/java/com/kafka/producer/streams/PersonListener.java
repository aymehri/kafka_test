package com.kafka.producer.streams;

import com.kafka.avro.PersonAvro;
import com.kafka.producer.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class PersonListener {

    private final PersonMapper personMapper;

    @StreamListener(PersonSink.INPUT)
    public void handlePersons(@Payload PersonAvro personAvro) {
        Person person = personMapper.toModel(personAvro);
        log.info("Received person: {}", person);
    }

}
