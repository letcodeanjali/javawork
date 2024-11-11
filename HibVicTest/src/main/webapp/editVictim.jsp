<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.java.hib.Victim" %>
<%@ page import="com.java.hib.VictimDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Victim</title>
</head>
<body>
    <h2>Edit Victim</h2>
    <%
        VictimDaoImpl victimDao = new VictimDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Victim victim = victimDao.searchVictimDao(id);
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            victim.setName(name);
            victim.setAddress(address);
            victimDao.updateVictimDao(victim);
            response.sendRedirect("listVictims.jsp");
        }
    %>
    <form action="editVictim.jsp?id=<%= victim.getId() %>" method="post">
        Name: <input type="text" name="name" value="<%= victim.getName() %>" required><br>
        Address: <input type="text" name="address" value="<%= victim.getAddress() %>" required><br>
        <input type="submit" value="Update Victim">
    </form>
</body>
</html>
