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
</head>
<h2>Employee Working On Project ID:${pid}</h2>
<body>
<table border=2>
<tr>
<th>Work ID</th>
<th>Project ID</th>
<th>Employee ID</th>
<th>Hours</th>

</tr>
<c:forEach items="${wlist}" var="w">
<tr>
<td>${w.getWorkid()}</td>
<td>${w.getPno()}</td>
<td>${w.getEid()}</td>
<td>${w.getHours()}</td>
</tr>


</c:forEach>


</table>
<a href="backtomanagermain?empid=${superid}">Back</a><br><br>
</body>
</html>