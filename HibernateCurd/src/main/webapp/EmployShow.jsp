<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="beanEmployDao" class="com.java.Curd.EmployDaoImpl" />
	<c:set var="employList" value="${beanEmployDao.showEmployDao()}" />
	<table border="3" align="center">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
			<th>
				Update
			</th>
			<th>
				Delete
			</th>
		</tr>
	<c:forEach var="employ" items="${employList}">
	<tr>
		<td><c:out value="${employ.empno}" /> </td>
		<td><c:out value="${employ.name}" /> </td>
		<td><c:out value="${employ.gender}" /> </td>
		<td><c:out value="${employ.dept}" /> </td>
		<td><c:out value="${employ.desig}" /> </td>
		<td><c:out value="${employ.basic}" /> </td>
		<td><a href=EmployUpdate.jsp?empno=${employ.empno}>Update</a> </td>
		<td><a href=EmployDelete.jsp?empno=${employ.empno}>Delete</a> </td>
	</tr>
	</c:forEach>
	</table> <br/><br/>
	<a href="AddEmploy.jsp">Add Employ</a>

</body>
</html>