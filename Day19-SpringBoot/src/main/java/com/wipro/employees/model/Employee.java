package com.wipro.employees.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", updatable = false, nullable = false)
    private int employeeId;
    
    @Column(name = "employeeName", nullable = false)
    private String employeeName;
    
    @Column(name = "employeeShift", nullable = false)
    private String employeeShift;
    
    @Column(name = "employeeSalary", nullable = false)
    private int employeeSalary;

    // Constructors
    public Employee() {}

    public Employee(String employeeName, String employeeShift, int employeeSalary) {
        this.employeeName = employeeName;
        this.employeeShift = employeeShift;
        this.employeeSalary = employeeSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeShift() {
        return employeeShift;
    }

    public void setEmployeeShift(String employeeShift) {
        this.employeeShift = employeeShift;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
