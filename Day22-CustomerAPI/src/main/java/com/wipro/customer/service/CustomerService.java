package com.wipro.customer.service;

import com.wipro.customer.exception.ResourceNotFoundException;
import com.wipro.customer.DTO.CustomerDTO;
import com.wipro.customer.model.Customer;
import com.wipro.customer.repository.CustomerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public CustomerDTO getCustomerById(int id) {
        Customer cust = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " not found."));
        
        // Convert to DTO before returning
        return new CustomerDTO(cust.getCustomerId(), cust.getCustomerPhone(), cust.getCustomerBill(), cust.getCustomerBankId(), cust.getCustomerStore());
    }
    
    public List<Customer> getCustomersByBillGreaterThan(double amount) {
        return customerRepository.findCustomersByBillGreaterThan(amount);
    }
    
    public List<Customer> getCustomersByBillLessThan(double amount) {
        return customerRepository.findCustomersByBillLessThan(amount);
    }
    
    public Page<Customer> getCustomersPaged(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return customerRepository.findAll(pageable);
    }
    
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer cust = existingCustomer.get();
            cust.setCustomerPhone(updatedCustomer.getCustomerPhone());
            cust.setCustomerBill(updatedCustomer.getCustomerBill());
            cust.setCustomerBankId(updatedCustomer.getCustomerBankId());
            cust.setCustomerStore(updatedCustomer.getCustomerStore());
            return customerRepository.save(cust);
        }
        throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
    }
    
    public void deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
        customerRepository.deleteById(id);
    }
}
