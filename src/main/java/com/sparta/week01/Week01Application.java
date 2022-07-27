package com.sparta.week01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week01Application {

    public static void main(String[] args) {
        SpringApplication.run(Week01Application.class, args);
    }

}