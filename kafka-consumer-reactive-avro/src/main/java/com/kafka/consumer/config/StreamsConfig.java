package com.kafka.consumer.config;

import com.kafka.consumer.streams.PersonSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;

@EnableBinding({PersonSink.class})
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
