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
	<jsp:useBean id="beanEmployDao" class="com.java.Curd.EmployDaoImpl" />
	<c:set var="empno" value="${param.empno}" />
	<c:out value="${beanEmployDao.deleteEmployDao(empno)}" />
	<jsp:forward page="EmployShow.jsp" />
</body>
</html>