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
<title>Update Complaint</title>
</head>
<body>
<jsp:useBean id="Complaint" class="com.java.ComplaintHib.ComplaintDaoImpl" />
	<c:set var="complaintid" value="${param.complaintid}" />
	<c:set var="complaints" value="${Complaint.searchcomplaintDao(complaintid)}" />
	<form method="get" action="UpdateComplaint.jsp">
<center>

        Complaint ID :
        <input type="number" name="complaintid" value="${complaints.complaintid}"readonly /><br><br>
        Complaint Type :
        <input type="text" name="complainttype" value="${complaints.complainttype}"readonly /><br><br>
        Description:
        <input type="text" name="cdescription" value="${complaints.cdescription}"readonly /><br><br>
        ComplaintDate :
        <input type="Date" name="complaintdate" value="${complaints.complaintdate}"readonly /><br><br>
        Severity :
        <input type="text" name="severity" value="${complaints.severity}" readonly/><br><br>
        
        Status :
        <Select name="status" value="${complaints.status}" >
        <option >pending</option>
        <option >resolved</option></Select ><br><br><br>
        <input type="hidden" name="complaintid" value="${complaints.complaintid}" />
        <input type="submit" value="Update Complaint"/>
<c:if test="${param.complaintid!=null }">
    <jsp:useBean id="beanComplaintDao" class="com.java.ComplaintHib.ComplaintDaoImpl" />
    <jsp:useBean id="complaints" class="com.java.ComplaintHib.Complaint" />  
    <%
    String complaintDate = request.getParameter("complaintdate");
    if (complaintDate != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(complaintDate);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        complaints.setComplaintdate(sqlDate);
    }
    %>
    <jsp:setProperty property="complaintid" name="complaints" param="complaintid"/>
    <jsp:setProperty property="complainttype" name="complaints" param="complainttype"/>
    <jsp:setProperty property="cdescription" name="complaints" param="cdescription"/>
    <jsp:setProperty property="severity" name="complaints" param="severity"/>
    <jsp:setProperty property="status" name="complaints" param="status"/>
    
   
<c:if test="${param.status eq 'resolved'}">
    <%
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
        
        String query = "INSERT INTO Resolve (complaintid, complaintdate, resolvedate, resolvedby, comments) VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, complaints.getComplaintid());
        pstmt.setDate(2, complaints.getComplaintdate());
        pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime())); 
        pstmt.setString(4, "Sushma"); 
        pstmt.setString(5, "comments"); 
        
        pstmt.executeUpdate();
    } catch (SQLException e) {
        out.println("Error inserting into Resolve table: " + e.getMessage());
    } finally {
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        } 
    }
    %>
     <c:out value="${beanComplaintDao.updatecomplaintDao(complaints)}" />
</c:if><center><br><br><br><br>
<a href="ShowComplaint.jsp">Back</a></center>
    
</c:if>
</form>
</body>
</html>