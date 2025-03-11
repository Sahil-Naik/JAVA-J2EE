package com.wipro.customer.controller;

import com.wipro.customer.DTO.APIResponseDTO;
import com.wipro.customer.DTO.CustomerDTO;
import com.wipro.customer.model.Customer;
import com.wipro.customer.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("customer")
@Tag(name = "Customer-Bill Management System", description = "Operations related to handling Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    @Operation(summary = "Add a new Customer", description = "Adds a new Customer record to the database")
    public Mono<ResponseEntity<Customer>> addCustomer(@RequestBody Customer newCustomer) {
        Customer customer = new Customer();
        customer.setCustomerPhone(newCustomer.getCustomerPhone());
        customer.setCustomerBill(newCustomer.getCustomerBill());
        customer.setCustomerBankId(newCustomer.getCustomerBankId());
        customer.setCustomerStore(newCustomer.getCustomerStore());

        return customerService.addCustomer(customer)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer, HttpStatus.CREATED));
    }

    @GetMapping("/all")
    @Operation(summary = "View all Customers", description = "Displays all Customer records")
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "View Customer with ID", description = "Displays Customer records with ID x")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the Customer",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Customer.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Customer not found",
            content = @Content)
    })
    public Mono<ResponseEntity<CustomerDTO>> getCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id)
                .map(custDTO -> ResponseEntity.ok(custDTO))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/bankid-{bankId}")
    @Operation(summary = "View Customer with BankID", description = "Displays Customer records with Bank-ID x")
    public Mono<ResponseEntity<APIResponseDTO>> getCustomerByBankId(@PathVariable String bankId) {
        return customerService.getCustomerByBankId(bankId)
                .map(custDTO -> ResponseEntity.ok(custDTO))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/bill-greater-than")
    @Operation(summary = "Customer with bill greater than", description = "Displays Customer record having Bill greater than x")
    public Flux<Customer> getCustomersByBillGreaterThan(@RequestParam double amount) {
        return customerService.getCustomersByBillGreaterThan(amount);
    }

    @GetMapping("/bill-less-than")
    @Operation(summary = "Customer with bill less than", description = "Displays Customer record having Bill less than x")
    public Flux<Customer> getCustomersByBillLessThan(@RequestParam double amount) {
        return customerService.getCustomersByBillLessThan(amount);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Customer", description = "Updates a Customer with given ID")
    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer)
                .map(customer -> ResponseEntity.ok(customer))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Customer", description = "Deletes a Customer with given ID")
    public Mono<ResponseEntity<String>> deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id)
                .then(Mono.just(ResponseEntity.ok("Customer with ID " + id + " has been deleted.")))
                .onErrorReturn(ResponseEntity.notFound().build());
    }
}
