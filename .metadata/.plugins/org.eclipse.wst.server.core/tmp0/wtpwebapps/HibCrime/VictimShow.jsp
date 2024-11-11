<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Victim</title>
</head>
<body>

<jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
	<c:set var="victimList" value="${beanVictimDao.showVictimDao()}" />
	 <table border="3" align="center">
            <tr>
                <th>Victim Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Phone Number</th>
                <th>Address</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="victim" items="${victimList}">
	<tr>
		<td><c:out value="${victim.victimId}" /> </td>
		<td><c:out value="${victim.firstName}" /> </td>
		<td><c:out value="${victim.lastName}" /> </td>
		<td><c:out value="${victim.dateOfBirth}" /> </td>
		<td><c:out value="${victim.gender}" /> </td>
		<td><c:out value="${victim.phoneNumber}" /> </td>
		<td><c:out value="${victim.address}" /> </td>
		<td><a href=VictimUpdate.jsp?victimId=${victim.victimId}>Update</a> </td>
		<td><a href=VictimDelete.jsp?victimId=${victim.victimId}>Delete</a> </td>
	</tr>
	</c:forEach>
	</table> <br/><br/>
	<a href="AddVictim.jsp">Add Victim</a>

</body>
</html>