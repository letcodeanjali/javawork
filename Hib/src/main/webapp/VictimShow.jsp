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

<jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
<c:set var="victimList" value="${beanVictimDao.showVictimDao()}" />
	<table border="3" align="center">
		<tr>
			<th>Victim Id</th>
			<th>FirstNmae</th>
			<th>LastNmae</th>
			<th>DateOfBirth</th>
			<th>Gender</th>
			<th>PhoneNumber</th>
			<th>address</th>
			<th>
				Update
			</th>
			<th>
				Delete
			</th>
		</tr>
		<c:forEach var="victims" items="${victimList}">
	<tr>
		<td><c:out value="${victims.victimid}" /> </td>
		<td><c:out value="${victims.firstname}" /> </td>
		<td><c:out value="${victims.lastname }"/><td>
		<td><c:out value="${victims.dateofbirth }"/><td>
		<td><c:out value="${victims.gender }"/><td>
		<td><c:out value="${victims.phonenumber }"/><td>
		<td><c:out value="${victims.address}"/><td>
		<td><a href=UpdateVictim.jsp?victimid=${victims.victimid}>Update</a> </td>
		<td><a href=DeleteVictim.jsp?victimid=${victims.victimid}>Delete</a> </td>
	</tr>
	</c:forEach>
	</table> <br/><br/>
	<a href="AddVictim.jsp">Add Victim</a>
</body>
</html>