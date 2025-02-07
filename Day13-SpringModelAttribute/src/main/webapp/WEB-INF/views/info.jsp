<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        h2 {
            color: #555;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
            margin: 10px 0;
        }
        strong {
            color: #333;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #777;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Employee Information</h1>
        <h2>Details</h2>
        <p>
            <strong>Employee ID:</strong> ${test.employeeID}
        </p>
        <p>
            <strong>Employee Name:</strong> ${test.employeeName}
        </p>
        <p>
            <strong>Employee Department:</strong> ${test.employeeDepartment}
        </p>
        <p>
            <strong>Employee Salary:</strong> ${test.employeeSalary}
        </p>
        <h3>Address</h3>
        <p>
            <strong>City:</strong> ${test.address.cityName}
        </p>
        <p>
            <strong>State:</strong> ${test.address.stateName}
        </p>
        <p>
            <strong>Pincode:</strong> ${test.address.pincode}
        </p>
        <h3>Skills</h3>
        <p>
            <strong>Skills:</strong> ${test.skills}
        </p>
    </div>

    <div class="footer">
        <p>&copy; 2025 Employee Management System</p>
    </div>

</body>
</html>