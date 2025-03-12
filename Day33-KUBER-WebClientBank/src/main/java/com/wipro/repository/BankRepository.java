package com.wipro.repository;

import com.wipro.model.Bank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BankRepository extends ReactiveMongoRepository<Bank, Integer> {
    Mono<Bank> findByVendor(String vendor);
}
