package wipro.day2.TASK;

// Base class
abstract class Customer {
    public abstract double calculateDiscount(double amount);
}

// Subclass for Regular Customers + 10% discount
class RegularCustomer extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        double discount = 0.10;
        return amount * discount;
    }
}

// Subclass for Premium Customers + 20% discount
class PremiumCustomer extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        double discount = 0.20;
        return amount * discount;
    }
}

// Subclass for Employees + 30% discount
class Employee extends Customer {
    @Override
    public double calculateDiscount(double amount) {
        double discount = 0.30;
        return amount * discount;
    }
}

public class DiscountCalculator {
    public static double applyDiscount(Customer customer, double amount) {
        double discount = customer.calculateDiscount(amount);
        return amount - discount;
    }

    public static void main(String[] args) {
        Customer regularCustomer = new RegularCustomer();
        Customer premiumCustomer = new PremiumCustomer();
        Customer employee = new Employee();

        // Take base amount
        double amount = 100.0;

        // Calculating discounts
        System.out.printf("Regular Customer Discounted Price: %.2f%n", applyDiscount(regularCustomer, amount));
        System.out.printf("Premium Customer Discounted Price: %.2f%n", applyDiscount(premiumCustomer, amount));
        System.out.printf("Employee Discounted Price: %.2f%n", applyDiscount(employee, amount));
    }
}