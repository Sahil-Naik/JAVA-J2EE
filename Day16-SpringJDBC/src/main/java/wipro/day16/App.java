package wipro.day16;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import wipro.day16.config.MyConfiguration;
import wipro.day16.DAO.CustomerDAO;
import wipro.day16.model.Customer;

public class App {
	
	public static void displayCustomers(List<Customer> customer) {
		System.out.println("ID\tCity\tBill");
		for (int i = 0; i < customer.size(); i++) {
			System.out.println(customer.get(i).getCustomerID()
					+"\t"+customer.get(i).getCustomerCity()
					+"\t"+customer.get(i).getCustomerBill());
		}
	}
	
	public static void insertCustomers(CustomerDAO customerDAO, Scanner sc) {
	    int customerID;
	    String customerCity;
	    int customerBill;

	    try {
	        System.out.printf("\nEnter ID: ");
	        customerID = sc.nextInt();

	        // Clear the newline character left by nextInt()
	        sc.nextLine(); 

	        System.out.printf("Enter City: ");
	        customerCity = sc.nextLine(); // Use nextLine() to capture the full city name

	        System.out.printf("Enter Bill: ");
	        customerBill = sc.nextInt();

	        // Call the DAO method to save the customer
	        int x = customerDAO.saveCustomer(new Customer(customerID, customerCity, customerBill));
	        
	        if (x > 0) {
	            System.out.println("\n" + x + " row(s) inserted\n");
	        } else {
	            System.out.println("\nFailed to insert customer with ID: " + customerID + "\n");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input. Please enter valid data.");
	        sc.nextLine(); // Clear the invalid input
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
	}

	public static void updateCustomer(CustomerDAO customerDAO, Scanner sc) {
	    int customerID;
	    String customerCity;
	    int customerBill;

	    try {
	        System.out.printf("\nEnter ID: ");
	        customerID = sc.nextInt();

	        // Clear the newline character left by nextInt()
	        sc.nextLine(); 

	        System.out.printf("Enter City: ");
	        customerCity = sc.nextLine(); // Use nextLine() to capture the full city name

	        System.out.printf("Enter Bill: ");
	        customerBill = sc.nextInt();

	        // Call the DAO method to update the customer
	        int x = customerDAO.updateCustomer(new Customer(customerID, customerCity, customerBill));
	        
	        if (x > 0) {
	            System.out.println("\n" + x + " row(s) updated\n");
	        } else {
	            System.out.println("\nNo customer found with ID: " + customerID + "\n");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input. Please enter valid data.");
	        sc.nextLine(); // Clear the invalid input
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
	}

	public static void deleteCustomer(CustomerDAO customerDAO, Scanner sc) {
	    int customerID;
	    
	    try {
	        System.out.printf("\nEnter ID: ");
	        customerID = sc.nextInt();
	        
	        int x = customerDAO.deleteCustomer(new Customer(customerID));
	        
	        if (x > 0) {
	            System.out.println("\n" + x + " row(s) deleted\n");
	        } else {
	            System.out.println("\nNo customer found with ID: " + customerID + "\n");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input. Please enter a valid integer ID.");
	        sc.nextLine(); // Clear the invalid input
	    }
	}

	public static void main(String[] args) {
	    @SuppressWarnings("resource")
	    ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
	    CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
	    
	    Scanner sc = new Scanner(System.in); // Create a single Scanner instance

	    System.out.println("Before Inserting...");
	    List<Customer> customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);
	    
	    insertCustomers(customerDAO, sc);
	    
	    System.out.println("After Inserting...");
	    customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);
	    
	    System.out.println("\nBefore Updating...");
	    customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);
	    
	    updateCustomer(customerDAO, sc);
	    
	    System.out.println("\nAfter Updating...");
	    customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);
	    
	    System.out.println("\nBefore Deletion...");
	    customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);
	    
	    deleteCustomer(customerDAO, sc);
	    
	    System.out.println("\nAfter Deletion...");
	    customer = customerDAO.getAllCustomers();
	    displayCustomers(customer);

	    sc.close(); // Close the scanner at the end
	}
}
