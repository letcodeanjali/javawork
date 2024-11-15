<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.java.Issue.ComplaintDaoImpl" %>
<%@ page import="com.java.Issue.Complaint" %>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Complaint</title>
</head>
<body>
<div align="center">
    <h2>Add New Complaint</h2>
    <form action="AddComplaint.jsp" method="post">
        <label for="complaintType">Complaint Type:</label>
        <input type="text" id="complaintType" name="complaintType" required><br>

        <label for="desc">Description:</label>
        <textarea id="desc" name="desc" required></textarea><br>

        <label for="severity">Severity:</label>
        <input type="text" id="severity" name="severity" required><br>

        <input type="submit" value="Submit">
    </form>
    
    <c:if test="${param.complaintType != null}">
        <!-- Create a new Complaint object -->
        <jsp:useBean id="beanComplaint" class="com.java.support.Complaint" scope="request">
            <jsp:setProperty name="beanComplaint" property="complaintType" param="complaintType" />
            <jsp:setProperty name="beanComplaint" property="desc" param="desc" />
            <jsp:setProperty name="beanComplaint" property="severity" param="severity" />
            <jsp:setProperty name="beanComplaint" property="status" value="Pending" />
        </jsp:useBean>

        <!-- Set the Complaint ID and Date -->
        <%
            String complaintID = "C" + String.format("%03d", new java.util.Random().nextInt(1000));
            request.setAttribute("complaintID", complaintID);
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        %>
        <jsp:setProperty name="beanComplaint" property="complaintID" value="${complaintID}" />
        <jsp:setProperty name="beanComplaint" property="dateOfIssue" value="<%= currentTimestamp %>" />

        <!-- Save the complaint -->
        <jsp:useBean id="beanComplaintDao" class="com.java.Issue.ComplaintDaoImpl" />
        <c:out value="${beanComplaintDao.addComplaint(beanComplaint)}" />

        <!-- Forward to ShowComplaint.jsp -->
        <jsp:forward page="ShowComplaint.jsp" />
    </c:if>
</div>
</body>
</html>
