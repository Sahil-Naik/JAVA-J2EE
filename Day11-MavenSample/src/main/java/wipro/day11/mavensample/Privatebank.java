package wipro.day11.mavensample;

public class Privatebank { 
	// Instance variables datatype should 
	// match with "privatebank" table datatype 
	
	private int accountid;
	public int getAccountid() {
		return accountid;
	}
	
	private String holdername;
	private int phone;
	private int accountpin;
	private String holderdob;
	private int balance;
	
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAccountpin() {
		return accountpin;
	}
	public void setAccountpin(int accountpin) {
		this.accountpin = accountpin;
	}
	public String getHolderdob() {
		return holderdob;
	}
	public void setHolderdob(String holderdob) {
		this.holderdob = holderdob;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}

