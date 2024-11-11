<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Admin</title>
</head>
<body><center>
<form action="AddAdmin.jsp" method="post">
    <h1>Add Admin</h1>
    Hospital ID :
    <input type="text" name="hospitalid"/><br><br>
    Username :
    <input type="text" name="username"/><br><br>
    Passcode :
    <input type="text" name="passcode"/><br><br>
    OTP :
    <input type="text" name="otp" value="${param.otp}"/><br><br>
    OTP Purpose :
    <input type="text" name="otppurpose"/><br><br>
    Status :
    <input type="text" name="status" value="Active"/><br><br>
    <input type="submit" value="Add Admin"/>
</form>

<c:if test="${not empty param.hospitalid && not empty param.username && not empty param.passcode && not empty param.otp && not empty param.otppurpose && not empty param.status}">
    <jsp:useBean id="beanAdminDao" class="com.java.doctor.DoctorDaoImpl" />
    <jsp:useBean id="admin" class="com.java.doctor.Admin" />
    <jsp:setProperty property="hospitalid" name="admin" param="hospitalid"/>
    <jsp:setProperty property="username" name="admin" param="username"/>
    <jsp:setProperty property="passcode" name="admin" param="passcode"/>
    <jsp:setProperty property="otp" name="admin" param="otp"/>
    <jsp:setProperty property="otppurpose" name="admin" param="otppurpose"/>
    <jsp:setProperty property="status" name="admin" param="status"/>
    
    <jsp:forward page="ShowAdmin.jsp" />
</c:if>
</center>
</body>
</html>