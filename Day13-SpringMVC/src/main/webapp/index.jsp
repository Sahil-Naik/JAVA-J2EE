<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigate to Pages</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px; /* Space between buttons */
        }
        button {
            background-color: #007BFF;
            color: white;
            padding: 15px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s, transform 0.2s;
        }
        button:hover {
            background-color: #0056b3;
            transform: translateY(-2px); /* Slight lift effect */
        }
        button:active {
            transform: translateY(0); /* Reset lift effect on click */
        }
    </style>
</head>
<body>

    <h1>Navigate to Pages</h1>
    <div class="button-container">
        <form action="/SpringMVC/user" method="GET">
            <button type="submit">User </button>
        </form>
        <form action="/SpringMVC/info" method="GET">
            <button type="submit">Info</button>
        </form>
    </div>

</body>
</html>