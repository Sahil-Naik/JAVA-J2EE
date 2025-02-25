package com.wipro.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}