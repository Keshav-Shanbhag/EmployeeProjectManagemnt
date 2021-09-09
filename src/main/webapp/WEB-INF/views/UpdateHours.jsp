<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Update Hours You Worked For Project ID:${w1.getPno()}</h3><br>
<form action="updateHours" method="post">
Employee ID:<input type="hidden" name="eid" value="${w1.getEid()}"><br><br>
Work ID:<input type="hidden" name="workid" value="${w1.getWorkid()}"><br><br>
Project ID:<input type="hidden" name="pid" value="${w1.getPno()}"><br><br>
Hours:<input type="number" name="hours" value="${w1.getHours()}"><br><br>
<input type="submit" value="Update">

<h4 style="color:blue">${msg}</h4>
<a href="backtoempmain?empid=${empid}">Back</a>
</form>
</body>
</html>