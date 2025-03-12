package com.wipro.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Vendor;

import reactor.core.publisher.Mono;

@Repository
public interface VendorRepository extends ReactiveMongoRepository<Vendor, Integer> {
    Mono<Vendor> findByAbbreviation(String abbreviation);
}
