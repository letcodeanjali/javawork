<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Complaint</title>
</head>
<body>
    <form action="addComplaint" method="POST">
        Complaint Type: <input type="text" name="complaintType"><br>
        Description: <input type="text" name="cDescription"><br>
        Severity: <input type="text" name="severity"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
