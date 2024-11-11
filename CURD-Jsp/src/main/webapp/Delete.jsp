<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Victim</title>
</head>
<body>
    <h2>Delete Victim</h2>
    <form action="deleteVictimServlet" method="post">
        <label for="victimID">Victim ID:</label>
        <input type="number" id="victimID" name="victimID" required><br>
        <button type="submit">Delete Victim</button>
    </form>
</body>
</html>
