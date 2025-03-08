package com.wipro.customer.service;

import com.wipro.customer.DTO.CustomerDTO;
import com.wipro.customer.exceptions.*;
import com.wipro.customer.model.Customers;
import com.wipro.customer.repository.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SuppressWarnings("unused")
@RefreshScope
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Mono<Customers> addCustomer(Customers customer) {
		return customerRepository.save(customer);
	}
	
	public Flux<Customers> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Mono<CustomerDTO> getCustomerById(int id) {
	    return customerRepository.findById(id)
	        .switchIfEmpty(Mono.error(new ResourceNotFoundException("User  with ID " + id + " not found.")))
	        .map(customer -> new CustomerDTO(customer.getCustomerID(), customer.getCustomerCity(), customer.getCustomerBill()));
	}
	
	public Flux<Customers> getCustomerByCity(String city) {
		return customerRepository.findByCustomerCity(city);
	}
	
	public Flux<Customers> getCustomersByCityAndBillGreaterThan(String city, double amount) {
	    return customerRepository.findByCustomerCityAndCustomerBillGreaterThan(city, amount);
	}
	
	public Flux<Customers> getCustomersByCityAndBillLessThan(String city, double amount) {
	    return customerRepository.findByCustomerCityAndCustomerBillLessThan(city, amount);
	}
	
	public Mono<Page<Customers>> getCustomersPaged(int page, int size, String sortBy, String direction) {
	    Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
	    Pageable pageable = PageRequest.of(page, size, sort);

	    return customerRepository.findAll((Sort) pageable)
	        .collectList() // Collect all customers into a list
	        .zipWith(customerRepository.count()) // Get the total count of customers
	        .map(tuple -> new PageImpl<>(tuple.getT1(), pageable, tuple.getT2())); // Create a PageImpl object
	}
	
	public Mono<Customers> updateCustomer(int id, Customers updatedCustomer) {
	    return customerRepository.findById(id)
	        .flatMap(existingCustomer -> {
	            existingCustomer.setCustomerCity(updatedCustomer.getCustomerCity());
	            existingCustomer.setCustomerBill(updatedCustomer.getCustomerBill());
	            return customerRepository.save(existingCustomer);
	        })
	        .switchIfEmpty(Mono.error(new ResourceNotFoundException("Customer with ID " + id + " not found.")));
	}
	
	public Mono<Void> deleteCustomer(int id) {
	    return customerRepository.deleteById(id);
	}
	
    public static String getCustomerDetails() {
        // Simulating a failure or delay
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Customer service is down");
        }
        return "Customer details fetched successfully!";
    }
	
	
}
