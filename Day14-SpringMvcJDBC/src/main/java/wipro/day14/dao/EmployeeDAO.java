package wipro.day14.dao;

import wipro.day14.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
}