<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.java.curdjpa.VictimDaoImpl" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Victim</title>
</head>
<body>
    <h2>Update Victim</h2>
    <form method="post" action="update.jsp">
        Victim Id: <input type="number" name="victimId" required/><br/><br/>
        First Name: <input type="text" name="firstName" required/><br/><br/>
        Last Name: <input type="text" name="lastName" required/><br/><br/>
        Date Of Birth: <input type="date" name="dateOfBirth" required/><br/><br/>
        Gender:
        <select name="gender" required>
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
        </select><br/><br/>
        PhoneNumber: <input type="text" name="phoneNumber" required/><br/><br/>
        Address: <input type="text" name="address" required/><br/><br/>
        <input type="submit" value="Update">
    </form>

    <%
    if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("victimId") != null &&
            request.getParameter("firstName") != null && request.getParameter("lastName") != null &&
            request.getParameter("dateOfBirth") != null && request.getParameter("gender") != null &&
            request.getParameter("phoneNumber") != null && request.getParameter("address") != null) {

        try {
            int victimId = Integer.parseInt(request.getParameter("victimId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
            String gender = request.getParameter("gender");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");

            // Create Victim object
            com.java.curdjpa.Victim victim = new com.java.curdjpa.Victim();
            victim.setVictimID(victimId);
            victim.setFirstName(firstName);
            victim.setLastName(lastName);
            victim.setDateOfBirth(dateOfBirth);
            victim.setGender(gender);
            victim.setPhoneNumber(phoneNumber);
            victim.setAddress(address);

            // Use DAO to update victim
            VictimDaoImpl impl = new VictimDaoImpl();
            String result = impl.updateVictimDao(victim);

            response.sendRedirect("VictimShow.jsp?message=" + URLEncoder.encode(result, "UTF-8"));
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            out.println("An error occurred: " + sw.toString());
        }
    }
    %>
</body>
</html>
