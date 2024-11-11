<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Appointments</title>
</head>
<body>
<jsp:useBean id="beanAppointmentDao" class="com.java.doctor.AptDaoImpl" />
<c:set var="appointmentList" value="${beanAppointmentDao.showAppointmentDao()}" />
<center>
<h1>Show Appointments</h1>
<table border="1">
    <tr>
        <th>Appointment ID</th>
        <th>Patient Name</th>
        <th>Patient Email</th>
        <th>Patient Mobile</th>
        <th>Doctor Name</th>
        <th>Appointment Date</th>
        <th>Appointment Time</th>
        <th>Patient Disease</th>
        <th>Add</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="appointment" items="${appointmentList}">
    <tr>
        <td>${appointment.appointmentId}</td>
        <td>${appointment.patientName}</td>
        <td>${appointment.patientEmail}</td>
        <td>${appointment.patientMobile}</td>
        <td>${appointment.doctorName}</td>
        <td>${appointment.appointmentDate}</td>
        <td>${appointment.appointTime}</td>
        <td>${appointment.patientDisease}</td>
        <td><a href="AddAppointment.jsp">Add</a> </td>
        <td><a href="DeleteAppointment.jsp?appointmentId=${appointment.appointmentId}">Delete</a> </td>
    </tr>
    </c:forEach>
</table>
</center>
</body>
</html>