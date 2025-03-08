package com.wipro.DTO;

public class CustomerDTO {
	private int customerID;
	private String customerCity;
	private int customerBill;
	
	// Getters
	public int getCustomerID() {
		return customerID;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public int getCustomerBill() {
		return customerBill;
	}
	
	// Constructor
	public CustomerDTO(int customerID, String customerCity, int customerBill) {
		super();
		this.customerID = customerID;
		this.customerCity = customerCity;
		this.customerBill = customerBill;
	}	
	
}
