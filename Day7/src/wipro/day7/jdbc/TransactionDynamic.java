package wipro.day7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class TransactionDynamic {

	// Function to get a database connection
	public static Connection getConnection() throws Exception, SQLException  {
		
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

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = getConnection();
		// System.out.println("Connection Successful!");

		// Disable autocommit to allow Rollback action
		conn.setAutoCommit(false);

		// Logic Starts Here!
		String holderName, holderDob;
		int myAccountID, receiverAccountID;
		int phone, accountPin;

		int userChoice = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n>>1 = Login\n>>2 = Exit");
			System.out.printf("Choose: ");
			int moduleChoice = sc.nextInt();

			switch (moduleChoice) {
			case 1: {
				int loginId, loginPin;
				System.out.printf("\nEnter Account-ID: ");
				loginId = sc.nextInt();
				System.out.printf("Enter PIN: ");
				loginPin = sc.nextInt();

				boolean flag = UserLogin(conn, loginId, loginPin);

				if (flag) {
					int coreModuleChoice = 0;
					do {
						System.out.println("\n||| 1 = Check Balance\n||| 2 = Transfer Money\n||| 3 = Logout");
						System.out.printf("||| Choose: ");

						coreModuleChoice = sc.nextInt();

						switch (coreModuleChoice) {
						case 1: {
							int userBalance = CheckBalance(conn, loginId);
							System.out.println("\n\tAccount ID: " + loginId + "\n\tBalance: Rs. " + userBalance);
							break;
						}

						case 2: {
							System.out.printf("\n\tEnter Receiver Account-ID: ");
							receiverAccountID = sc.nextInt();

							if (receiverAccountID == loginId) {
								System.out.println("\n\tSelf Transaction not possible\n\tEnter Receiver Account-ID");
							} else {

								boolean rFlag = CheckAccount(conn, receiverAccountID);

								if (rFlag) {
									int debit, credit;
									myAccountID = loginId;
									System.out.printf("\tEnter amount: ");
									debit = sc.nextInt();

									if (debit < 0 && debit != 0) {
										System.out.println("\n\tAmount cannot be less than Zero!");
									} else if (debit == 0 && debit > -1) {
										System.out.println("\n\tAmount cannot be Zero");
									} else {
										credit = debit;
										TransferFunds(conn, myAccountID, receiverAccountID, debit, credit);
									}
									
								} else {
									System.out.println("\n\tFailed to fetch receiver account details!");
									System.out.println("\tCheck Account-ID again!");
								}
							}

							break;
						}

						case 3: {
							coreModuleChoice = 3;
							System.out.println("\nLoggin Out!");
							break;
						}
						default: {
							System.out.println("\nInvalid Choice");
							break;
						}
						} // END INNER SWITCH

					} while (coreModuleChoice != 3);
				} else {
					System.out.println("\nLogin Failed Try Again!");
				}
				break;
			}

			case 2: {
				userChoice = 2;
				System.out.println("\nExiting...");
				break;
			}

			default: {
				System.out.println("\nInvalid Choice");
				break;
			}
			} // END OUTER SWITCH

		} while (userChoice != 2);

		conn.close();
	}

}
