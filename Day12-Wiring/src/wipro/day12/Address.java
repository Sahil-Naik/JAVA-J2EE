package wipro.day12;

public class Address {
	
	private String cityName;
	private String stateName;
	private String pincode;
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public Address()
	{
		
	}
	public Address(String cityName, String stateName, String pincode) {
		super();
		this.cityName = cityName;
		this.stateName = stateName;
		this.pincode = pincode;
	}
 
	@Override
	public String toString()
	{
		return cityName + " " + stateName + " " + pincode;
	}
}
