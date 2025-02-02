package wipro.day9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class NewDetails
 */

@WebServlet("/newdetails")
public class NewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Setting up SQL Connection
		Connection conn = null;
		try {
			conn = BankOperation.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String holdername = request.getParameter("holdername");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String dob = request.getParameter("dob");
		int pin = Integer.parseInt(request.getParameter("pin"));

		try {
			boolean gotAdded = BankOperation.AddAccount(conn, holdername, phone, dob, pin);
			if (gotAdded) {
				response.getWriter().println("<h1>Sign Up Successful!</h>");
				Thread.sleep(2000);
				
				out.println("<html><head><title>Redirecting...</title></head><body>");
				out.println("<h1>Redirecting to Login page in <span id='countdown'>3</span> seconds...</h1>");
				out.println("<script>");
				out.println("var count = 3;");
				out.println("var countdown = setInterval(function() {");
				out.println("  document.getElementById('countdown').innerText = count;");
				out.println("  count--;");
				out.println("  if (count < 0) {");
				out.println("    clearInterval(countdown);");
				out.println("    window.location.href = 'login.jsp';");
				out.println("  }");
				out.println("}, 1000);");
				out.println("</script>");
				out.println("</body></html>");
				out.close();
				
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("+++++++++++++++++PROBLEM++++++++++++++");
			response.getWriter().println("<h1>Failed to Sign Up</h>");
			System.out.println(e.getMessage());
			
			out.println("<html><head><title>Redirecting...</title></head><body>");
			out.println("<h1>Redirecting to Sign-up page in <span id='countdown'>3</span> seconds...</h1>");
			out.println("<script>");
			out.println("var count = 3;");
			out.println("var countdown = setInterval(function() {");
			out.println("  document.getElementById('countdown').innerText = count;");
			out.println("  count--;");
			out.println("  if (count < 0) {");
			out.println("    clearInterval(countdown);");
			out.println("    window.location.href = 'signup.jsp';");
			out.println("  }");
			out.println("}, 1000);");
			out.println("</script>");
			out.println("</body></html>");
			out.close();
			
			response.sendRedirect("signup.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
