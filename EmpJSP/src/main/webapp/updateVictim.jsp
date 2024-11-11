<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Victim</title>
</head>
<body>
	<form method="get" action="updateVictim.jsp">
		<center>
			Victim Id (to update) : 
			<input type="number" name="VictimId" /> <br/><br/>
			First Name : 
			<input type="text" name="FirstName" /> <br/><br/>
			Last Name : 
			<input type="text" name="Lastname" /> <br/><br/>
			DOB :
			<input type="date" name="DateOfBirth" /> <br/><br/>
			Gender : 
			<select name="Gender">
				<option value="MALE">Male</option>
				<option value="FEMALE">FEMALE</option>
			</select> <br/><br/>
			Phone No:
			<input type="text" name="PhoneNumber" /> <br/><br/>
			Address :
			<input type="text" name="Address" /> <br/><br/>
			<input type="submit" value="Update" />
		</center>
	</form>
<%
	if (request.getParameter("VictimId") != null) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root", "Anjali@123");
		String cmd = "UPDATE Victim SET FirstName = ?, Lastname = ?, DateOfBirth = ?, Gender = ?, PhoneNumber = ?, Address = ? WHERE VictimId = ?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, request.getParameter("FirstName"));
		pst.setString(2, request.getParameter("Lastname"));
		pst.setDate(3, java.sql.Date.valueOf(request.getParameter("DateOfBirth")));
		pst.setString(4, request.getParameter("Gender"));
		pst.setString(5, request.getParameter("PhoneNumber"));
		pst.setString(6, request.getParameter("Address"));
		pst.setInt(7, Integer.parseInt(request.getParameter("VictimId")));
		int rowsAffected = pst.executeUpdate();
		if (rowsAffected > 0) {
			out.println("*** Victim Record Updated ***");
		} else {
			out.println("*** No Victim Record Found ***");
		}
	}
%>
</body>
</html>
