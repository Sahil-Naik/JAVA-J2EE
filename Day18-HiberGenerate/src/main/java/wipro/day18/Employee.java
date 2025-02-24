package wipro.day18;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id // This means that the following variable is Primary key in the SQL (Database)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Can be AUTO, SEQUENCE, TABLE
    private int employeeId;

    private String employeeName;
    private String employeeShift;
    private int employeeSalary;

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

	public Employee() {}

    public Employee(String employeeName,String employeeShift, int employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeShift = employeeShift;
    }
}

