package wipro.day14.dao;

import wipro.day14.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (employeeName, employeeShift, employeeSalary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getEmployeeName(), employee.getEmployeeShift(), employee.getEmployeeSalary());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
