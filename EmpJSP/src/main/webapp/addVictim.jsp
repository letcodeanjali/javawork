<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Victim</title>
</head>
<body>
    <h2>Insert Victim Information</h2>
    <form method="post" action="addVictim.jsp">
        <center>
            Victim Id  : 
            <input type="number" name="VictimId" required/> <br/><br/>
            First Name : 
            <input type="text" name="FirstName" required/> <br/><Br/>
            Last Name : 
            <input type="text" name="LastName" required/> <br/><Br/>
            DOB :
            <input type="date" name="DateOfBirth" required/>
            Gender : 
            <select name="Gender">
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select> <br/><br/>
            Phone No:
            <input type="text" name="PhoneNumber" required/>
            Address :
            <input type="text" name="Address" required/>
            <br/><br/>
            <input type="submit" value="Insert" />
        </center>
    </form>

    <%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String victimIdStr = request.getParameter("VictimId");
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String dateOfBirthStr = request.getParameter("DateOfBirth");
        String gender = request.getParameter("Gender");
        String phoneNumber = request.getParameter("PhoneNumber");
        String address = request.getParameter("Address");

        // Validate parameters (basic validation can be added)

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root", "Anjali@123");

            // Prepare SQL statement for insertion
            String sql = "INSERT INTO Victim(VictimId, FirstName, Lastname, DateOfBirth, Gender, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(victimIdStr));
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setDate(4, Date.valueOf(dateOfBirthStr));
            pstmt.setString(5, gender);
            pstmt.setString(6, phoneNumber);
            pstmt.setString(7, address);

            // Execute the insert statement
            int rowsInserted = pstmt.executeUpdate();

            // Check if insertion was successful
            if (rowsInserted > 0) {
                out.println("<p><b>Victim Record Inserted Successfully!</b></p>");
            } else {
                out.println("<p><b>Failed to insert Victim Record.</b></p>");
            }

            // Close resources
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            out.println("<p><b>Error inserting victim record: " + e.getMessage() + "</b></p>");
            e.printStackTrace();
        }
    }
    %>

</body>
</html>
