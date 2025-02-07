<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration Form</title>
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
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="text"]:focus,
        input[type="number"]:focus {
            border-color: #007BFF;
            outline: none;
        }
        h3 {
            margin-top: 20px;
            color: #555;
        }
        button {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Employee Registration Form</h2>
        <form action="saveEmployee" method="post">
            <label for="employeeID">Employee ID:</label>
            <input type="number" id="employeeID" name="employeeID" required>

            <label for="employeeName">Employee Name:</label>
            <input type="text" id="employeeName" name="employeeName" required>
            
            <label for="employeeDepartment">Employee Department:</label>
            <input type="text" id="employeeDepartment" name="employeeDepartment" required>
            
            <label for="employeeSalary">Employee Salary:</label>
            <input type="number" id="employeeSalary" name="employeeSalary" required>
            
            <h3>Address</h3>
            <label for="cityName">City Name:</label>
            <input type="text" id="cityName" name="cityName" required>

            <label for="stateName">State Name:</label>
            <input type="text" id="stateName" name="stateName" required>

            <label for="pincode">Pincode:</label>
            <input type="text" id="pincode" name="pincode" required>

            <h3>Skills</h3>
            <label for="skills">Skills (comma separated):</label>
            <input type="text" id="skills" name="skills">
 
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>