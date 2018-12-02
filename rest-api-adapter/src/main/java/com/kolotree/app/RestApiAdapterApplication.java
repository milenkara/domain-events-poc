package com.kolotree.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan("com.kolotree")
@EnableMongoRepositories("com.kolotree")
public class RestApiAdapterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApiAdapterApplication.class, args);
    }
}
