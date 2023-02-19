package com.alla.customerservice;

import com.alla.customerservice.entities.Customer;
import com.alla.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

@Bean
CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
return args -> {
   restConfiguration.exposeIdsFor(Customer.class);
    customerRepository.save(new Customer(null,"Hind","alla.hind@gmail.com"));
    customerRepository.save(new Customer(null,"Ibtissam","berrima.ibtissam@gmail.com"));
    customerRepository.save(new Customer(null,"Kenza","addi.kenza@gmail.com"));
    customerRepository.findAll().forEach(
            p-> System.out.println(p.toString())
    );
};

    }
}
