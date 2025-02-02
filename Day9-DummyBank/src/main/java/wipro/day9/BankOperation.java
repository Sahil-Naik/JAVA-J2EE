package wipro.day9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankOperation {
	public static boolean AddAccount(Connection conn, String holdername, int phone, String dob, int pin)
			throws SQLException {
		String sql = "INSERT INTO privatebank (holdername, phone, accountpin, holderdob, balance) VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, holdername);
		ps.setInt(2, phone);
		ps.setInt(3, pin);
		ps.setString(4, dob);		
		ps.setInt(5, 0);

		//System.out.println(sql);

		int result = ps.executeUpdate();

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	// Function to get a database connection
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/wipro?useSSL=false";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}

	public static boolean UserLogin(Connection conn, int id, int pin) throws SQLException {
		Statement cursor = conn.createStatement();

		String loginIN = "SELECT * FROM privatebank WHERE accountid=" + id + " AND accountpin=" + pin;

		// System.out.println(loginIN);

		ResultSet result = cursor.executeQuery(loginIN);

		if (result.next()) {
			return true;
		} else {
			return false;
		}
	}

	public static int CheckBalance(Connection conn, int accountID) throws SQLException {
		Statement cursor = conn.createStatement();
		String checker = "SELECT * FROM privatebank WHERE accountid=" + accountID;

		// System.out.println(checker);

		ResultSet result = cursor.executeQuery(checker);

		result.next();
		int balance = result.getInt("balance");
		// System.out.println("\nAccount ID: " + accountID + "\tBalance: " +
		// result.getInt("balance"));
		return balance;
	}

	public static boolean CheckAccount(Connection conn, int accountID) throws SQLException {
		Statement cursor = conn.createStatement();
		String checker = "SELECT * FROM privatebank WHERE accountid=" + accountID;

		ResultSet result = cursor.executeQuery(checker);
		if (result.next()) {
			return true;
		} else {
			return false;
		}
	}

	public static void TransferFunds(Connection conn, int debitAccountID1, int creditAccountID2, int debit, int credit)
			throws SQLException {
		Statement cursor = conn.createStatement();

		// Setting up the PreparedStatement module
		String debitUser = "UPDATE privatebank SET balance=balance-" + debit + " WHERE accountid=" + debitAccountID1;
		String creditUser = "UPDATE privatebank SET balance=balance+" + credit + " WHERE accountid=" + creditAccountID2;

		// System.out.println("Debit SQL: "+debitUser);
		// System.out.println("Credit SQL: "+creditUser);
		if (CheckBalance(conn, debitAccountID1) >= debit) {
			int flagDebitUser = cursor.executeUpdate(debitUser);
			int flagCreditUser = cursor.executeUpdate(creditUser);

			if (flagDebitUser > 0 && flagCreditUser > 0) {
				conn.commit();
				System.out.println("\n\tFunds Transferred!");
			} else {
				conn.rollback();
				System.out.println("\n\tInvalid AccountID!");
			}
		} else {
			System.out.println("\n\tInsufficient Balance!");
		}

	}
}
