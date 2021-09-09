<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align=center>
<h1>Welcome to LTTS Company!!!</h1>
<h4 style="color:red">${msg}</h4>
<form action="checkemp">
User Name: <input type="text" name="empid" placeholder="Enter your Employee ID"><br><br>
Pass word: <input type="password" name="password" placeholder="Enter your Password" minlength="8"><br><br>
<input type="submit" value="Log in">
</form>
</body>
</html>