package com.wipro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "bank")
public class Bank {
    @Id
    private Integer id;
    private String name;
    private String phone;
    private Double balance;
    private String vendor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public Bank(Integer id, String name, String phone, Double balance, String vendor) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.balance = balance;
		this.vendor = vendor;
	}
    
	public Bank() {
		
	}
    
}
