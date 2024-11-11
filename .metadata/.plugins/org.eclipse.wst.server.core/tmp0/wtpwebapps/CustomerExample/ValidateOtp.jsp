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
	<form method="get" action="ValidateOtp.jsp">
		<center>
			Customer User Name : 
			<input type="text" name="customerUserName" /> <br/><br/>
			Customer Otp : 
			<input type="text" name="customerOtp" /> <br/><br/>
			<input type="submit" value="Validate Otp" />
		</center>
	</form>
	<c:if test="${param.customerUserName !=null && param.customerOtp !=null}">
		<jsp:useBean id="beanCustomerDao" class="com.java.customer.CustomerDaoImpl" />
		<c:set var="count" value="${beanCustomerDao.validateOtp(param.customerUserName,param.customerOtp)}" />
		<c:if test="${count==1}">
			<jsp:forward page="NewPasswordSet.jsp" />
		</c:if>
		<c:if test="${count==0}">
			<c:out value="Invalid Credentials..." />
		</c:if>
	</c:if>
</body>
</html>