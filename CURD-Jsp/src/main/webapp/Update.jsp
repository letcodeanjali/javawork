<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    String victimID = request.getParameter("victimID");
    String firstName = "";
    String lastName = "";
    String dateOfBirth = "";
    String gender = "";
    String phoneNumber = "";
    String address = "";

    if(request.getParameter("submit") != null) {
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        dateOfBirth = request.getParameter("dateOfBirth");
        gender = request.getParameter("gender");
        phoneNumber = request.getParameter("phoneNumber");
        address = request.getParameter("address");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE Victims SET FirstName=?, LastName=?, DateOfBirth=?, Gender=?, PhoneNumber=?, Address=? WHERE VictimID=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setDate(3, java.sql.Date.valueOf(dateOfBirth));
            stmt.setString(4, gender);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, address);
            stmt.setInt(7, Integer.parseInt(victimID));
            stmt.executeUpdate();
            out.println("Victim updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM Victims WHERE VictimID=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(victimID));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                dateOfBirth = rs.getString("DateOfBirth");
                gender = rs.getString("Gender");
                phoneNumber = rs.getString("PhoneNumber");
                address = rs.getString("Address");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<html>
<head><title>Edit Victim</title></head>
<body>
    <h2>Edit Victim</h2>
    <form action="update_victim.jsp" method="post">
        <input type="hidden" name="victimID" value="<%= victimID %>" />
        First Name: <input type="text" name="firstName" value="<%= firstName %>" required /><br />
        Last Name: <input type="text" name="lastName" value="<%= lastName %>" required /><br />
        Date of Birth: <input type="date" name="dateOfBirth" value="<%= dateOfBirth %>" required /><br />
        Gender: 
        <select name="gender">
            <option value="Female" <%= gender.equals("Female") ? "selected" : "" %>>Female</option>
            <option value="Male" <%= gender.equals("Male") ? "selected" : "" %>>Male</option>
            <option value="Other" <%= gender.equals("Other") ? "selected" : "" %>>Other</option>
        </select><br />
        Phone Number: <input type="text" name="phoneNumber" value="<%= phoneNumber %>" required /><br />
        Address: <input type="text" name="address" value="<%= address %>" required /><br />
        <input type="submit" name="submit" value="Update Victim" />
    </form>
</body>
</html>