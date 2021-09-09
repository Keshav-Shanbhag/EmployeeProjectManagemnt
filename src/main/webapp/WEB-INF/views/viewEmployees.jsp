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
<h1>Employees Working in ${deptname} under ${manager_name}</h1>
<body>
<table border=2>
<tr>
<th>Employee ID</th>
<th>First Name</th>
<th>Middle Name</th>
<th>Last Name</th>
<th>Date Of Birth</th>
<th>Designation</th>
<th>Mail ID</th>
<th>Phone</th>
<th>Address</th>
</tr>
<c:forEach items="${elist}" var="e">
<tr>
<td>${e.getEmpid()}</td>
<td>${e.getFname()}</td>
<td>${e.getMname()}</td>
<td>${e.getLname()}</td>
<td>${e.getDob()}</td>
<td>${e.getDesignation()}</td>
<td>${e.getEmail()}</td>
<td>${e.getPhonenum()}</td>
<td>${e.getAddress()}</td>
</tr>


</c:forEach>


</table>



<a href="backtomanagermain?empid=${superid}">Back</a><br><br>
</body>
</html>