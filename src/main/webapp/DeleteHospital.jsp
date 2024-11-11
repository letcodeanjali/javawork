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
	<jsp:useBean id="beanHospitalDao" class="com.java.doctor.DoctorDaoImpl" />
	<c:set var="hospitalid" value="${param.empno}" />
	<c:out value="${beanHospitalDao.deleteHospitalDao(hospitalid)}" />
	<jsp:forward page="ShowHospital.jsp" />
</body>
</html>