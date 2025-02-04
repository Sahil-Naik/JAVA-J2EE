<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding Employee</title>
</head>
<body>
    <h2>Add New Employee</h2>
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="employeeName">Employee Name:</label>
        <input type="text" id="employeeName" name="employeeName" required>
        <br>
        <label for="employeeShift">Shift:</label>
        <input type="text" id="employeeShift" name="employeeShift" required>
        <br>
        <label for="employeeSalary">Salary:</label>
        <input type="number" id="employeeSalary" name="employeeSalary" required>
        <br>
        <input type="submit" value="Add Employee">
    </form>
    <br>
    <a href="viewEmployees.jsp">View Employees</a>
    <a href="deleteEmployees.jsp">Delete Employees</a>
</body>
</html>