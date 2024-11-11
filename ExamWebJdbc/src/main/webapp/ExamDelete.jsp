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


<form method="get" action="ExamDelete.jsp">
	<center>
		Agent No:
		<input type="number" name="agentId" /><Br></br>
		<input type="submit" value="DELETE" /><br></hr>
	</center>
</form>

<br><br>
<c:if test="${param.agentId!=null}">
	<c:set var="agentId" value="${param.agentId}"/>
<sql:setDataSource var="conn" 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/exam" 
	user="root" password="Anjali@123" />
<sql:update var="examDelete" dataSource="${conn}">
delete from agent where agentId=?
<sql:param value="${param.agentId}"></sql:param>
</sql:update>
<c:out  value="******Record Deleted******" />
</c:if>	

</body>
</html>