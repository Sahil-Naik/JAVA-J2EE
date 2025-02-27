package com.wipro.customers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wipro.customers.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT c FROM Customer c")
	List<Customer> getAllCustomers();
	
	@Query("SELECT c FROM Customer c WHERE c.customerCity = :city")
    List<Customer> findCustomersByCity(@Param("city") String city);
	
	@Query("SELECT c FROM Customer c WHERE c.customerCity = :city AND c.customerBill > :amount")
	List<Customer> findCustomersByCityAndBillGreaterThan(@Param("city") String city, @Param("amount") double amount);
	
	@Query("SELECT c FROM Customer c WHERE c.customerCity = :city AND c.customerBill < :amount")
	List<Customer> findCustomersByCityAndBillLessThan(@Param("city") String city, @Param("amount") double amount);
}
