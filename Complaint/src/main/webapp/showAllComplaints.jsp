<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Complaints</title>
</head>
<body>
    <h2>All Complaints</h2>
    <table border="1">
        <tr>
            <th>Complaint ID</th>
            <th>Complaint Type</th>
            <th>Description</th>
            <th>Severity</th>
            <th>Status</th>
        </tr>
        <c:forEach var="complaint" items="${complaints}">
            <tr>
                <td>${complaint.complaintID}</td>
                <td>${complaint.complaintType}</td>
                <td>${complaint.cDescription}</td>
                <td>${complaint.severity}</td>
                <td>${complaint.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
