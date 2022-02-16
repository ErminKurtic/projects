package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee eki = new Employee ("Eki", "Peki", "ekipeki@gmail.com"
            );

            Employee cattsi = new Employee (
                    "Cattsi", "Battsi", "cattsibattsi@gmail.com"
            );

            repository.saveAll(List.of(eki, cattsi));
        };
    }
}
