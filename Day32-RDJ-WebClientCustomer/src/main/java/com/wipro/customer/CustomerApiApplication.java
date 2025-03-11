package com.wipro.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableR2dbcRepositories(basePackages = "com.wipro.customer")
@ComponentScan(basePackages = "com.wipro.customer")
@EnableDiscoveryClient
public class CustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

}
