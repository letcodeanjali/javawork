<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.java.curdjpa.Victim" %>
<%@ page import="com.java.curdjpa.VictimDaoImpl" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AddVictim.jsp">
<center> 
<h2>Insert Victim</h2>
Victim Id : 
<input type="number" name="victimId" required/> <br/><br/>
First Name : 
<input type="text" name="firstName" required/>
<br/><br/> 
Last Name : 
<input type="text" name="lastName" required/> <br/><br/>
Date Of Birth : 
<input type="date" name="dateofbirth" required/> <br/><br/>
Gender : 
<select name="gender" required>
<option value="MALE">Male</option> 
<option value="FEMALE">Female</option> 
</select> <br/><br/> 
PhoneNumber:
<input type="text" name="phoneNumber" required/> <br><br>
Address : 
<input type="text" name="address" required/> <br><br>
<input type="submit" value="Insert" />
</center> 
</form> 
<%
if (request.getMethod().equalsIgnoreCase("POST")) {
    String victimIdStr = request.getParameter("victimId");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String dateOfBirthStr = request.getParameter("dateofbirth");
    String gender = request.getParameter("gender");
    String phoneNumber = request.getParameter("phoneNumber");
    String address = request.getParameter("address");

    if (victimIdStr != null && firstName != null && lastName != null &&
        dateOfBirthStr != null && gender != null && phoneNumber != null && address != null) {

        try {
            // Convert parameters
            int victimId = Integer.parseInt(victimIdStr);
            Date dateOfBirth = Date.valueOf(dateOfBirthStr);

            // Create Victim object
            Victim victim = new Victim();
            victim.setVictimID(victimId);
            victim.setFirstName(firstName);
            victim.setLastName(lastName);
            victim.setDateOfBirth(dateOfBirth);
            victim.setGender(gender);
            victim.setPhoneNumber(phoneNumber);
            victim.setAddress(address);

            // Use DAO to insert into database
            VictimDaoImpl impl = new VictimDaoImpl();
            String result = impl.addVictimDao(victim);

            // Redirect to a confirmation page
            response.sendRedirect("VictimShow.jsp?message=" + URLEncoder.encode(result, "UTF-8"));
        } catch (NumberFormatException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            out.println("Error: Invalid number format.");
            out.println("An error occurred: " + sw.toString());
        } catch (IllegalArgumentException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            out.println("Error: Illegal argument.");
            out.println("An error occurred: " + sw.toString());
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            out.println("An error occurred: " + e.getMessage());
            out.println("Stack trace: " + sw.toString());
        }
    } else {
        out.println("Error: Required fields are missing.");
    }
}
%>



</body>
</html>