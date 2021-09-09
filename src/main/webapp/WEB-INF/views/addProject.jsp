<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Project Under ${deptname} Department</h2>
<form action="insertproject" method="post">
<input type="hidden" name="superid" value="${superid}"><br><br>
Project ID:<input type="number" name="pnumber"><br><br>
Project Name:<input type="text" name="pname"><br><br>
Start Date:<input type="date" name="startdate"><br><br>
End Date:<input type="date" name="enddate"><br><br>
Department ID:<input type="number" name="dnumber" value="${dnumber}"><br><br>
<input type="submit" value="Insert"><br><br>

<h4 style="color:blue">${msg}</h4><br><br>
<a href="backtomanagermain?empid=${superid}">Back</a><br><br>
</form>
</body>
</html>