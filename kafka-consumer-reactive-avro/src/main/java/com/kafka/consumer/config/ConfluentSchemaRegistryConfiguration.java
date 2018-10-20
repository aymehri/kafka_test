package com.kafka.consumer.config;

//@Configuration
public class ConfluentSchemaRegistryConfiguration {

    // uncomment this if you want to use ConfluentSchemaRegistry
    /*
    @Bean
    public SchemaRegistryClient schemaRegistryClient(@Value("${spring.cloud.stream.schemaRegistryClient.endpoint}") String endpoint){
        ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
        client.setEndpoint(endpoint);
        return client;
    }
    */

}
