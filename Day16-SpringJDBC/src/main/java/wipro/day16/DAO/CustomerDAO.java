package wipro.day16.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import wipro.day16.model.Customer;

@Repository
public interface CustomerDAO {
	
	int saveCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(Customer customer);
	List<Customer> getAllCustomers();
}
