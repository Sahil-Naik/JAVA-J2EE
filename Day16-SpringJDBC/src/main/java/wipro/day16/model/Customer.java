package wipro.day16.model;

public class Customer {
	
	private Integer customerID;
	private String customerCity;
	private Integer customerBill;
	
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public Integer getCustomerBill() {
		return customerBill;
	}
	public void setCustomerBill(Integer customerBill) {
		this.customerBill = customerBill;
	}	
	
	public Customer(Integer customerID, String customerCity, Integer customerBill) {
		super();
		this.customerID = customerID;
		this.customerCity = customerCity;
		this.customerBill = customerBill;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerCity=" + customerCity + ", customerBill="
				+ customerBill + "]";
	}
	
	public Customer()
	{
		
	}
	
	public Customer(int customerID) {
        this.customerID = customerID;
    }

}
