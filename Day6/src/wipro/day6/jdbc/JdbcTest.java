package wipro.day6.jdbc;

import java.sql.*;

public class JdbcTest {
	
	public static void main(String[] args) throws Exception{
		// Loading the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro?useSSL=false", "root", "root");
		System.out.println("Connection Successful!");
		
		Statement cursor = conn.createStatement();
		
		String myQuery = "SELECT * FROM employee";
		
		ResultSet result = cursor.executeQuery(myQuery);
		
		while (result.next()) {
			int employeeId = result.getInt("employeeId");
			String employeeName = result.getString("employeeName");
			String employeeShift = result.getString("employeeShift");
			int employeeSalary = result.getInt("employeeSalary");
			
			System.out.println("ID: " + employeeId
					+ "\t Name: " + employeeName
					+ "\t Shift: " + employeeShift
					+ "\t Salary: " + employeeSalary);
		}		
		
		
		cursor.close();
		conn.close();
	}

}
