package com.wipro.employees.service;

import com.wipro.employees.model.Employee;
import com.wipro.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            emp.setEmployeeName(updatedEmployee.getEmployeeName());
            emp.setEmployeeShift(updatedEmployee.getEmployeeShift());
            emp.setEmployeeSalary(updatedEmployee.getEmployeeSalary());
            return employeeRepository.save(emp);
        }
        return null;
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
