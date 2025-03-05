package com.wipro.customer.controller;

import com.wipro.customer.DTO.CustomerDTO;
import com.wipro.customer.model.Customers;
import com.wipro.customer.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/details")
    @CircuitBreaker(name = "CustomerService", fallbackMethod = "fallbackGetCustomerDetails")
    public String getCustomerDetails() {
        return CustomerService.getCustomerDetails();
    }
	
	@PostMapping("/add")
	public ResponseEntity<Mono<Customers>> addCustomer(@RequestBody Customers newCustomer) {
		Customers customer = new Customers();
		customer.setCustomerCity(newCustomer.getCustomerCity());
		customer.setCustomerBill(newCustomer.getCustomerBill());
	    
		Mono<Customers> savedCustomer = customerService.addCustomer(customer);
	    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Flux<Customers> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<CustomerDTO>> getCustomer(@PathVariable int id){
		Mono<CustomerDTO> custDTO = customerService.getCustomerById(id);
		
		return ResponseEntity.ok(custDTO);
	}
	
	@GetMapping("/city")
	public Flux<Customers> getCustomerByCity(@RequestParam String city) {
		return customerService.getCustomerByCity(city);
	}
	
	@GetMapping("/city-bill-greater-than")
	public Flux<Customers> getCustomersByCityAndBillGreaterThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillGreaterThan(city, amount);
	}
	
	@GetMapping("/city-bill-less-than")
	public Flux<Customers> getCustomersByCityAndBillLessThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillLessThan(city, amount);
	}
	
	@GetMapping("/paginate")
	public Mono<Page<Customers>> getCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "customerCity") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return customerService.getCustomersPaged(page, size, sortBy, direction);
    }
	
	@PutMapping("/update/{id}")
	public Mono<Customers> updateCustomer(@PathVariable int id, @RequestBody Customers updatedCustomer) {
		return customerService.updateCustomer(id, updatedCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<ResponseEntity<String>> deleteCustomer(@PathVariable int id) {
	    return customerService.deleteCustomer(id)
	        .then(Mono.just(ResponseEntity.ok("Customer with ID " + id + " has been deleted.")))
	        .onErrorResume(e -> {
	            // Handle specific exceptions if needed
	            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with ID " + id + " not found."));
	        });
	}
}
