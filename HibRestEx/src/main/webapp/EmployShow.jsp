
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
	<table border="3" align="center">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
	<jsp:useBean id="beanDao" class="java.com.hib.EmployDaoImpl" />
		<c:set var="employList" value="${beanDao.showEmployDao()}" />
	<c:forEach var="employ" items="${employList}">
		<tr>
			<td><c:out value="${employ.empno}" /> </td>
			<td><c:out value="${employ.name}" /> </td>
			<td><c:out value="${employ.gender}" /> </td>
			<td><c:out value="${employ.dept}" /> </td>
			<td><c:out value="${employ.desig}" /> </td>
			<td><c:out value="${employ.basic}" /> </td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
