package com.wipro.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wipro.bank")
public class BankManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
	}

}

/* 1. Paginate
 * localhost:9090/bank/paginate?page=1&size=3&sortBy=holderName 
*/
