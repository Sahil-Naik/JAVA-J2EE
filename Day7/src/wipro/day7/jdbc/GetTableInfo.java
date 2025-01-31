package wipro.day7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class GetTableInfo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Loading the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Setting up the Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro?useSSL=false", "root", "root");
		System.out.println("Connection Successful!");

		// Setting up the Statement module
		Statement cursor = conn.createStatement();

		String myQuery = "SELECT * FROM employee";

		ResultSet result = cursor.executeQuery(myQuery);

		ResultSetMetaData rsmd = result.getMetaData();

		System.out.println("\nInfo about 'Employee'");
		System.out.println("Number of Columns are: " + rsmd.getColumnCount());
		System.out.println("\nDtype\t|Size\t|Read-only\t|Precision");
		System.out.println("*****************************************");
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnTypeName(i) + "\t|" + rsmd.getColumnDisplaySize(i) + "\t|"
					+ rsmd.isReadOnly(i) + "\t\t|" + rsmd.getPrecision(i));
		}

		conn.close();
	}
}
