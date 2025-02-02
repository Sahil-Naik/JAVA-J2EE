package wipro.day9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Servlet implementation class ProcessAction
 */
@WebServlet("/processaction")
public class ProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		 
		
		// Setting up Website Actions
		
		String action = request.getParameter("action");
		
		if ("login".equals(action)) {
            response.sendRedirect("login.jsp");  // Redirect to login page
        } else if ("signup".equals(action)) {
            response.sendRedirect("signup.jsp"); // Redirect to signup page
        }
	}

}
