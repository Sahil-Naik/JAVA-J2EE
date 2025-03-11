package com.wipro.vendor.service;

import com.wipro.vendor.exception.ResourceNotFoundException;
import com.wipro.vendor.DTO.VendorDTO;
import com.wipro.vendor.model.Vendor;
import com.wipro.vendor.repository.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Service
@RefreshScope
public class VendorService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VendorRepository vendorRepository;

    public Mono<Vendor> addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Flux<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Mono<VendorDTO> getVendorById(int id) {
        return vendorRepository.findById(id)
                .map(vendor -> new VendorDTO(vendor.getVendor_id(),
                        vendor.getVendorName(),
                        vendor.getVendorAbbri()))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Vendor with ID " + id + " not found.")));
    }

    public Mono<VendorDTO> getVendorByAbbri(String vendorAbbri) {
        return vendorRepository.findByVendorAbbri(vendorAbbri)
                .map(vendor -> new VendorDTO(vendor.getVendor_id(),
                        vendor.getVendorName(),
                        vendor.getVendorAbbri()))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Vendor with abbreviation " + vendorAbbri + " not found.")));
    }

    public Mono<Vendor> updateVendor(int id, Vendor updatedVendor) {
        return vendorRepository.findById(id)
                .flatMap(existingVendor -> {
                    existingVendor.setVendorName(updatedVendor.getVendorName());
                    existingVendor.setVendorAbbri(updatedVendor.getVendorAbbri());
                    return vendorRepository.save(existingVendor);
                })
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Vendor with ID " + id + " not found.")));
    }

    public Mono<Void> deleteVendor(int id) {
        return vendorRepository.existsById(id)
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new ResourceNotFoundException("Vendor with ID " + id + " not found."));
                    }
                    return vendorRepository.deleteById(id);
                });
    }
}