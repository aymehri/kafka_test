package com.kafka.consumer.streams;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Greetings {
    private long timestamp;
    private String message;
}
