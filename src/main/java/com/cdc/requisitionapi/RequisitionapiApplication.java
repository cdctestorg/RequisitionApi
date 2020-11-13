package com.cdc.requisitionapi;

import com.cdc.requisitionapi.entity.Requisition;
import com.cdc.requisitionapi.repository.RequisitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RequisitionapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequisitionapiApplication.class, args);
    }


    @Bean
    public CommandLineRunner sampleData(RequisitionRepository requisitionRepository) {
        return args -> {
            requisitionRepository.save(new Requisition(1L, "Developer 1"));
            requisitionRepository.save(new Requisition(2L, "QA 2"));
            requisitionRepository.save(new Requisition(3L, "PM 3"));
        };
    }

}
