package com.aymen.streamkafka.config;

import com.aymen.streamkafka.streams.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {

}
