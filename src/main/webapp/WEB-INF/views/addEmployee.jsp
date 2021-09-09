<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Employees Under ${deptname} Department</h2>
<form action="insertemployee" method="post">
Employee ID:<input type="number" name="eid"><br><br>
Employee First name:<input type="text" name="fname"><br><br>
Employee Middle name:<input type="text" name="mname"><br><br>
Employee Last name:<input type="text" name="lname"><br><br>
Employee Designation:<input type="text" name="designation"><br><br>
<p>Sex:</p>
	<input type="radio" id="male" name="sex" value="M">
  	<label for="male">Male</label><br>
  	<input type="radio" id="female" name="sex" value="F">
  	<label for="female">Female</label><br>
Email ID:<input type="email" name="email"><br><br>
Password:<input type="text" name="password"><br><br>
Manager ID:<input type="number" name="superid" value="${superid}" ><br><br>
Department ID:<input type="number" name="dnumber" value="${dnumber}"><br><br>
<input type="submit" value="Insert"><br><br>
<h4 style="color:blue">${msg}</h4><br><br>
<a href="backtomanagermain?empid=${superid}">Back</a><br><br>
</form>
</body>
</html>