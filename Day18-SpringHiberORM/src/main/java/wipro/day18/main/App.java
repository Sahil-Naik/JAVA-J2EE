package wipro.day18.main;

import wipro.day18.config.HibernateConfig;
import wipro.day18.entity.Employee;
import wipro.day18.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    private static EmployeeService employeeService;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize Spring Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        employeeService = context.getBean(EmployeeService.class);

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Display all employees");
            System.out.println("2. Insert a new employee");
            System.out.println("3. Find an employee by ID");
            System.out.println("4. Update an employee");
            System.out.println("5. Delete an employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> displayEmployees();
                case 2 -> insertEmployee();
                case 3 -> findEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("\nExiting application...");
                    context.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " \t " + emp.getEmployeeName() +
                    " (" + emp.getEmployeeShift() + ") \t\t Salary: " + emp.getEmployeeSalary()));
        }
    }

    private static void insertEmployee() {
        System.out.print("\nEnter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee shift: ");
        String shift = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employee = new Employee();
        employee.setEmployeeName(name);
        employee.setEmployeeShift(shift);
        employee.setEmployeeSalary(salary);

        employeeService.insertEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private static void findEmployee() {
        System.out.print("\nEnter employee ID to find: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println("\nEmployee Found:");
            System.out.println(employee.getEmployeeId() + " - " + employee.getEmployeeName() +
                    " (" + employee.getEmployeeShift() + ") - Salary: " + employee.getEmployeeSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee() {
        System.out.print("\nEnter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new employee shift: ");
        String shift = scanner.nextLine();
        System.out.print("Enter new employee salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        existingEmployee.setEmployeeName(name);
        existingEmployee.setEmployeeShift(shift);
        existingEmployee.setEmployeeSalary(salary);

        employeeService.updateEmployee(existingEmployee);
        System.out.println("Employee updated successfully!");
    }

    private static void deleteEmployee() {
        System.out.print("\nEnter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }
}

