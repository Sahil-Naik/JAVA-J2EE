package com.wipro.customers.service;

import com.wipro.customers.model.Customer;
import com.wipro.customers.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	public List<Customer> getCustomerByCity(String city) {
		return customerRepository.findCustomersByCity(city);
	}
	
	public List<Customer> getCustomersByCityAndBillGreaterThan(String city, double amount) {
	    return customerRepository.findCustomersByCityAndBillGreaterThan(city, amount);
	}
	
	public List<Customer> getCustomersByCityAndBillLessThan(String city, double amount) {
	    return customerRepository.findCustomersByCityAndBillLessThan(city, amount);
	}
	
	public Customer updateCustomer(int id, Customer updatedCustomer) {
		Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
        	Customer cust = existingCustomer.get();
        	cust.setCustomerCity(updatedCustomer.getCustomerCity());
        	cust.setCustomerBill(updatedCustomer.getCustomerBill());
            return customerRepository.save(cust);
        }
        return null;
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
}
