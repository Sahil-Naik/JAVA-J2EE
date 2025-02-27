package com.wipro.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wipro.customers")
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

}

/* 1. Pagination
 * >>> localhost:9090/api/customers/paginate?page=0&size=4&sortBy=customerBill&
 * direction=asc
 * 
 * 2. Custom Search
 * >>> localhost:9090/api/customers/city-bill-greater-than?city=pune&amount=500
 */