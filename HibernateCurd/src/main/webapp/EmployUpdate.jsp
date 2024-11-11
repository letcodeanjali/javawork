<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanEmployDao" class="com.java.Curd.EmployDaoImpl" />
	<c:set var="empno" value="${param.empno}" />
	<c:set var="employ" value="${beanEmployDao.searchEmployDao(empno)}" />
	<form method="get" action="EmployUpdate.jsp">
		<center>
			Employ No : 
			<input type="number" name="empno" value=${employ.empno} >
			<br/><br/>
			Employ Name : 
			<input type="text" name="name" value=${employ.name} > 
			<br/><Br/>
			Gender : 
			<input type="text" name="gender" value=${employ.gender} >
			<br/><br/>
			Department : 
			<input type="text" name="dept" value=${employ.dept} > 
			<br/><br/>
			Designation : 
			<input type="text" name="desig" value=${employ.desig} >
			<br/><br/>
			Basic : 
			<input type="number" name="basic" value=${employ.basic} >
			<input type="submit" value="Update" />
 		</center>
	</form>
	<c:if test="${param.empno!=null && param.basic!=null}">
	<jsp:useBean id="employUpdated" class="com.java.Curd.Employ" />
	<jsp:setProperty property="*" name="employUpdated"/>
	<c:out value="${beanEmployDao.updateEmployDao(employUpdated)}" />
	<jsp:forward page="EmployShow.jsp" />
	</c:if>

</body>
</html>