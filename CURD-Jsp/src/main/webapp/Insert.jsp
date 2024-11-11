<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.io.*" %>
<%
    if(request.getParameter("submit") != null) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO Victims (FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setDate(3, java.sql.Date.valueOf(dateOfBirth));
            stmt.setString(4, gender);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, address);
            stmt.executeUpdate();
            out.println("Victim added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<html>
<head><title>Add Victim</title></head>
<body>
    <h2>Add Victim</h2>
    <form action="create_victim.jsp" method="post">
        First Name: <input type="text" name="firstName" required /><br />
        Last Name: <input type="text" name="lastName" required /><br />
        Date of Birth: <input type="date" name="dateOfBirth" required /><br />
        Gender: 
        <select name="gender">
            <option value="Female">Female</option>
            <option value="Male">Male</option>
            <option value="Other">Other</option>
        </select><br />
        Phone Number: <input type="text" name="phoneNumber" required /><br />
        Address: <input type="text" name="address" required /><br />
        <input type="submit" name="submit" value="Add Victim" />
    </form>
</body>
</html>