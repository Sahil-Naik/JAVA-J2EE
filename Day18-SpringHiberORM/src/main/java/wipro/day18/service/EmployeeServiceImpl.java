package wipro.day18.service;

import wipro.day18.dao.EmployeeDAO;
import wipro.day18.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void insertEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }
}

