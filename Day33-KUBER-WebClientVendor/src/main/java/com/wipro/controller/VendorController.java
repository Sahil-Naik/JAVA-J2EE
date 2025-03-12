package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.model.Vendor;
import com.wipro.service.VendorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;
    
    @GetMapping
    public Flux<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{abbreviation}")
    public Mono<Vendor> getVendor(@PathVariable String abbreviation) {
        return vendorService.getVendorByAbbrivation(abbreviation);
    }
}

