<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Doctor</title>
</head>
<body><center>
<form action="AddDoctor.jsp">
<h1>Add Doctor</h1>
<form action="AddDoctorServlet" method="post">
    Doctor ID :
            <input type="text" name="doctorid" /><br><br>
       
            Doctor Name :
           <input type="text" name="doctorname"/><br><br>
           
           Specialization :
           <input type="text" name="specialization"/><br><br>
           
            Qualification :
            <input type="text" name="qualification"/><br><br><br>
            
            Available Slot :           
                <select name="availableslot">
                    <option value="General">General</option>
                    <option value="Morning">Morning</option>
                    <option value="Evening">Evening</option>
                    <option value="Weekends">Weekends</option>
                    <option value="CallOn">Call On</option>
                </select><br><br>
           
    <input type="submit" value="Add Doctor"/>
    
    <c:if test="${param.doctorid!=null }">
    <jsp:useBean id="beanDoctorDao" class="com.java.doctor.DoctorDaoImpl" />
    <jsp:useBean id="doctor" class="com.java.doctor.Doctor" />
    <jsp:setProperty property="doctorid" name="doctor" param="doctorid"/>
    <jsp:setProperty property="doctorname" name="doctor" param="doctorname"/>
    <jsp:setProperty property="specialization" name="doctor" param="specialization"/>
    <jsp:setProperty property="qualification" name="doctor" param="qualification"/>
    <jsp:setProperty property="availableslot" name="doctor" param="availableslot"/>
    <c:out value="${beanDoctorDao.addDoctorDao(doctor)}" />
    <jsp:forward page="ShowDoctor.jsp" />
</c:if>
</form>
</center>
</body>
</html>