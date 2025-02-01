package wipro.day9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TargetServlet
 */

@WebServlet("/target")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // response.getWriter().println("<h1>The answer is: </h1>");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
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
		
		String operation = n1+" "+opr+" "+n2;
		
		// Set the answer as a request attribute
        request.setAttribute("answer", result);
        request.setAttribute("operation", operation);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
		//response.getWriter().println("<h1>Restult: " + result+"</h>");
        
		}

}
