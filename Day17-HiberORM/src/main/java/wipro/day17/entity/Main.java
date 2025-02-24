package wipro.day17.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create a new Customer
        Customer newCustomer = new Customer();
        newCustomer.setCustomerID(109); // Manually set customerID
        newCustomer.setCustomerCity("New York");
        newCustomer.setCustomerBill(150.75);
        createCustomer(sessionFactory, newCustomer);

        // Read all customers
        List<Customer> customers = readCustomers(sessionFactory);
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerID() +
                               ", City: " + customer.getCustomerCity() +
                               ", Bill: " + customer.getCustomerBill());
        }

        // Update a customer
        if (!customers.isEmpty()) {
            Customer customerToUpdate = customers.get(0);
            customerToUpdate.setCustomerCity("Los Angeles");
            customerToUpdate.setCustomerBill(200.00);
            updateCustomer(sessionFactory, customerToUpdate);
        }

        // Delete a customer
        if (!customers.isEmpty()) {
            Customer customerToDelete = customers.get(0);
            deleteCustomer(sessionFactory, customerToDelete.getCustomerID());
        }

        // Close the SessionFactory
        sessionFactory.close();
    }

    // Method to create a customer
    public static void createCustomer(SessionFactory sessionFactory, Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("Customer created with ID: " + customer.getCustomerID());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to read all customers
    public static List<Customer> readCustomers(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }

    // Method to update a customer
    public static void updateCustomer(SessionFactory sessionFactory, Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
            System.out.println("Customer updated with ID: " + customer.getCustomerID());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to delete a customer
    public static void deleteCustomer(SessionFactory sessionFactory, int customerId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
                System.out.println("Customer deleted with ID: " + customerId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}