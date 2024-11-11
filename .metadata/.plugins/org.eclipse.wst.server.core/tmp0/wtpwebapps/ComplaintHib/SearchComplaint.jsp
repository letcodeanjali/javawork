<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Complaint</title>
</head>
<body>
<center>
<form action="SearchComplaint.jsp"><br>
Complaint Id:
<input type="text" name="complaintid" /><br><br>
<input type="submit" value="Search Complaint"/>
</form>

<c:if test="${param.complaintid!=null }">
    <jsp:useBean id="beanComplaintDao" class="com.java.ComplaintHib.ComplaintDaoImpl" />
    <jsp:useBean id="complaints" class="com.java.ComplaintHib.Complaint" />
  
    <c:set var="complaint" value="${beanComplaintDao.searchcomplaintDao(param.complaintid)}" />
    <c:if test="${complaint != null}"> <br><br>
        <table border="1">
            <tr>
                <th>Complaint Id</th>
                <th>Complaint Type</th>
                <th>Compl_Description</th>
                <th>Complaint Date</th>
                <th>Severity</th>
                <th>Status</th>
            </tr>
            <tr>
                <td>${complaint.complaintid}</td>
                <td>${complaint.complainttype}</td>
                <td>${complaint.cdescription}</td>
                <td>${complaint.complaintdate}</td>
                <td>${complaint.severity}</td>
                <td>${complaint.status}</td>
            </tr>
        </table>
       
    </c:if>
    <c:if test="${complaint == null}">
        <h2>Complaint not found</h2>
    </c:if>
</c:if><br><br><br>
</body>
</html>