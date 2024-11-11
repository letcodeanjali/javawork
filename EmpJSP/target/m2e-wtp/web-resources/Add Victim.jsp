<%@ page import="java.sql.*, java.util.*, javax.sql.*" %>
<%@ page import="model.Victim, dao.VictimDAO" %>
<%
    String victimID = request.getParameter("victimID");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String dateOfBirth = request.getParameter("dateOfBirth");
    String gender = request.getParameter("gender");
    String phoneNumber = request.getParameter("phoneNumber");
    String address = request.getParameter("address");

    if (victimID != null && firstName != null && lastName != null && dateOfBirth != null && gender != null && phoneNumber != null && address != null) {
        Victim victim = new Victim();
        victim.setVictimID(Integer.parseInt(victimID));
        victim.setFirstName(firstName);
        victim.setLastName(lastName);
        victim.setDateOfBirth(dateOfBirth);
        victim.setGender(gender);
        victim.setPhoneNumber(phoneNumber);
        victim.setAddress(address);

        VictimDAO victimDAO = new VictimDAO();
        victimDAO.addVictim(victim);

        out.println("Victim added successfully!");
    }
%>

<form action="addVictim.jsp" method="post">
    Victim ID: <input type="text" name="victimID" required><br>
    First Name: <input type="text" name="firstName" required><br>
    Last Name: <input type="text" name="lastName" required><br>
    Date of Birth: <input type="date" name="dateOfBirth" required><br>
    Gender: <select name="gender">
                <option value="Female">Female</option>
                <option value="Male">Male</option>
                <option value="Other">Other</option>
            </select><br>
    Phone Number: <input type="text" name="phoneNumber" required><br>
    Address: <input type="text" name="address" required><br>
    <input type="submit" value="Add Victim">
</form>
