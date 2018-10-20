package com.kafka.producer.config;

import com.kafka.producer.streams.PersonSink;
import com.kafka.producer.streams.PersonSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.MimeType;

@EnableBinding({PersonSource.class, PersonSink.class})
@EnableSchemaRegistryClient
public class StreamsConfig {

    /*
    @Bean
    public MessageConverter userMessageConverter() {
        AvroSchemaMessageConverter converter = new AvroSchemaMessageConverter(MimeType.valueOf("avro/bytes"));
        converter.setSchemaLocation(new ClassPathResource("avro/person.avsc"));
        return converter;
    }*/

}
