<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: white;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #5cb85c;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

<h2>Employee List</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Shift</th>
        <th>Salary</th>
    </tr>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.employeeName}</td>
            <td>${emp.employeeShift}</td>
            <td>${emp.employeeSalary}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>