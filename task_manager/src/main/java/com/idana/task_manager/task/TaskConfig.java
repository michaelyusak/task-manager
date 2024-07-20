package com.idana.task_manager.task;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {
        return args -> {
            Task doTechnicalTest = new Task (
                "Do technical test",
                1L,
                LocalDate.of(2024, 7, 19),
                LocalDate.of(2024, 7, 19)
            );

            Task cookDinner = new Task (
                "Cook dinner",
                2L,
                LocalDate.of(2024, 7, 19),
                LocalDate.of(2024, 7, 19)
            );

            Task washDishes = new Task (
                "Wash dishes",
                1L,
                LocalDate.of(2024, 7, 19),
                LocalDate.of(2024, 7, 19)
            );

            repository.saveAll(java.util.List.of(doTechnicalTest, cookDinner, washDishes));
        };
    }
}
