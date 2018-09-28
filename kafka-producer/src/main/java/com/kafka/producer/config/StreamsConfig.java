package com.kafka.producer.config;

import com.kafka.producer.streams.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {

}
