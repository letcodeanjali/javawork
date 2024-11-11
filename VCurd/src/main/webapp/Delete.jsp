<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.java.curdjpa.VictimDaoImpl" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.StringWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Victim</title>
</head>
<body>
    <h2>Delete Victim</h2>
    <form method="post" action="delete.jsp">
        Victim Id to Delete: <input type="number" name="victimId" required/>
        <input type="submit" value="Delete">
    </form>

    <%
    if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("victimId") != null) {
        try {
            int victimId = Integer.parseInt(request.getParameter("victimId"));
            
            // Use DAO to delete victim
            VictimDaoImpl impl = new VictimDaoImpl();
            String result = impl.deleteVictimDao(victimId);
            
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
