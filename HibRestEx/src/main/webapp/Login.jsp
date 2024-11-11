
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
<form method="post" action="Login.jsp">
		<center>
			User Name : 
			<input type="text" name="userName" /> <br/><br/>
			Passcode : 
			<input type="password" name="passCode" /><br/><br/>
			<input type="submit" value="Add User" />
		</center>
	</form>
	<c:if test="${param.userName !=null && param.passCode !=null}">
		<jsp:useBean id="beanDao" class="java.com.hib.EmployDaoImpl" />
		<jsp:useBean id="beanUsers" class="java.com.hib.Users" />
		<jsp:setProperty property="*" name="beanUsers"/>
		<c:set var="count" value="${beanDao.authenticate(beanUsers)}" />
		<c:if test="${count==1}">
			<jsp:forward page="EmployShow.jsp"/>
		</c:if>
	</c:if>
</body>
</html>
