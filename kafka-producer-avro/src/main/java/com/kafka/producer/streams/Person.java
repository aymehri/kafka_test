package com.kafka.producer.streams;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private Integer favoriteNumber;
    private String favoriteColor;

}
