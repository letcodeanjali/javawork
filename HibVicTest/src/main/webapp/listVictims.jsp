<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.java.hib.Victim" %>
<%@ page import="com.java.hib.VictimDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Victims</title>
</head>
<body>
    <h2>List of Victims</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <%
            VictimDaoImpl victimDao = new VictimDaoImpl();
            List<Victim> victimList = victimDao.showVictimDao();
            for (Victim victim : victimList) {
        %>
        <tr>
            <td><%= victim.getId() %></td>
            <td><%= victim.getName() %></td>
            <td><%= victim.getAddress() %></td>
            <td>
                <a href="editVictim.jsp?id=<%= victim.getId() %>">Edit</a>
                <a href="deleteVictim.jsp?id=<%= victim.getId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    <br>
    <a href="addVictim.jsp">Add New Victim</a>
</body>
</html>
