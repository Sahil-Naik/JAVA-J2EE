package com.wipro.customer.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.wipro.customer.model.Customers;

import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends R2dbcRepository<Customers, Integer> {

    // Fetch all customers
    Flux<Customers> findAll();  

    // Fetch customers by city
    Flux<Customers> findByCustomerCity(String city);

    // Fetch customers by city and bill greater than amount
    Flux<Customers> findByCustomerCityAndCustomerBillGreaterThan(String city, double amount);

    // Fetch customers by city and bill less than amount
    Flux<Customers> findByCustomerCityAndCustomerBillLessThan(String city, double amount);
}

