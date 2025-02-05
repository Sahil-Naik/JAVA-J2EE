package milestone.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeSal {
    private String name;
    private double salary;
    private String department;

    public EmployeeSal(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

public class AverageDeptSalary {
	
	public static void main(String[] args) {
		List<EmployeeSal> employees = new ArrayList<>();
        employees.add(new EmployeeSal("Alice", 60000, "HR"));
        employees.add(new EmployeeSal("Bob", 45000, "IT"));
        employees.add(new EmployeeSal("Charlie", 70000, "IT"));
        employees.add(new EmployeeSal("David", 50000, "HR"));
        employees.add(new EmployeeSal("Eve", 55000, "Finance"));
        employees.add(new EmployeeSal("Frank", 48000, "IT"));
        employees.add(new EmployeeSal("Grace", 52000, "Finance"));
        
        Map<String, Double> totalSalary = new HashMap<>();
        Map<String, Integer> employeeCount = new HashMap<>();
        
        for (EmployeeSal employee : employees) {
            String department = employee.getDepartment();
            double salary = employee.getSalary();

            totalSalary.put(department, totalSalary.getOrDefault(department, 0.0) + salary);
            employeeCount.put(department, employeeCount.getOrDefault(department, 0) + 1);
        }
        
        System.out.println("Average Salary Per Department:\n");
        for (String department : totalSalary.keySet()) {
            double averageSalary = totalSalary.get(department) / employeeCount.get(department);
            System.out.printf("%s: %.2f%n", department, averageSalary);
        }
	}

}
