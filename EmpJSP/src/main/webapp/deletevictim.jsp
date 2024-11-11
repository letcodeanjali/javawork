<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Victim</title>
</head>
<body>
    <h2>Delete Victim</h2>
    <form method="post" action="deleteVictim.jsp">
        <center>
            Victim Id  : 
            <input type="number" name="VictimId" required/> <br/><br/>
            <input type="submit" value="Delete" />
        </center>
    </form>

    <%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String victimIdStr = request.getParameter("VictimId");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root", "Anjali@123");

            // Prepare SQL statement for deletion
            String sql = "DELETE FROM Victim WHERE VictimId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(victimIdStr));

            // Execute the delete statement
            int rowsAffected = pstmt.executeUpdate();

            // Check if deletion was successful
            if (rowsAffected > 0) {
                out.println("<p><b>Victim Record Deleted Successfully!</b></p>");
            } else {
                out.println("<p><b>No Victim Record Found for Deletion.</b></p>");
            }

            // Close resources
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            out.println("<p><b>Error deleting victim record: " + e.getMessage() + "</b></p>");
            e.printStackTrace();
        }
    }
    %>

</body>
</html>
