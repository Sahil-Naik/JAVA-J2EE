package milestone.practice;

import java.util.*;
import java.util.stream.Collectors;

class EmployeeInfo {
    private String name;
    private String department;

    public EmployeeInfo(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class HighestDeptCountv2 {
    public static void main(String[] args) {
        List<EmployeeInfo> employees = Arrays.asList(
            new EmployeeInfo("Alice", "HR"),
            new EmployeeInfo("Bob", "IT"),
            new EmployeeInfo("Charlie", "IT"),
            new EmployeeInfo("David", "HR"),
            new EmployeeInfo("Eve", "Finance"),
            new EmployeeInfo("Frank", "IT"),
            new EmployeeInfo("Grace", "Finance")
        );

        Map<String, Long> departmentCount = employees.stream()
            .collect(Collectors.groupingBy(EmployeeInfo::getDepartment, Collectors.counting()));

        String departmentWithMostEmployees = departmentCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);

        System.out.println("Department with the highest number of employees: " + departmentWithMostEmployees);
    }
}
