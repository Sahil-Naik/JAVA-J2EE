package wipro.day7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro?useSSL=false", "root", "root");
		System.out.println("Connection Successful!");

		// Disable autocommit to allow Rollback action
		conn.setAutoCommit(false);

		// Setting up the Statement module
		Statement cursor = conn.createStatement();
		
		int user1 = cursor.executeUpdate("UPDATE bankuser1 SET Balance=Balance+5000 WHERE AccountID=901");
		int user2 = cursor.executeUpdate("UPDATE bankuser2 SET Balance=Balance-5000 WHERE AccountID=101");
		
		if (user1 > 0 && user2 > 0) {
			conn.commit();
			System.out.println("\nFunds Transferred!");
		} else {
			conn.rollback();
			System.out.println("\nInvalid AccountID!");
		}
		conn.close();
	}

}
