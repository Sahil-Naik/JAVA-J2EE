<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operations Results</title>
</head>
<body>	

	<%@ page import="java.util.Date"%>
	Today is:
	<%=new Date()%>
	
	<br><br>
	
	<%
	int number1 = Integer.parseInt(request.getParameter("number1"));
	int number2 = Integer.parseInt(request.getParameter("number2"));

	double result = 0;
	String opr = request.getParameter("opr");
	if (opr.equals("+"))
		result = number1 + number2;
	if (opr.equals("-"))
		result = number1 - number2;
	if (opr.equals("*"))
		result = number1 * number2;
	if (opr.equals("/"))
		result = number1 / number2;

	out.println("\nResult of " + number1 + " " + opr + " " + number2 + " = " + result);
	%>

</body>
</html>