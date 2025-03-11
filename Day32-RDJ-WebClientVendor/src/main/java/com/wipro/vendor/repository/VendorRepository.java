package com.wipro.vendor.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.vendor.model.Vendor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VendorRepository extends ReactiveCrudRepository<Vendor, Integer> {
    
    // Fetch all vendors
    Flux<Vendor> findAll();

    // Find a vendor by vendor abbreviation
    Mono<Vendor> findByVendorAbbri(String vendorAbbri);

}
