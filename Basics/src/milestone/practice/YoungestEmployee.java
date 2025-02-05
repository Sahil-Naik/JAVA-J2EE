package milestone.practice;

import java.util.ArrayList;
import java.util.List;

class EmployeeAge {
    private String name;
    private int age; // Assuming age is an integer
    private String department;

    public EmployeeAge(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}

public class YoungestEmployee {
    public static void main(String[] args) {
        // Sample list of Employee objects
        List<EmployeeAge> employees = new ArrayList<>();
        employees.add(new EmployeeAge("Alice", 30, "HR"));
        employees.add(new EmployeeAge("Bob", 25, "IT"));
        employees.add(new EmployeeAge("Charlie", 28, "IT"));
        employees.add(new EmployeeAge("David", 35, "HR"));
        employees.add(new EmployeeAge("Eve", 22, "Finance"));
        employees.add(new EmployeeAge("Frank", 29, "IT"));
        employees.add(new EmployeeAge("Grace", 27, "Finance"));

        String targetDepartment = "IT";

        EmployeeAge youngestEmployee = null;

        for (EmployeeAge employee : employees) {
            if (employee.getDepartment().equals(targetDepartment)) {
                if (youngestEmployee == null || employee.getAge() < youngestEmployee.getAge()) {
                    youngestEmployee = employee;
                }
            }
        }
        if (youngestEmployee != null) {
            System.out.println("The youngest employee in the " + targetDepartment + " department is: " +
                    youngestEmployee.getName() + " (Age: " + youngestEmployee.getAge() + ")");
        } else {
            System.out.println("No employees found in the " + targetDepartment + " department.");
        }
    }
}
