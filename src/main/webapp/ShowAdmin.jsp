<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Admins</title>
</head>
<body><center>
<jsp:useBean id="AdminDao" class="com.java.doctor.DoctorDaoImpl" />
<c:set var="adminList" value="${AdminDao.showAdminDao()}" />
	<h1>Show Admins</h1>
	<table border="1">
		<tr>
			<th>Admin ID</th>
			<th>Hospital ID</th>
			<th>Username</th>
			<th>Passcode</th>
			<th>OTP</th>
			<th>OTP Purpose</th>
			<th>Status</th>
			
		</tr>
		<c:forEach var="admin" items="${adminList}">
		<tr>
			<td>${admin.adminid}</td>
			<td>${admin.hospitalid}</td>
			<td>${admin.username}</td>
			<td>${admin.passcode}</td>
			<td>${admin.otp}</td>
			<td>${admin.otppurpose}</td>
			<td>${admin.status}</td>
			
		</tr>
		</c:forEach>
	</table></center>
</body>
</html>