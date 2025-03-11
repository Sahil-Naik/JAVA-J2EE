package com.wipro.customer.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customer.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends R2dbcRepository<Customer, Integer> {
    
    // Fetch all customers
    Flux<Customer> findAll();

    // Find a customer by bank ID
    Mono<Customer> findByCustomerBankId(String bankId);

    // Find customers with a bill greater than a specified amount
    Flux<Customer> findByCustomerBillGreaterThan(double amount);

    // Find customers with a bill less than a specified amount
    Flux<Customer> findByCustomerBillLessThan(double amount);
}
