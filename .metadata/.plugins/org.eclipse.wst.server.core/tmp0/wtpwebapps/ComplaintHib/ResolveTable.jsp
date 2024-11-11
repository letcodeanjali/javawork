<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resolve Table</title>
</head>
<body><center>
<h1>Resolve Table</h1>
<table border="1">
    <tr>
        <th>Complaint ID</th>
        <th>Complaint Date</th>
        <th>Resolve Date</th>
        <th>Resolved By</th>
        <th>Comments</th>
    </tr>
    <%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
        
        String query = "SELECT * FROM Resolve";
        pstmt = conn.prepareStatement(query);
        
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            Date complaintDate = rs.getDate("complaintdate");
            Date resolveDate = rs.getDate("resolvedate");
            
            long diffInMillies = resolveDate.getTime() - complaintDate.getTime();
            long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
            
            String color = "";
            if (diffInDays > 7) {
                color = "style='color:red'";
            } else if (diffInDays > 5) {
                color = "style='color:pink'";
            } else if (diffInDays == 0) {
                color = "style='color:green'";
            }
            
            %>
            <tr <%= color %>>
                <td><%= rs.getInt("complaintid") %></td>
                <td><%= rs.getDate("complaintdate") %></td>
                <td><%= rs.getDate("resolvedate") %></td>
                <td><%= rs.getString("resolvedby") %></td>
                <td><%= rs.getString("comments") %></td>
            </tr>
            <%
        }
    } catch (SQLException e) {
        out.println("Error retrieving data from Resolve table: " + e.getMessage());
    } finally {
        if (rs!= null) {
            rs.close();
        }
        if (pstmt!= null) {
            pstmt.close();
        }
        if (conn!= null) {
            conn.close();
        } 
    }
    %>
</table></center>
</body>
</html>