package wipro.day18;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import wipro.day18.Employee;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        //Employee emp = new Employee("John Doe", "Day", 50000); When used generate.IDENTITY it will use SQL auto-increment
        Employee emp = new Employee("Test", "Day", 25000); // when used generate.AUTO it will start from 1, 2, 3, . . .
        session.persist(emp);

        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
        
        System.out.println("Employee saved successfully!");
    }
}

