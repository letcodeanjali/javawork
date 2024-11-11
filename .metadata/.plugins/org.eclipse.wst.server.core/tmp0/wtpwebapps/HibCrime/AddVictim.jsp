<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.java.crime.VictimDaoImpl" %>
<%@ page import="com.java.crime.Victims" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Victim</title>
</head>
<body>
<div align="center">
    <form action="AddVictim.jsp" method="post">
        <center>
            <label for="victimId">Victim ID:</label>
            <input type="number" id="victimId" name="victimId" required />
            <br /><br />

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required />
            <br /><br />

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required />
            <br /><br />

            <label for="dateOfBirth">Date Of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required />
            <br /><br />

            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
            </select>
            <br /><br />

            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required />
            <br /><br />

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required />
            <br /><br />

            <input type="submit" value="Add Victim" />
        </center>
    </form>

    <c:if test="${param.victimId != null}">
    <jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
    <jsp:useBean id="beanVictim" class="com.java.crime.Victims" />

    <jsp:setProperty name="beanVictim" property="victimId" param="victimId" />
    <jsp:setProperty name="beanVictim" property="firstName" param="firstName" />
    <jsp:setProperty name="beanVictim" property="lastName" param="lastName" />
    <jsp:setProperty name="beanVictim" property="gender" param="gender" />
    <jsp:setProperty name="beanVictim" property="phoneNumber" param="phoneNumber" />
    <jsp:setProperty name="beanVictim" property="address" param="address" />

    <!-- Handle dateOfBirth separately due to data type conversion -->
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dateString = request.getParameter("dateOfBirth");
            if (dateString != null && !dateString.isEmpty()) {
                Date dateOfBirth = new Date(sdf.parse(dateString).getTime());
                beanVictim.setDateOfBirth(dateOfBirth);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    %>

    <%
        // Add the victim to the database
        String result = beanVictimDao.addVictimDao(beanVictim);
        request.setAttribute("result", result);
    %>

    <jsp:forward page="VictimShow.jsp" />
</c:if>

</div>
</body>
</html>
