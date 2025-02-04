package wipro.day11.mavensample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.util.List;
import org.junit.Test;
import wipro.day11.mavensample.Privatebank;
import wipro.day11.mavensample.BankQueries;
import wipro.day11.mavensample.ConnectionClass;

@SuppressWarnings("unused")
public class PrivatebankUserTest {
	BankQueries userQueriesObject = new BankQueries();

	// DB Connection test
	@Test
	public void connection_Test() {
		ConnectionClass connClass = new ConnectionClass();
		Connection con = connClass.getFileFromResources();
		System.out.println(con);
	}

	@Test
	public void listUserDetails_positive() {
		List<Privatebank> listUserDetails = userQueriesObject.listUserDetails();

		// Checking whether totally 5 users are available
		assertEquals(listUserDetails.size(), 5);

		// Checking whether first account id is 1
		//assertEquals(listUserDetails.get(0).getAccountid(), 1000);

		// Checking whether first bank user name is Marika
		assertEquals(listUserDetails.get(0).getHoldername(), "Marika");

		// Checking whether second bank user name is Radagon
		assertEquals(listUserDetails.get(1).getHoldername(), "Radagon");
	}

	@Test
	public void listUserDetails_negative() {
		List<Privatebank> listUserDetails = userQueriesObject.listUserDetails();
		// As this is negative testing we need to check with assertNotEquals
		assertNotEquals(listUserDetails.size(), 11);

		// Checking whether first accountid is not 10
		assertNotEquals(listUserDetails.get(0).getAccountid(), 10);

		// Checking whether first user name is not Marika
		assertNotEquals(listUserDetails.get(1).getHoldername(), "Marika");

		// Checking whether second user balance is not 27251
		assertNotEquals(listUserDetails.get(2).getBalance(), 27251);
	}

	@Test
	public void getuserName_PositiveTestCase() {
		String userName = userQueriesObject.getuserNameById(1000);
		assertEquals(userName, "Marika");
		userName = userQueriesObject.getuserNameById(1002);
		assertEquals(userName, "Elden");
		userName = userQueriesObject.getuserNameById(1013);
		assertEquals(userName, "Test22");
	}

	@Test
	public void getduserName_NegativeTestCase() {
		String userName = userQueriesObject.getuserNameById(2);
		assertNotEquals(userName, "Nothing");
	}

	@Test
	public void getFirstuserBalance_PositiveTestCase() {
		int balance = BankQueries.getuserBalance(1000);
		assertEquals(balance, 43099);
	}

	@Test
	public void getSeconduserBalance_NegativeTestCase() {
		int balance = BankQueries.getuserBalance(2);
		assertNotEquals(balance, 27251);
	}
}
