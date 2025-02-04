<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="wipro.day10.Employee" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Shift</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Get the list of employees from the request attribute
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");

                // Loop through the list of employees and display each
                for (Employee employee : employees) {
            %>
                <tr>
                    <td><%= employee.getEmployeeId() %></td>
                    <td><%= employee.getEmployeeName() %></td>
                    <td><%= employee.getEmployeeShift() %></td>
                    <td><%= employee.getEmployeeSalary() %></td>
                </tr>
            <% 
                }
            %>
        </tbody>
    </table>
    <br><br>
    <a href="addEmployee.jsp">Add Employees</a>
    <a href="deleteEmployees.jsp">Delete Employees</a>
</body>
</html>
