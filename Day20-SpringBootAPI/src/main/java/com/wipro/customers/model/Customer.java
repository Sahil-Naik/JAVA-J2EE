package com.wipro.customers.model;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", updatable = false, nullable = false)
	private int customerID;
	
	@Column(name = "customer_city", updatable = false, nullable = false)
	private String customerCity;
	
	@Column(name = "customer_bill", updatable = false, nullable = false)
	private int customerBill;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public int getCustomerBill() {
		return customerBill;
	}

	public void setCustomerBill(int customerBill) {
		this.customerBill = customerBill;
	}
	
	// Constructors
    public Customer() {}

	public Customer(int customerID, String customerCity, int customerBill) {
		super();
		this.customerID = customerID;
		this.customerCity = customerCity;
		this.customerBill = customerBill;
	}
}
