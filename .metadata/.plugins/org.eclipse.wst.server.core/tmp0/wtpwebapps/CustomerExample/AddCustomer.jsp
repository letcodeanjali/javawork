<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
    <form method="post" action="AddCustomer.jsp">
        <center>
            Customer Name:
            <input type="text" name="custName" /> <br/><br/>
            Customer User Name:
            <input type="text" name="custUserName" /> <br/><br/>
            Customer Email:
            <input type="email" name="custEmail" /> <br/><br/>
            Customer Phone No:
            <input type="text" name="custPhoneNo" /> <br/><br/>
            <input type="submit" value="Add Customer" />
        </center>
    </form>
    <c:if test="${param.custName != null && param.custUserName != null && 
        param.custEmail != null && param.custPhoneNo != null}">
        <jsp:useBean id="beanCustomerDao" class="com.java.customer.CustomerDaoImpl" />
        <jsp:useBean id="beanCustomer" class="com.java.customer.Customer" />
        
        <jsp:setProperty property="custName" name="beanCustomer" value="${param.custName}" />
        <jsp:setProperty property="custUserName" name="beanCustomer" value="${param.custUserName}" />
        <jsp:setProperty property="custEmail" name="beanCustomer" value="${param.custEmail}" />
        <jsp:setProperty property="custPhoneNo" name="beanCustomer" value="${param.custPhoneNo}" />
        
        <c:out value="${beanCustomerDao.addCustomer(beanCustomer)}" />
    </c:if>
</body>
</html>
