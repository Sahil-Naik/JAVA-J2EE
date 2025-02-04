package wipro.day11;

public class Employee {
	
	private int employeeID;
	private String employeeName;
	private String employeeDepartment;
	private int employeeSalary;
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
	
	public Employee(int employeeID, String employeeName, String employeeDepartment, int employeeSalary) {
		super();
		System.out.println("The Constructor is Storing");
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
	}
	
	public Employee()
	{
		
	}
	
	@Override
	public String toString() {
		System.out.println("But Setters value is Displayed");
		return employeeID +  " " + employeeName + " " + employeeDepartment + " " + employeeSalary;
	}

}
