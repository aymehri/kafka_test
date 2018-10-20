package com.kafka.producer.mapper;

import com.kafka.producer.streams.Person;
import com.kafka.avro.PersonAvro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonAvro toAvro(Person person);
    Person toModel(PersonAvro personAvro);

}
