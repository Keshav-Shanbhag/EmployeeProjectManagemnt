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


<h1>Welcome "${empname}" to LTTS Company</h1>
<h2> You are in "${deptname}" Department</h2>
<h3> Here is Summary Of Projects You Are Handling</h3>
<table border=2>
<tr>
<th>Work ID</th>
<th>Project ID</th>
<th>Hours Logged In</th>
<th>Update Hours</th>
</tr>
<c:forEach items="${wonlist}" var="w">
<tr>
<td>${w.getWorkid()}</td>
<td>${w.getPno()}</td>
<td>${w.getHours()}</td>
<td><a href="updateWorkson?Workid=${w.getWorkid()}&eid=${empid}"> Update Hours</a></td>
</tr>
</c:forEach>
</table>


<a href="updateEmployee?eid=${empid}">Update Profile</a><br>
<a href="index">LogOut</a><br><br>
</body>
</html>