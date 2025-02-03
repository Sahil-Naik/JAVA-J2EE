<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="wipro.day10.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Record</title>
</head>
<body>

	<jsp:useBean id="employee" class="wipro.day10.Employee"></jsp:useBean>

	<%
	String employeeName = request.getParameter("epName");
	int employeeID = Integer.parseInt(request.getParameter("epID"));
	%>

	<!-- The following code technical sets values inside the Employee class
	It uses the Setters and Getters to store and fetch the values 
	It is very important to follow strict Dtypes accross the flow -->

	<jsp:setProperty property="epName" name="employee"
		value="<%=employeeName%>" />
	<jsp:setProperty property="epID" name="employee"
		value="<%=employeeID%>" />

	<!-- The following code is used to fetch the values stored inside
	the Employee class -->

	<h2>
		Employee id is:
		<jsp:getProperty property="epID" name="employee" /></h2>
	<br>
	<h2>
		Employee name is:
		<jsp:getProperty property="epName" name="employee" /></h2>

</body>
</html>