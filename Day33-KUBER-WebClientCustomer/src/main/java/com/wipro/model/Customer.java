package com.wipro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "customer")
public class Customer {
    @Id
    private Integer id;
    private String name;
    
    @Field("bank_id")
    private Integer bankId;
    private Double bill;
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
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	public Customer(Integer id, String name, Integer bankId, Double bill) {
		super();
		this.id = id;
		this.name = name;
		this.bankId = bankId;
		this.bill = bill;
	}
    
	public Customer() {
		
	}
    
}
