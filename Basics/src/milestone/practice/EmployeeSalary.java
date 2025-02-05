package milestone.practice;

import java.util.ArrayList;
import java.util.List;

class Employee {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalary {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Alice", 60000));
		employees.add(new Employee("Bob", 45000));
		employees.add(new Employee("Charlie", 70000));
		employees.add(new Employee("David", 50000));
		employees.add(new Employee("Eve", 55000));

		List<Employee> highSalaryEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getSalary() > 50000) {
				highSalaryEmployees.add(employee);
			}
		}

		for (Employee emp : highSalaryEmployees) {
			System.out.println(emp.getName());
		}
	}

}
