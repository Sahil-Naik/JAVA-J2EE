package com.wipro.bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="bank")
public class BankUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId", updatable = false, nullable = false)
    private int accountId;
	
	@NotBlank(message = "Holder name cannot be blank")
	@Column(name = "holderName", updatable = false, nullable = false)
    private String holderName;
	
	@NotNull(message = "Phone number cannot be blank")
	@Column(name = "phone", updatable = false, nullable = false)
    private int phone;
	
	@NotNull(message = "Account pin cannot be null.")
    @Min(value = 4, message = "Pin must be 4 digit")
	@Column(name = "accountPin", updatable = false, nullable = false)
    private int accountPin;
	
	@NotBlank(message = "Holder Date of Birth cannot be blank")
	@Column(name = "holderDob", updatable = false, nullable = false)
    private String holderDob;
	
	@NotNull(message = "Balance cannot be null.")
	@Min(value = 0, message = "Balance must be greater than 0.")
	@Column(name = "balance", updatable = false, nullable = false)
    private int balance;

    // Constructor
    public BankUser(int accountId, String holderName, int phone, int accountPin, String holderDob, int balance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.phone = phone;
        this.accountPin = accountPin;
        this.holderDob = holderDob;
        this.balance = balance;
    }

    public BankUser() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", holderName='" + holderName + '\'' +
                ", phone=" + phone +
                ", accountPin=" + accountPin +
                ", holderDob='" + holderDob + '\'' +
                ", balance=" + balance +
                '}';
    }
}
