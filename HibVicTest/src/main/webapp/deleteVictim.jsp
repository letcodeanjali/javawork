<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.java.hib.VictimDaoImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Victim</title>
</head>
<body>
    <%
        VictimDaoImpl victimDao = new VictimDaoImpl();
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                victimDao.deleteVictimDao(id);
                response.sendRedirect("listVictims.jsp");
            } catch (NumberFormatException e) {
                out.println("Invalid ID format.");
            } catch (Exception e) {
                out.println("Failed to delete victim: " + e.getMessage());
            }
        } else {
            out.println("No ID parameter found.");
        }
    %>
</body>
</html>
