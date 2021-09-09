<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Your Details</h2>
<form action="updateemp" method="post" enctype="multipart/form-data">
Employee ID:<input type="hidden" name="eid" value="${emp.getEmpid()}"><br><br>
Employee First name:<input type="text" name="fname" value="${emp.getFname()}"><br><br>
Employee Middle name:<input type="text" name="mname" value="${emp.getMname()}"><br><br>
Employee Last name:<input type="text" name="lname" value="${emp.getLname()}"><br><br>
Employee Designation:<input type="hidden" name="designation" value="${emp.getDesignation()}"><br><br>
Date Of Birth:<input type="date" name="dob" value="${emp.getDob()}"><br><br>
Sex:<input type="hidden" name="sex" value="${emp.getSex()}"><br><br>
Address:<input type="text" name="address" value="${emp.getAddress()}"><br><br>
Phone:<input type="text" name="phone" value="${emp.getPhonenum()}"><br><br>
Email ID:<input type="hidden" name="email" value="${emp.getEmail()}"><br><br>
Password:<input type="text" name="password" value="${emp.getPassword()}"><br><br>
Manager ID:<input type="hidden" name="superid" value="${emp.getSuper_id()}" ><br><br>
Department ID:<input type="hidden" name="dnumber" value="${emp.getDno()}"><br><br>
<img src="${emp.getPhoto()}"><br><br>
Profile Picture:<input type="file" name="img" accept="image/*"><br><br>
<input type="submit" value="Update"><br><br>
<h4 style="color:blue">${msg}</h4><br><br>

<a href="backtoempmain?empid=${empid}">Back</a><br><br>
</form>
</body>
</html>