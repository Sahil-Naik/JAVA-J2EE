package com.wipro.bank.model;

public class BankUser {
    private int accountId;
    private String holderName;
    private int phone;
    private int accountPin;
    private String holderDob;
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
