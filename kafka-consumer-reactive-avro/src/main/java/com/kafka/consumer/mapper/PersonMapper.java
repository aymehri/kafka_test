package com.kafka.consumer.mapper;

import com.kafka.avro.PersonAvro;
import com.kafka.consumer.streams.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonAvro toAvro(Person person);
    Person toModel(PersonAvro personAvro);

}
