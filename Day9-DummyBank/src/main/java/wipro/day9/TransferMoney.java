package wipro.day9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/transfermoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//response.sendRedirect("welcome.jsp");
		
		// Setting up SQL Connection
		Connection conn = null;
		try {
			conn = BankOperation.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object bankID = request.getAttribute("accountid");
		request.setAttribute("accountid", bankID);
		System.out.println("++++++++++++++++++++++"+bankID);
		
		request.getRequestDispatcher("welcome.jsp").forward(request, response);

		boolean login = true;//BankOperation.CheckAccount(conn, bankID);
		if (login) {
			// Set the answer as a request attribute
			// response.sendRedirect("welcome.jsp");
			System.out.println("inside transfer");
			
		} else {
			response.getWriter().println("<h1>Failed to Login</h>");
		}
	}

}
