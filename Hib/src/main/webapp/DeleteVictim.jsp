<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
	<c:set var="victimid" value="${param.victimid}" />
	<c:out value="${beanVictimDao.deleteVictimDao(victimid)}" />
	<jsp:forward page="VictimShow.jsp" />
</body>
</html>