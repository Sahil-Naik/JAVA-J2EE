package com.wipro.customer.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
	
	private CustomerDTO customerDTO;
    private BankDTO bankDTO;
    
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public BankDTO getBankDTO() {
		return bankDTO;
	}
	public void setBankDTO(BankDTO bankDTO) {
		this.bankDTO = bankDTO;
	}
	
	public APIResponseDTO(CustomerDTO customerDTO, BankDTO bankDTO) {
		super();
		this.customerDTO = customerDTO;
		this.bankDTO = bankDTO;
	}
	
	public APIResponseDTO() {
		
	}	

}
