<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Assign Projects to Employees Under ${deptname} Department </h3>
<form action="insertworkson" method="post">
<input type="hidden" name="superid" value="${superid}"><br><br>
Work ID:<input type="number" name="workid"><br><br>
Project ID:<select name="pid">
<c:forEach items="${plist}" var="p">
<option value="${p.getPnumber()}">${p.getPnumber()}</option>
</c:forEach>
</select><br><br>
Employee ID:<select name="eid">
<c:forEach items="${elist}" var="e">
<option value="${e.getEmpid()}">${e.getEmpid()}</option>
</c:forEach>
</select><br><br>

<input type="submit" value="Insert"><br><br>
<h4 style="color:blue">${msg}</h4><br><br>
<a href="backtomanagermain?empid=${superid}">Back</a><br><br>

</form>
</body>
</html>