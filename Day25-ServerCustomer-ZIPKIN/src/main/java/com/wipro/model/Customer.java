package com.wipro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", updatable = false, nullable = false)
	private int customerID;
	
	@NotBlank(message = "Customer city cannot be blank")
	@Column(name = "customer_city", updatable = false, nullable = false)
	private String customerCity;
	
	@NotNull(message = "Customer bill cannot be null")
	@Min(value = 0, message = "Bill must be at least Rs. 0")
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
