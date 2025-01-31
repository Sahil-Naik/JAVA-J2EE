package wipro.day7.junit;

import wipro.day7.jdbc.TransactionDynamic;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class JunitTesterModule2 {

	@Test
	public void testCheckAccount() throws SQLException, ClassNotFoundException {

		// Setting up Dummy Connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = TransactionDynamic.getConnection();

		assertEquals(true, TransactionDynamic.CheckAccount(conn, 1001));
		assertEquals(true, TransactionDynamic.CheckAccount(conn, 1000));
		assertEquals(true, TransactionDynamic.CheckAccount(conn, 1002));
		assertEquals(false, TransactionDynamic.CheckAccount(conn, 1003));
		assertEquals(false, TransactionDynamic.CheckAccount(conn, 1004));

		// Failure Cases
		/*
		 * assertEquals(true, TransactionDynamic.CheckAccount(conn, 1004)); The above
		 *  -> Account-ID: 1004 does not exist, so it should return 'false'.
		 * 
		 * assertEquals(false, TransactionDynamic.CheckAccount(conn, 1001)); The above
		 *  -> Account-ID 1001 does exist, so it should return 'true'.
		 * 
		 */

		conn.close();
	}

	@Test
	public void testCheckBalance() throws SQLException, ClassNotFoundException {

		// Setting up Dummy Connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = TransactionDynamic.getConnection();

		assertEquals(43099, TransactionDynamic.CheckBalance(conn, 1000));
		assertEquals(27251, TransactionDynamic.CheckBalance(conn, 1001));
		assertEquals(41400, TransactionDynamic.CheckBalance(conn, 1002));

		// Failure Cases
		/* 
		 * assertEquals(0, TransactionDynamic.CheckBalance(conn, 1003));
		 *  -> The above case will never happen, since to use the 'CheckBalance' function
		 *     you will first need to login using valid Login Credentials. 
		 *  -> If Account-ID 1003 does not exist, then one cannot login to that account and ultimately
		 *     cannot use the 'CheckBalance' function.
		 */

		conn.close();
	}
	
	@Test
	public void testUserLogin() throws SQLException, ClassNotFoundException {

		// Setting up Dummy Connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = TransactionDynamic.getConnection();

		assertEquals(true, TransactionDynamic.UserLogin(conn, 1000, 1234));
		assertEquals(true, TransactionDynamic.UserLogin(conn, 1001, 9876));
		assertEquals(true, TransactionDynamic.UserLogin(conn, 1002, 8866));

		// Failure Cases
		
		/* Acutal ID: 1000 
		 * Actual Pin: 1230
		 * 
		 * assertEquals(true, TransactionDynamic.UserLogin(conn, 1000, 1230));
		 *  -> Even though the Actual ID is right but due to Pin being wrong
		 *     it should not return 'true'.
		 *  
		 * assertEquals(true, TransactionDynamic.UserLogin(conn, 10000, 1234));
		 *  -> Even though the Actual Pin matches one of the Pin from table,
		 *     but the Account ID does not exist and is thus not valid, so it
		 *     should not retrun 'true'
		 *     
		 * assertEquals(false, TransactionDynamic.UserLogin(conn, 1000, 1234));
		 *  -> When the Actual ID and Actual Pin are right, there is no reason
		 *     for the module to return 'false'.
		 *     This might hint towards Code being problematic or irregularites
		 *     in the logic.
		 */

		conn.close();
	}
	
	

}
