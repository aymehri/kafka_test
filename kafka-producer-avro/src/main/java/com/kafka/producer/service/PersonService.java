package com.kafka.producer.service;

import com.kafka.avro.PersonAvro;
import com.kafka.producer.mapper.PersonMapper;
import com.kafka.producer.streams.Person;
import com.kafka.producer.streams.PersonSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    private final PersonSource personSource;
    private final PersonMapper personMapper;

    public PersonService(PersonSource personSource, PersonMapper personMapper) {
        this.personSource = personSource;
        this.personMapper = personMapper;
    }

    public void sendPerson(final Person person) {
        log.info("Sending greetings {}", person);

        PersonAvro personAvro = personMapper.toAvro(person);

        MessageChannel messageChannel = personSource.outboundPersons();
        messageChannel.send(MessageBuilder.withPayload(personAvro).build());
    }
}
