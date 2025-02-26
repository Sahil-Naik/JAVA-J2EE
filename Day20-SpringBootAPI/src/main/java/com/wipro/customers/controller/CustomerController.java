package com.wipro.customers.controller;

import com.wipro.customers.model.Customer;
import com.wipro.customers.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer) {
		Customer customer = new Customer();
		customer.setCustomerCity(newCustomer.getCustomerCity());
		customer.setCustomerBill(newCustomer.getCustomerBill());
	    
		Customer savedCustomer = customerService.addCustomer(customer);
	    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/city")
	public List<Customer> getCustomerByCity(@RequestParam String city) {
		return customerService.getCustomerByCity(city);
	}
	
	@GetMapping("/city-bill-greater-than")
	public List<Customer> getCustomersByCityAndBillGreaterThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillGreaterThan(city, amount);
	}
	
	@GetMapping("/city-bill-less-than")
	public List<Customer> getCustomersByCityAndBillLessThan(
	        @RequestParam String city, 
	        @RequestParam double amount) {
	    return customerService.getCustomersByCityAndBillLessThan(city, amount);
	}
	
	@PutMapping("/update/{id}")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(id, updatedCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "Customer with ID " + id + " has been deleted.";
	}
}
