<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agent</title>
</head>
<body>

<sql:setDataSource var="conn" 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/exam" 
	user="root" password="Anjali@123" />
<sql:query var="examQuery" dataSource="${conn}">
select * from agent
</sql:query>

<table border="3" align="center">
<tr>
	<th>AgentId</th>
	<th>Name</th>
	<th>City</th>
	<th>Gender</th>
	<th>MaritalStatus</th>
	<th>Premium</th>
</tr>
<c:forEach var="exam" items="${examQuery.rows}">
<tr>
	<td><c:out value="${exam.agentId}"/></td>
	<td><c:out value="${exam.name}"/></td>
	<td><c:out value="${exam.city}"/></td>
	<td><c:out value="${exam.gender}"/></td>
	<td><c:out value="${exam.maritalStatus}"/></td>
	<td><c:out value="${exam.premium}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>