<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertdepartment" method="post">
<input type="hidden" name="superid" value="${superid}"><br><br>
Department ID:<input type="number" name="dnumber"><br><br>
Department Name:<input type="text" name="dname"><br><br>
Department location:<input type="text" name="dlocation"><br><br>
Manager ID:<input type="number" name="mgr_id"><br><br>
<input type="submit" value="Insert">
<h4 style="color:blue">${msg}</h4>
<a href="backtomanagermain?empid=${superid}">Back</a><br><br>
</form>
</body>
</html>