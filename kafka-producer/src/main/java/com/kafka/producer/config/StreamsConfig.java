package com.kafka.producer.config;

import com.kafka.producer.streams.GreetingsSink;
import com.kafka.producer.streams.GreetingsSource;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({GreetingsSource.class, GreetingsSink.class})
public class StreamsConfig {

}
