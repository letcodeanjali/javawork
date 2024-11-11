<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:useBean id="beanVictimDao" class="com.java.Hibemp.VictimDAOimpl" />
	<c:set var="empno" value="${param.empno}" />
	<c:out value="${beanEmployDao.deleteEmployDao(empno)}" />
	<jsp:forward page="DeleteV.jsp" />


</body>
</html>