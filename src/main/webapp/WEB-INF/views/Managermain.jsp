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
<h1>Welcome ${managername}</h1>
<h2>Head Of ${deptname} Department</h2>
<h2>Summary Of Projects Under ${deptname} Department</h2>
<table border=2>
<tr>
<th>Project ID</th>
<th>Project Name</th>
<th>Start Date</th>
<th>End Date</th>
<th> Details</th>
</tr>
<c:forEach items="${plist}" var="p">
<tr>
<td>${p.getPnumber()}</td>
<td>${p.getPname()}</td>
<td>${p.getStartDate()}</td>
<td>${p.getEndDate()}</td>
<td><a href="displayWorkson?pid=${p.getPnumber()}&superid=${managerid}"> More Details</a></td>
</tr>
</c:forEach>
</table>
<a href="index">LogOut</a><br><br>
<a href="addemp?superid=${managerid}&dnumber=${dnum}">Add Employee</a><br><br>
<a href="addproject?dnumber=${dnum}&superid=${managerid}">Add Project</a><br><br>
<a href="addDepartment?superid=${managerid}"> Add Department</a><br><br>
<a href="addworkson?dnumber=${dnum}&superid=${managerid}">Assign Project</a><br><br>
<a href="viewemployees?superid=${managerid}&dnumber=${dnum}">Know Who All Are Working Under You!!!</a><br><br>
</body>
</html> 