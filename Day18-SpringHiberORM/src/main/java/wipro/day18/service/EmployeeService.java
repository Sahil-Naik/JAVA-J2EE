package wipro.day18.service;

import wipro.day18.entity.Employee;
import java.util.List;

public interface EmployeeService {
    void insertEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
