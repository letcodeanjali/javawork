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

<jsp:useBean id="beanComplaintDao" class="com.java.ComplaintHib.ComplaintDaoImpl" />
<c:set var="complaintList" value="${beanComplaintDao.showcomplaintDao()}" />
	<table border="3" align="center">
    <tr>
        <th>ComplaintId</th>
        <th>Complaint Type</th>
        <th>Description</th>
        <th>ComplaintDate</th>
        <th>Severity</th>
        <th>Status</th>
        <th>Update</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="complaints" items="${complaintList}">
        <tr>
            <td><c:out value="${complaints.complaintid}" /> </td>
            <td><c:out value="${complaints.complainttype}" /> </td>
            <td><c:out value="${complaints.cdescription}"/></td>
            <td><c:out value="${complaints.complaintdate}"/></td>
            <td><c:out value="${complaints.severity}"/></td>
            <td><c:out value="${complaints.status}"/></td>
            <td><a href=UpdateComplaint.jsp?complaintid=${complaints.complaintid}>Update</a> </td>
            <td><a href=DeleteComplaint.jsp?complaintid=${complaints.complaintid}>Delete</a> </td>
            
        </tr> 
    </c:forEach>
</table>
	</table> <br/><br/>
	<center><a href="AddComplaint.jsp">Add Complaint</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	<a href="SearchComplaint.jsp"> Search Complaint</center>
</body>
</html>