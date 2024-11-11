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

<form method="get" action="ExamSearch.jsp">
	<center>
		Agent No:
		<input type="number" name="agentId" /><Br></br>
		<input type="submit" value="SEARCH" /><br></hr>
	</center>
</form>

<br><br>
<c:if test="${param.agentId!=null}">
	<c:set var="agentId" value="${param.agentId}"/>
<sql:setDataSource var="conn" 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/exam" 
	user="root" password="Anjali@123" />
<sql:query var="examQuery" dataSource="${conn}">
select * from agent where agentId=?
<sql:param value="${agentId}"></sql:param>
</sql:query>
<c:set var="flag" value="0"/>

<table border="3" margin="1" align="center">
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
<c:set var="flag" value="1"/>
</c:forEach>
<c:if test="${flag==0}">
<c:out  value="******Record not Found******" />
</c:if>	
</table>
</c:if>
</body>
</html>