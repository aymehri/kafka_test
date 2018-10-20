package com.kafka.consumer.streams;

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
