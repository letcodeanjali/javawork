<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%
    List<String[]> victims = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String query = "SELECT * FROM Victims";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            victims.add(new String[] {
                rs.getString("VictimID"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("DateOfBirth"),
                rs.getString("Gender"),
                rs.getString("PhoneNumber"),
                rs.getString("Address")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<html>
<head><title>View Victims</title></head>
<body>
    <h2>Victims List</h2>
    <table border="1">
        <tr>
            <th>Victim ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Phone Number</th>
            <th>Address</th>
        </tr>
        <%
            for (String[] victim : victims) {
        %>
        <tr>
            <td><%= victim[0] %></td>
            <td><%= victim[1] %></td>
            <td><%= victim[2] %></td>
            <td><%= victim[3] %></td>
            <td><%= victim[4] %></td>
            <td><%= victim[5] %></td>
            <td><%= victim[6] %></td>
            <td><a href="update_victim.jsp?victimID=<%= victim[0] %>">Edit</a></td>
            <td><a href="delete_victim.jsp?victimID=<%= victim[0] %>">Delete</a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>