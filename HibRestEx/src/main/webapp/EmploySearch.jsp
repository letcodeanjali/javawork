
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
	<form method="get" action="EmploySearch.jsp">
		<center>
			Employ No : 
			<input type="number" name="empno" /> <br/><br/>
			<input type="submit" value="Search" />
		</center>
	</form>
	<c:if test="${param.empno!=null}">
		<jsp:useBean id="beanDao" class="java.com.hib.EmployDaoImpl" />
		<c:set var="employ" value="${beanDao.searchEmployDao(param.empno)}" />
		<c:if test="${employ != null}">
			Employ No : <c:out value="${employ.empno}" /> <br/>
			Employ Name : <c:out value="${employ.name}" /> <br/>
			Gender : <c:out value="${employ.gender}" /> <br/>
			Department : <c:out value="${employ.dept}" /> <br/>
			Designation: <c:out value="${employ.desig}" /> <br/>
			Basic : <c:out value="${employ.basic}" />
		</c:if>
	</c:if>
</body>
</html>
