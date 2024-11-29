package com.example.acessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // meta annotation, main method is the entry point
// bean - object managed by Spring container
// service, controller, repository

public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    // @Bean annotation is a factory method
    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("Jane", "Doe"));
            customerRepository.save(new Customer("Bob", "Smith"));
            customerRepository.save(new Customer("John", "Doe"));

            log.info("Customers found with findAll():");
            log.info("------");
            customerRepository.findAll().forEach(customer -> log.info(customer.toString()));
            // java stream breakdown:
            // findAll() - return type Iterable<T>, iterator for type T
            // forEach() - terminal operation
            // log.info(customer.toString()) - logging info about every customer
            log.info("");

            Customer customer = customerRepository.findById(1L);
            log.info("Customers found with findById(1L):");
            log.info("------");
            log.info(customer.toString());
            log.info("");

            log.info("Customers found with findByLastName(\"Doe\"):");
            log.info("------");
            customerRepository.findByLastName("Doe").forEach(specificCustomer -> log.info(specificCustomer.toString()));
            log.info("");
        };
    }
}
