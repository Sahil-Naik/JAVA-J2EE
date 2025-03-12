package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.Vendor;
import com.wipro.repository.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	public Flux<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}

	public Mono<Vendor> getVendorByAbbrivation(String id) {
		return vendorRepository.findByAbbreviation(id);
	}

	public Mono<Vendor> getVendorByAbbreviation(String abbreviation) {
		return vendorRepository.findByAbbreviation(abbreviation);
	}
}
