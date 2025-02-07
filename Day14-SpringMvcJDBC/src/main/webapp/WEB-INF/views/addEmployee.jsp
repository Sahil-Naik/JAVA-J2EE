<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 400px;
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
            margin-bottom: 8px;
            color: #555;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Add Employee</h2>
    <form action="addEmployee" method="post">
        <label for="employeeName">Name:</label>
        <input type="text" id="employeeName" name="employeeName" required>

        <label for="employeeShift">Shift:</label>
        <input type="text" id="employeeShift" name="employeeShift" required>

        <label for="employeeSalary">Salary:</label>
        <input type="number" id="employeeSalary" name="employeeSalary" required>

        <input type="submit" value="Add Employee">
    </form>
</div>

</body>
</html>