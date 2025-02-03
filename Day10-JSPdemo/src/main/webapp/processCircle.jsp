<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area of Circle</title>
</head>
<body>

	<%! double pi=3.14; %>  
	
	<%-- <%@ page import="java.util.Date"%>
	Today is:
	<%=new Date()%> --%>
	
	<br><br>
	
	<%
	int radius = Integer.parseInt(request.getParameter("radii"));

	double aoc = pi * (radius*radius);

	out.println("\nArea of Circle with radius "+radius+" is "+aoc);
	%>

</body>
</html>