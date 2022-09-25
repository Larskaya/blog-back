package com.spring.project.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository) {
        return args -> {
            User bob = new User(
                    "bob",
                    "12345"
            );
            User tim = new User(
                    "tim",
                    "54321"
            );
            repository.saveAll(
                    List.of(bob, tim)
            );
        };
    }
}
