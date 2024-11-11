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
<c:forEach var="exam" items="${examQuery.rows}">
AgentId:
<c:out value="${exam.agentId}"/><br></br>
Name:
<c:out value="${exam.name}"/><br></br>
City:
<c:out value="${exam.city }"/><br></br>
Gender:
<c:out value="${exam.gender }"/><br></br>
MaritalStatus:
<c:out value="${exam.maritalStatus }"/><br></br>
Premium:
<c:out value="${exam.premium}"/><br></br>

</c:forEach>

</body>
</html>