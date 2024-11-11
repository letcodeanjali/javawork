<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Doctors</title>
</head>
<body><center>
<jsp:useBean id="DoctorDao" class="com.java.doctor.DoctorDaoImpl" />
<c:set var="doctorList" value="${DoctorDao.showDoctorDao()}" />
	<h1>Show Doctors</h1>
	<table border="1">
		<tr>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>Specialization</th>
			<th>Qualification</th>
			<th>Available Slot</th>
			<th>add doctor</th>
		</tr>
		<c:forEach var="doctor" items="${doctorList}">
		<tr>
			<td>${doctor.doctorid}</td>
			<td>${doctor.doctorname}</td>
			<td>${doctor.specialization}</td>
			<td>${doctor.qualification}</td>
			<td>${doctor.availableslot}</td>
			<td><a href=AddDoctor.jsp>add doctor</a> </td>
		</tr>
		</c:forEach>
	</table></center>
</body>
</html>