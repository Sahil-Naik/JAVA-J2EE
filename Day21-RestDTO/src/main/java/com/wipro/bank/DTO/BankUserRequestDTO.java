package com.wipro.bank.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BankUserRequestDTO {
	@NotBlank(message = "Holder name cannot be empty")
	private String holderName;

	@NotNull(message = "Phone number cannot be blank")
	private int phone;

	@NotNull(message = "Account pin cannot be null.")
	@Min(value = 1000, message = "Pin must be 4 digit")
	private int accountPin;

	@NotBlank(message = "Holder Date of Birth cannot be blank")
	private String holderDob;

	@NotNull(message = "Balance cannot be null")
	@Min(value = 0, message = "Balance cannot be negative")
	private int balance;

	// Getters and Setters
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAccountPin() {
		return accountPin;
	}

	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}

	public String getHolderDob() {
		return holderDob;
	}

	public void setHolderDob(String holderDob) {
		this.holderDob = holderDob;
	}
	
	
}
