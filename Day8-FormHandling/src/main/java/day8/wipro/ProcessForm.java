package day8.wipro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ProcessForm
 */

@WebServlet("/process")
public class ProcessForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(request.getParameter("t1"));
		int n2 = Integer.parseInt(request.getParameter("t2"));

		double result = 0;
		String opr = request.getParameter("opr");
		if (opr.equals("+"))
			result = n1 + n2;
		if (opr.equals("-"))
			result = n1 - n2;
		if (opr.equals("*"))
			result = n1 * n2;
		if (opr.equals("/"))
			result = n1 / n2;

		response.getWriter().println("sum is: " + result);
	}

}
