package wipro.day9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/requestdetails")
public class RequestDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setting up SQL Connection
		Connection conn = null;
		try {
			conn = BankOperation.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int bankID = Integer.parseInt(request.getParameter("username"));
		int userPin = Integer.parseInt(request.getParameter("pin"));

		try {
			boolean login = BankOperation.UserLogin(conn, bankID, userPin);
			if (login) {
				// Set the answer as a request attribute
				// response.sendRedirect("welcome.jsp");

				int userBalance = BankOperation.CheckBalance(conn, bankID);

				// Set the answer as a request attribute
				request.setAttribute("accountid", bankID);
				request.setAttribute("balance", userBalance);

				// Forward the request to the JSP page
				request.getRequestDispatcher("welcome.jsp").forward(request, response);

				//request.getRequestDispatcher("transfermoney").forward(request, response);
			} else {
				response.getWriter().println("<h1>Failed to Login</h>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("+++++++++++++++++PROBLEM++++++++++++++");
			e.printStackTrace();
		}

	}

}
