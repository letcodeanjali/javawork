<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="AddComplaint.jsp">

complaint Type :
<input type="text" name="complainttype" /><br><br>
Complaint Description:
<input type="text" name="cdescription"/><br><br>
ComplaintDate :
<input type="Date" name="complaintdate"><br><br>
Severity :
<input type="text" name="severity" /><br><br>
Status :
<Select name="status">
<option value="pending" >Pending</option>
<option value="resolved" >resolved</option>
</Select><br><br><br>
 <input type="submit" value="Insert Complaint"/>
<c:if test="${param.complainttype!=null }">
    <jsp:useBean id="beanComplaintDao" class="com.java.ComplaintHib.ComplaintDaoImpl" />
    <jsp:useBean id="complaints" class="com.java.ComplaintHib.Complaint" />   
    <%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date utilDate = sdf.parse(request.getParameter("complaintdate"));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    complaints.setComplaintdate(sqlDate);
    %>
    <jsp:setProperty property="complaintid" name="complaints" param="complaintid"/>
    <jsp:setProperty property="complainttype" name="complaints" param="complainttype"/>
    <jsp:setProperty property="cdescription" name="complaints" param="cdescription"/>
    <jsp:setProperty property="severity" name="complaints" param="severity"/>
    <jsp:setProperty property="status" name="complaints" param="status"/>
    
    <c:out value="${beanComplaintDao.addcomplaintDao(complaints)}" />
    <jsp:forward page="ShowComplaint.jsp" />
    
    
</c:if>
</form>
</body>
</html>