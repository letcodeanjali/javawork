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

<form method="get" action="ExamUpdate.jsp">
	<center>
		Agent No:
		<input type="number" name="agentId" /><Br></br>
		Name:
		<input type="text" name="name" /><Br></br>
		City:
		<input type="text" name="city" /><Br></br>
		Gender:
		<select name="gender">
			<option>select</option>
			<option value="MALE">Male</option>
			<option value="FEMALE">Female</option>
		</select><Br></br>
		MaritalStatus:
		<select name="maritalStatus">
			<option>select</option>
			<option value="0">Unmarried</option>
			<option value="1">Married</option>
		</select><Br></br>
		Premium:
		<input type="number" name="premium" /><Br></br>
		<input type="submit" value="UPDATE" /><br></hr>
	</center>
</form>

<c:if test="${param.agentId!=null && param.premium!=null}">
<sql:setDataSource var="conn" 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/exam" 
	user="root" password="Anjali@123" />
	<sql:update var="examQuery" dataSource="${conn}">
update agent set name=?,city=?,gender=?,maritalStatus=?,premium=? where agentId=?

<sql:param value="${param.name}"></sql:param>
<sql:param value="${param.city}"></sql:param>
<sql:param value="${param.gender}"></sql:param>
<sql:param value="${param.maritalStatus}"></sql:param>
<sql:param value="${param.premium}"></sql:param>
<sql:param value="${param.agentId}"></sql:param>
</sql:update>
<c:out value="*******Record Updated******"/>
</c:if>

</body>
</html>