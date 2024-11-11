<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Hospital</title>
</head>
<body><center>
<form action="AddHospital.jsp" method="post">
    <h1>Add Hospital</h1>
    Hospital Name :
    <input type="text" name="hospitalname"/><br><br>
    City :
    <input type="text" name="city"/><br><br>
    Hospital Type :
    <input type="text" name="hospitaltype"/><br><br><br>
    Email :           
    <input type="text" name="email"/><br><br>
    Phone No :           
    <input type="text" name="phoneno"/><br><br>
    Status :           
    <input type="text" name="status" value="Active"/><br><br>
    <input type="submit" value="Add Hospital"/>
</form>

<c:if test="${not empty param.hospitalname && not empty param.city && not empty param.hospitaltype && not empty param.email && not empty param.phoneno && not empty param.status}">
    <jsp:useBean id="beanHospitalDao" class="com.java.doctor.DoctorDaoImpl" />
    <jsp:useBean id="hospital" class="com.java.doctor.Hospital" />
    <jsp:setProperty property="hospitalname" name="hospital" param="hospitalname"/>
    <jsp:setProperty property="city" name="hospital" param="city"/>
    <jsp:setProperty property="hospitaltype" name="hospital" param="hospitaltype"/>
    <jsp:setProperty property="email" name="hospital" param="email"/>
    <jsp:setProperty property="phoneno" name="hospital" param="phoneno"/>
    <jsp:setProperty property="status" name="hospital" param="status"/>
    <c:catch var="e">
        ${beanHospitalDao.addHospitalDao(hospital)}
    </c:catch>
    <c:if test="${e != null}">
        <c:out value="Error inserting record: ${e.message}" />
    </c:if>
    <jsp:forward page="ShowHospital.jsp" />
</c:if>
</center>
</body>
</html>