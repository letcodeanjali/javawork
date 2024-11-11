<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.java.hib.VictimDaoImpl" %>
<%@ page import="com.java.hib.Victim" %>
<%@ page import="java.sql.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Victim</title>
</head>
<body>
    <center>
        <form action="AddVictim.jsp">
            Victim Id:
            <input type="number" name="victimid" /><br><br>
            FirstName :
            <input type="text" name="firstname" /><br><br>
            Last Name:
            <input type="text" name="lastname"/><br><br>
            DateOfBirth :
            <input type="date" name="dateofbirth"/><br><br>
            Gender :
            <select name="gender">
                <option value="Male" >Male</option>
                <option value="Female" >Female</option>
            </select><br><br><br>
            PhoneNumber :
            <input type="text" name="phonenumber"/><br><br>
            Address :
            <input type="text" name="address"/><br><br>
            <input type="submit" value="AddVictim"/>
            <c:if test="${param.victimid != null && param.phonenumber != null}">
                <jsp:useBean id="beanVictimDao" class="com.java.hib.VictimDaoImpl" />
                <jsp:useBean id="beanVictim" class="com.java.hib.Victim" />
                <jsp:setProperty property="*" name="beanVictim" />
                <%-- Here we call the addVictimDao method from VictimDaoImpl --%>
                <c:out value="${beanVictimDao.addVictimDao(beanVictim)}" />
                <%-- After adding, forward to a page to display all victims --%>
                <jsp:forward page="VictimShow.jsp" />
            </c:if>
        </form>
    </center>
</body>
</html>
