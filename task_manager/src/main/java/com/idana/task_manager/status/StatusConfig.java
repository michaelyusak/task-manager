package com.idana.task_manager.status;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatusConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerStatus(StatusRepository repository) {
        return args -> {
            Status done = new Status(
                "done",
                LocalDate.now(),
                LocalDate.now()
            );

            Status pending = new Status(
                "pending",
                LocalDate.now(),
                LocalDate.now()
            );

            repository.saveAll(java.util.List.of(done, pending));
        };
    }
}
