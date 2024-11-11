<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="beanComplaintDao" class="com.java.ComplaintHib.ComplaintDaoImpl" />
    <c:set var="complaintid" value="${param.complaintid}" />
    
    <c:if test="${not empty complaintid}">
        <c:out value="${beanComplaintDao.deletecomplaintDao(complaintid)}" />
    </c:if>
    
    <jsp:forward page="ShowComplaint.jsp" />
</body>
</html>