package com.wipro.vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "com.wipro.vendor")
@ComponentScan(basePackages = "com.wipro.vendor")
@EnableDiscoveryClient
public class VendorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorApiApplication.class, args);
	}

}
