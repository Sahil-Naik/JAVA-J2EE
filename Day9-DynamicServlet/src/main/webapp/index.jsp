<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opeartions</title>
</head>
<body>
	<form action="forward">

		Enter first no: <input type="text" name="t1" /><br />
		Enter second no: <input type="text" name="t2" /><br />
		<input type="radio" name="opr" value="+">ADDTION
		<input type="radio" name="opr" value="*">MULTIPLY
		<input type="radio" name="opr" value="/">DIVIDE
		<input type="radio" name="opr" value="-">Substraction<br>
		
		<input type="reset"> <input type="submit" value="Calculate">
	</form>

	<p id="result">
		<% if (request.getAttribute("answer") != null) { %>
		Result: <%= request.getAttribute("operation") %>
		
		= <%= request.getAttribute("answer") %>
		
		<% } %>
	
</body>
</html>