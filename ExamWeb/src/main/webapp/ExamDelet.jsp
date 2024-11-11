<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="EmployDelete.jsp">
		<center>
			Employ No : 
			<input type="number" name="empno" /> <br/><br/>
			<input type="submit" value="Delete" /> <br/><br/>
		</center>
	</form>
	<c:if test="${param.empno!=null}">
		<sql:setDataSource var="conn"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/sonixpractice"
		user="root"
		password="root"
	 	/>
	 	<sql:update var="employDelete" dataSource="${conn}">
	 		Delete from Employ where empno = ?
	 		<sql:param value="${param.empno}" />
	 	</sql:update>
	 	<c:out value="*** Record Deleted ***" />
	</c:if>
</body>
</html>
