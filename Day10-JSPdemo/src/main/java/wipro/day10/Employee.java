package wipro.day10;

//mode class or pojo class
public class Employee {

	private int epID;
	private String epName;
	public int getEpID() {
		return epID;
	}
	public void setEpID(int epID) {
		this.epID = epID;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public Employee(int epID, String epName) {
		super();
		this.epID = epID;
		this.epName = epName;
	}
	
	public Employee()
	{
		
	}
}
