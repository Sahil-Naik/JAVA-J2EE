package com.wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wipro")
public class BankxCustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankxCustomerManagementApplication.class, args);
	}

}

/* 1. Paginate
 * localhost:9090/api/bank/paginate?page=1&size=3&sortBy=holderName
 * 
 * OR
 * 
 * localhost:9090/api/bank/paginate?page=0&size=4&sortBy=balance&direction=desc
 * 
 * 2. Swagger UI
 * http://localhost:9090/swagger-ui/index.html
*/
