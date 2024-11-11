<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Hospitals</title>
</head>
<body><center>
<jsp:useBean id="HospitalDao" class="com.java.doctor.DoctorDaoImpl" />
<c:set var="hospitalList" value="${HospitalDao.showHospitalDao()}" />
	<h1>Show Hospitals</h1>
	<table border="1">
		<tr>
			<th>Hospital ID</th>
			<th>Hospital Name</th>
			<th>City</th>
			<th>Hospital Type</th>
			<th>Email</th>
			<th>Phone No</th>
			<th>Status</th>
			<th>add hospital</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="hospital" items="${hospitalList}">
		<tr>
			<td>${hospital.hospitalid}</td>
			<td>${hospital.hospitalname}</td>
			<td>${hospital.city}</td>
			<td>${hospital.hospitaltype}</td>
			<td>${hospital.email}</td>
			<td>${hospital.phoneno}</td>
			<td>${hospital.status}</td>
			<td><a href=AddHospital.jsp>add hospital</a> </td>
			<td><a href=DeleteHospital.jsp>Delete</a> </td>
		</tr>
		</c:forEach>
	</table></center>
</body>
</html>