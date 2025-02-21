package wipro.day16.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import wipro.day16.DAO.CustomerDAO;
import wipro.day16.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public int saveCustomer(Customer customer) {
		String sql = "INSERT INTO customer (customerID, customerCity, customerBill) VALUES (?, ?, ?)";
		return template.update(sql, customer.getCustomerID(), customer.getCustomerCity(), customer.getCustomerBill());
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET customerCity = ?, customerBill = ? WHERE customerID = ?";
		return template.update(sql, customer.getCustomerCity(), customer.getCustomerBill(), customer.getCustomerID());
	}

	@Override
	public int deleteCustomer(Customer customer) {
		String sql = "DELETE FROM customer WHERE customerID = ?";
		return template.update(sql, customer.getCustomerID());
	}
	
	public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        return template.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }
}