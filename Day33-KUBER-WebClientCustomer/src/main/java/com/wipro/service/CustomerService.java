package com.wipro.service;

import com.wipro.model.Customer;
import com.wipro.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Void> deleteCustomer(Integer id) {
        return customerRepository.deleteById(id);
    }

    public Flux<Customer> getCustomersByBankId(Integer bankId) {
        return customerRepository.findByBankId(bankId);
    }
}
