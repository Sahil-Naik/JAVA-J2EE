package com.wipro.bank.DTO;

public class BankUserDTO {
	private int accountId;
	private String holderName;
	private double balance;

	// Constructor
	public BankUserDTO(int accountId, String holderName, double balance) {
		this.accountId = accountId;
		this.holderName = holderName;
		this.balance = balance;
	}

	// Getters
	public int getaccountId() {
		return accountId;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}
}
