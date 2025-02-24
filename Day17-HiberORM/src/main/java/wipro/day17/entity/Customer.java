package wipro.day17.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer") // Updated table name
public class Customer {
    @Id
    @Column(name = "customerID")
    private int customerID; // No auto-increment

    @Column(name = "customerCity")
    private String customerCity;

    @Column(name = "customerBill")
    private double customerBill;

    // Getters and Setters
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

    public double getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(double customerBill) {
        this.customerBill = customerBill;
    }
}
