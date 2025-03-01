package com.wipro.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "com.wipro.bank.repository")
public class BankManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankManagementApplication.class, args);
    }
    
    @Component
    @Order(1) // Ensures this runs early
    public class BeanDebugger implements CommandLineRunner {
        
        @Autowired
        private ApplicationContext applicationContext;

        @Override
        public void run(String... args) throws Exception {
            System.out.println("==== LOADED BEANS ====");
            Arrays.stream(applicationContext.getBeanDefinitionNames())
                    .sorted()
                    .forEach(System.out::println);
            System.out.println("=======================");
        }
    }
    
}

/* 1. Paginate
 * localhost:8080/bank/all
*/
