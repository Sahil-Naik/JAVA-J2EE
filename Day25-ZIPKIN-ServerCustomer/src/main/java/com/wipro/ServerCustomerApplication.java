package com.wipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wipro")
@EnableDiscoveryClient
public class ServerCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerCustomerApplication.class, args);
	}

}
