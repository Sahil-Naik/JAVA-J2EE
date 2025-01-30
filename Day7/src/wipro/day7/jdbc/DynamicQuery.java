package wipro.day7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class DynamicQuery {
	public static void main(String[] args) throws Exception{
		// Loading the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Setting up the Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro?useSSL=false", "root", "root");
		System.out.println("Connection Successful!");
		
		// Setting up the Statement module
		Statement cursor = conn.createStatement();
		
		// Logic starts here!
		Scanner sc = new Scanner(System.in);
		
		int userChoice = 0;
		
		
		do {
			System.out.println("1 = View\n2 = Add\n3 = Delete\n4 = Exit");
			System.out.printf("Choose: ");
			userChoice = sc.nextInt();
			
			switch(userChoice) {
				case 1: {
					System.out.println("\nDisplaying Data...");
					
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
					System.out.printf("\n");
					break;
				}
				
				case 2: {
					String sql = "INSERT INTO employee VALUES (?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					System.out.println("\nAdding Data...");
					
					int epId, eSalary;
					String eName, eShift;
					
					// Inserting data using SQL query	
					
					System.out.printf("\nEnter Employee ID: ");
					epId = sc.nextInt();
					ps.setInt(1, epId);
					
					System.out.printf("\nEnter Employee Name: ");
					eName = sc.next();
					ps.setString(2, eName);
					
					System.out.printf("\nEnter Employee Shift: ");
					eShift = sc.next();
					ps.setString(3, eShift);
					
					System.out.printf("\nEnter Employee Salary: ");
					eSalary = sc.nextInt();
					ps.setInt(4, eSalary);							        
			        
			        //System.out.println("\nQuery is: "+sql);
			        
			        // Executing query
		            int m = ps.executeUpdate();
		            if (m == 1)
		                System.out.println(
		                    "\nInserted successfully");
		            else
		                System.out.println("\nInsertion failed!");

				}
				System.out.printf("\n");
				break;
				
				case 3: {
					String sql = "DELETE FROM employee WHERE employeeId = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					System.out.println("\nDeleting record using Employee ID...");
					int epId;
					
					System.out.printf("Enter ID to Delete: ");
					epId = sc.nextInt();
					ps.setInt(1, epId);
					
					//String sql = "DELETE FROM employee WHERE employeeId='"+epId+"'";
					//System.out.println("\nQuery is: "+sql);
					
					// Executing query
		            int m = ps.executeUpdate();
		            if (m == 1)
		                System.out.println(
		                    "\nDeleted successfully");
		            else
		                System.out.println("\nDeletion failed!\nNo such record found.");
				}
				System.out.printf("\n");
				break;
				
				case 4: {
					userChoice = 4;
					System.out.println("\nExiting...");
					break;
				}
				
				default: {
					System.out.println("Invalid Choice!");
					break;
				}
			}
			
		} while (userChoice!=4);			
		
		
		cursor.close();
		conn.close();
	}
}
