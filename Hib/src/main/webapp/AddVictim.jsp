<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.java.crime.SqlDateEditor" %>
    <%@ page import="java.sql.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>s
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<Select name="gender">
<option value="Male" >Male</option>
<option value="Female" >Female</option>
</Select><br><br><br>
PhoneNumber :
<input type="text" name="phonenumber"/><br><br>
Address :
<input type="text" name="address"/><br><br>
<input type="submit" value="AddVictim"/>
<c:if test="${param.victimid!=null && param.phonenumber!=null}">
		<jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
		<jsp:useBean id="beanVictims" class="com.java.crime.Victims" />
		<jsp:setProperty property="*" name="beanvictims"/>
		<c:out value="${beanVictimDao.addVictimDao(beanVictims)}" />
		<jsp:forward page="VictimShow.jsp" />
	</c:if>
</form>
</body>
</html>