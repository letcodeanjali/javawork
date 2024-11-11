<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Victims</title>
</head>
<body>
	<center>
		<h2>Victim Records</h2>
		<table border="1">
			<tr>
				<th>VictimId</th>
				<th>FirstName</th>
				<th>Lastname</th>
				<th>DateOfBirth</th>
				<th>Gender</th>
				<th>PhoneNumber</th>
				<th>Address</th>
			</tr>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root", "Anjali@123");
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM Victim");
	while (rs.next()) {
%>
			<tr>
				<td><%= rs.getInt("VictimId") %></td>
				<td><%= rs.getString("FirstName") %></td>
				<td><%= rs.getString("Lastname") %></td>
				<td><%= rs.getDate("DateOfBirth") %></td>
				<td><%= rs.getString("Gender") %></td>
				<td><%= rs.getString("PhoneNumber") %></td>
				<td><%= rs.getString("Address") %></td>
			</tr>
<%
	}
%>
		</table>
	</center>
</body>
</html>
