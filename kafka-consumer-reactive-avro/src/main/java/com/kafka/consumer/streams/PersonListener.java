package com.kafka.consumer.streams;

import com.kafka.avro.PersonAvro;
import com.kafka.consumer.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class PersonListener {

    private volatile Flux<Person> recordFlux;

    private final PersonMapper personMapper;

    public PersonListener(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @StreamListener(PersonSink.INPUT)
    public void handlePersons(@Payload Flux<PersonAvro> personAvro) {
        this.recordFlux = personAvro.map(e -> personMapper.toModel(e));
        recordFlux.subscribe( x -> log.info("Received person: {}", x));
    }

    public Flux<Person> getRecordFlux() {
        return recordFlux;
    }

}
