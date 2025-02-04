package wipro.day11.mavensample;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;
import wipro.day11.mavensample.ConnectionClass;

@SuppressWarnings("unused")
public class BankQueries { 
	// We can write our required business logic methods here 
	public List<Privatebank> listUserDetails() 
	{ 
		ConnectionClass connClass = new ConnectionClass(); 
		Connection con = connClass.getFileFromResources(); 
		List<Privatebank> userList = new ArrayList<Privatebank>(); 
		Privatebank pvtbank = null; 
		ResultSet resultSet = null; 
		Statement statement = null; 
		String query = "SELECT * FROM privatebank"; 
		try { 
			statement = con.createStatement(); 
			resultSet = statement.executeQuery(query); 
			while (resultSet.next()) { 
				pvtbank = new Privatebank(); 
				
				pvtbank.setHoldername(resultSet.getString(2));
				pvtbank.setPhone(resultSet.getInt(3));
				pvtbank.setAccountpin(resultSet.getInt(4));
				pvtbank.setHolderdob(resultSet.getString(5));
				pvtbank.setBalance(resultSet.getInt(6));
				
				// System.out.println(rs.getInt(1) + " " + rs.getString(2)); 
				userList.add(pvtbank); 
			} 
		} 
		catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		finally { 
			ConnectionClass.close(con); 
			ConnectionClass.close(statement); 
			ConnectionClass.close(resultSet); 
		} 
		return userList; 
	} 

	public String getuserNameById(int accountid) 
	{ 
		ConnectionClass connClass = new ConnectionClass(); 
		Connection con = connClass.getFileFromResources(); 
		PreparedStatement pStmt = null; 
		ResultSet rs = null; 
		String userName = null; 
		try { 
			String query = "select * from privatebank where accountid=?"; 
			pStmt = con.prepareStatement(query); 
			pStmt.setInt(1, accountid); 
			rs = pStmt.executeQuery(); 

			while (rs.next()) { 
				userName = rs.getString("holdername"); 
				System.out.println(rs.getString(2)); 
			} 
		} 
		catch (SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
		finally { 
			ConnectionClass.close(con); 
			ConnectionClass.close(pStmt); 
			ConnectionClass.close(rs); 
		} 
		return userName; 
	} 

	public static int getuserBalance(int accountid) 
	{ 
		ConnectionClass connClass = new ConnectionClass(); 
		Connection con = connClass.getFileFromResources(); 
		PreparedStatement pStmt = null; 
		ResultSet rs = null; 
		int balance = 0; 
		try { 
			String query = "select * from privatebank where accountid=?"; 
			pStmt = con.prepareStatement(query); 
			pStmt.setInt(1, accountid); 
			rs = pStmt.executeQuery(); 
			while (rs.next()) { 
				balance = rs.getInt("balance"); 
				System.out.println(balance); 
			} 
		} 
		catch (SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
		finally { 
			ConnectionClass.close(con); 
			ConnectionClass.close(pStmt); 
			ConnectionClass.close(rs); 
		} 
		return balance; 
	}
	
	public static void main(String[] args) {
		
		System.out.println("Hello");
		System.out.println(getuserBalance(1001));
		
		
	}
}

