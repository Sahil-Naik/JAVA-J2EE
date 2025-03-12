package com.wipro.repository;

import com.wipro.model.Customer;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, Integer> {
	@Query("{ 'bank_id': ?0 }")
    Flux<Customer> findByBankId(Integer bankId);
}
