package com.wipro.vendor.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.wipro.vendor.model.Vendor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VendorRepository extends R2dbcRepository<Vendor, Integer> {
    
    // Fetch all vendors
    Flux<Vendor> findAll();

    // Find a vendor by vendor abbreviation
    Mono<Vendor> findByVendorAbbri(String vendorAbbri);
}
