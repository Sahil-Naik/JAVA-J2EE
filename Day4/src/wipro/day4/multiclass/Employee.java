package wipro.day4.multiclass;

public class Employee implements Comparable<Employee>{
	
	private Integer epid;
	private String epName;
	private Integer eSalary;
	
	public Integer getEpid() {
		return epid;
	}
	public void setEpid(Integer epid) {
		this.epid = epid;
	}
	
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	
	public Integer geteSalary() {
		return eSalary;
	}
	public void seteSalary(Integer eSalary) {
		this.eSalary = eSalary;
	}
	
	public Employee(Integer epid, String epName, Integer eSalary) {
		super();
		this.epid = epid;
		this.epName = epName;
		this.eSalary = eSalary;
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return epid + " " + epName + " " + eSalary;
	}
	
	// Sorting using 'eSalary' in Ascending order
	@Override
	public int compareTo(Employee e) {
		return this.geteSalary().compareTo(e.geteSalary());
	}
}
