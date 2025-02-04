<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
</head>
<body>
	<form action="EmployeeServlet" method="post">
	<input type="hidden" name="action" value="delete">
        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="employeeId" required>
        <br>
        <input type="submit" value="Delete Employee">
    </form>
    <br>
    <a href="viewEmployees.jsp">View Employees</a>
</body>
</html>