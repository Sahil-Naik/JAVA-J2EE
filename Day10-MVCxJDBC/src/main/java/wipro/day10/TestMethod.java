package wipro.day10;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class TestMethod
 */

@WebServlet("/EmployeeServlet")
public class TestMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			String name = request.getParameter("employeeName");
			String shift = request.getParameter("employeeShift");
			int salary = Integer.parseInt(request.getParameter("employeeSalary"));
			addEmployee(name, shift, salary);
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("employeeId"));
			deleteEmployee(id);
		}
		//response.sendRedirect("viewEmployees.jsp");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employees = getEmployees();
		
		request.setAttribute("employees", employees);
		// Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewEmployees.jsp");
        dispatcher.forward(request, response);
	}

	private void addEmployee(String name, String shift, int salary) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO employee (employeeName, employeeShift, employeeSalary) VALUES (?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, shift);
			ps.setInt(3, salary);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteEmployee(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE employeeId=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			while (rs.next()) {
				list.add(new Employee(rs.getInt("employeeId"), rs.getString("employeeName"), rs.getString("employeeShift"), rs.getInt("employeeSalary")));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro?useSSL=false", "root", "root");
	}
}
