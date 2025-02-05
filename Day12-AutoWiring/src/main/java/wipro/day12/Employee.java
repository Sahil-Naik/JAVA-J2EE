package wipro.day12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("1001")
	private int employeeID;
	
	@Value("Sahil")
	private String employeeName;
	
	@Value("IT")
	private String employeeDepartment;
	
	@Value("12500")
	private int employeeSalary;
	
	@Autowired
	private Address address;
	
	@Value("Python, C++")
	private List<String> skills;
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}	
	
	public Employee(int employeeID, String employeeName, String employeeDepartment, int employeeSalary, Address address, List<String> skills) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
		this.address = address;
		this.skills = skills;
	}
	
	public Employee()
	{
		
	}
	
	@Override
	public String toString() {
		return "Employee ID: " + employeeID +
				"\nEmployee Name: " + employeeName +
				"\nEmployee Department: " + employeeDepartment +
				"\nEmployee Salary: " + employeeSalary +
				"\nAddress: " + address +
				"\nSkills: " + skills;
	}
}