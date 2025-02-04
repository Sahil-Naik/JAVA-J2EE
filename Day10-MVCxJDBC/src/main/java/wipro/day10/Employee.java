package wipro.day10;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeeName;
	private String employeeShift;
	private int employeeSalary;

	public Employee(int employeeId, String employeeName, String employeeShift, int employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeShift = employeeShift;
		this.employeeSalary = employeeSalary;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
