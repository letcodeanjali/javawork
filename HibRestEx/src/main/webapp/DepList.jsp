
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanDao" class="java.com.hib.EmployDaoImpl" />
<c:set var="deptList" value="${beanDao.showDepartments()}" />
Departments : 
<select name="dept">
	<c:forEach var="d" items="${deptList}">		
		<option value=<c:out value="${d}"/> > <c:out value="${d}" /> </option>
		 </c:forEach>
</select>
</body>
</html>
