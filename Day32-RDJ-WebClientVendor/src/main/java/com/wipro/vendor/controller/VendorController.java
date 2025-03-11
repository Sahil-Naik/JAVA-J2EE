package com.wipro.vendor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.vendor.DTO.VendorDTO;
import com.wipro.vendor.model.Vendor;
import com.wipro.vendor.service.VendorService;

@RestController
@RefreshScope
@RequestMapping("vendor")
@Tag(name = "Vendor Management System", description = "Operations related to Vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    @Operation(summary = "Add a new Vendor", description = "Adds a new vendor record to the database")
    public Mono<ResponseEntity<Vendor>> addVendor(@RequestBody Vendor newVendor) {
        Vendor vendor = new Vendor();
        vendor.setVendorName(newVendor.getVendorName());
        vendor.setVendorAbbri(newVendor.getVendorAbbri());

        return vendorService.addVendor(vendor)
                .map(savedVendor -> new ResponseEntity<>(savedVendor, HttpStatus.CREATED));
    }

    @GetMapping("/all")
    @Operation(summary = "View all Vendors", description = "Displays all Vendor records")
    public Flux<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{vendorAbbri}")
    @Operation(summary = "View Vendor by Abbreviation", description = "Displays Vendor record with the given abbreviation")
    public Mono<ResponseEntity<VendorDTO>> getVendorByAbbri(@PathVariable String vendorAbbri) {
        return vendorService.getVendorByAbbri(vendorAbbri)
                .map(vendorDTO -> ResponseEntity.ok(vendorDTO))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update vendor", description = "Updates a vendor with given ID")
    public Mono<ResponseEntity<Vendor>> updateVendor(@PathVariable int id, @RequestBody Vendor updatedVendor) {
        return vendorService.updateVendor(id, updatedVendor)
                .map(vendor -> ResponseEntity.ok(vendor))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete vendor", description = "Deletes a Vendor with given ID")
    public Mono<ResponseEntity<String>> deleteVendor(@PathVariable int id) {
        return vendorService.deleteVendor(id)
                .then(Mono.just(ResponseEntity.ok("Vendor with ID " + id + " has been deleted.")))
                .onErrorReturn(ResponseEntity.notFound().build());
    }
}
