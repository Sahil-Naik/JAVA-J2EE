package com.wipro.employees.controller;

import com.wipro.employees.model.Employee;
import com.wipro.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add a new Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestParam String employeeName,
            @RequestParam String employeeShift,
            @RequestParam int employeeSalary) {
        
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employee.setEmployeeShift(employeeShift);
        employee.setEmployeeSalary(employeeSalary);
        
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get all Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Update Employee by ID
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";
    }
}
