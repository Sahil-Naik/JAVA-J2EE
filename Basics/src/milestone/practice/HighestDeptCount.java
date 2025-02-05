package milestone.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EmployeeDetail {
	private String name;
	private double salary;
	private String department;

	public EmployeeDetail(String name, double salary, String department) {
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

	public void setDepartment(String department) {
		this.department = department;
	}
}

public class HighestDeptCount {

	public static void main(String[] args) {
		List<EmployeeDetail> employees = new ArrayList<>();
		employees.add(new EmployeeDetail("Alice", 60000, "IT"));
		employees.add(new EmployeeDetail("Bob", 45000, "IT"));
		employees.add(new EmployeeDetail("Charlie", 70000, "JJT"));
		employees.add(new EmployeeDetail("David", 50000, "TEST"));
		employees.add(new EmployeeDetail("Eve", 55000, "IT"));

		Map<String, Integer> departmentCount = new HashMap<>();

        // Count employees in each department
        for (EmployeeDetail employee : employees) {
            String department = employee.getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }

        // Find the department with the highest number of employees
        String maxDepartment = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }

        // Output the department with the highest number of employees
        if (maxDepartment != null) {
            System.out.println("Department with the highest number of employees: " + maxDepartment + " (" + maxCount + " employees)");
        } else {
            System.out.println("No employees found.");
        }
    }

}
