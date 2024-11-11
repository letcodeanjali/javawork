<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Appointment</title>
</head>
<body><center>
<form action="AddAppointment.jsp" method="post">
    <h1>Add Appointment</h1>
    Patient Name :
    <input type="text" name="patientName" /><br><br>
    
    Patient Email :
    <input type="text" name="patientEmail"/><br><br>
    
    Patient Mobile :
    <input type="text" name="patientMobile"/><br><br>
    
    Doctor Name :
    <input type="text" name="doctorName"/><br><br>
    
    Appointment Date :
    <input type="date" name="appointmentDate"/><br><br>
    
    Appointment Time :
    <input type="text" name="appointTime" pattern="[0-9]{2}:[0-9]{2}" required/><br><br>
    
    Patient Disease :
    <input type="text" name="patientDisease"/><br><br>
    
    <input type="submit" value="Add Appointment"/>
    
    <c:if test="${not empty param.patientName}">
        <jsp:useBean id="beanAppointmentDao" class="com.java.doctor.AptDaoImpl" />
        <jsp:useBean id="appointment" class="com.java.doctor.Appointment" />
        
        <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(request.getParameter("appointmentDate"));
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        appointment.setAppointmentDate(sqlDate);
        
        String appointTime = request.getParameter("appointTime");
        String[] timeParts = appointTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        
        if(hour >= 6 && hour <= 22) {
            appointment.setAppointTime(appointTime);
        } else {
            out.println("Invalid appointment time. Please enter a time between 06:00 and 22:00.");
        }
        
        appointment.setPatientName(request.getParameter("patientName"));
        appointment.setPatientEmail(request.getParameter("patientEmail"));
        appointment.setPatientMobile(request.getParameter("patientMobile"));
        appointment.setDoctorName(request.getParameter("doctorName"));
        appointment.setPatientDisease(request.getParameter("patientDisease"));
        
        boolean isAppointmentAvailable = beanAppointmentDao.isAppointmentAvailable(appointment);
        if(isAppointmentAvailable) {
            beanAppointmentDao.addAppointmentDao(appointment);
            out.println("Appointment added successfully.");
            %>
            <jsp:forward page="ShowAppointment.jsp" />
            <%
        } else {
            out.println("Appointment already booked for the same day and time.");
        }
        %>
    </c:if>
</form>
</center>
</body>
</html>