package com.wipro.controller;

import com.wipro.DTO.CustomerDTO;
import com.wipro.model.Customer;
import com.wipro.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@Tag(name = "Customer-Bill Management System", description = "Operations related to handling Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	@Operation(summary = "Add a new Customer", description = "Adds a new Customer record to the database")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer) {
		Customer customer = new Customer();
		customer.setCustomerCity(newCustomer.getCustomerCity());
		customer.setCustomerBill(newCustomer.getCustomerBill());
	    
		Customer savedCustomer = customerService.addCustomer(customer);
	    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	@Operation(summary = "View all Customers", description = "Displays all Customer records")
	public List<Customer> getAllCustomer(){
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
			    content = @Content) })
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id){
		CustomerDTO custDTO = customerService.getCustomerById(id);
		
		return ResponseEntity.ok(custDTO);
	}
	
	@GetMapping("/city")
	@Operation(summary = "View Customer with City", description = "Displays Customer record with City x")
	public List<Customer> getCustomerByCity(@RequestParam String city) {
		return customerService.getCustomerByCity(city);
	}
	
	@GetMapping("/city-bill-greater-than")
	@Operation(summary = "Customer from city with bill greater than", description = "Displays Customer record having Bill greater than x and in City y")
	public List<Customer> getCustomersByCityAndBillGreaterThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillGreaterThan(city, amount);
	}
	
	@GetMapping("/city-bill-less-than")
	@Operation(summary = "Customer from city with bill less than", description = "Displays Customer record having Bill less than x and in City y")
	public List<Customer> getCustomersByCityAndBillLessThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillLessThan(city, amount);
	}
	
	@GetMapping("/paginate")
	@Operation(summary = "Paged results", description = "Returns all customers in paged manner")
    public Page<Customer> getCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "customerCity") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return customerService.getCustomersPaged(page, size, sortBy, direction);
    }
	
	@PutMapping("/update/{id}")
	@Operation(summary = "Update Customer", description = "Updates a Customer with given ID")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(id, updatedCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete Customer", description = "Deletes a Customer with given ID")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "Customer with ID " + id + " has been deleted.";
	}
}
