<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanAppointmentDao" class="com.java.doctor.AptDaoImpl" />
	<c:set var="appointmentId" value="${param.appointmentId}" />
	<c:out value="${beanAppointmentDao.deleteAppointmentDao(appointmentId)}" />
	<jsp:forward page="ShowAppointment.jsp" />
</body>
</html>