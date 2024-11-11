<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanVictimDao" class="com.java.crime.VictimDaoImpl" />
	<c:set var="victimid" value="${param.victimid}" />
	<c:set var="victims" value="${beanVictimDao.searchVictimDao(victimid)}" />
	<form method="get" action="UpdateVictim.jsp">
		<center>
			Victim Id : 
			<input type="number" name="victimid"value=${victims.victimid} >
			<br/><br/>
			First Name : 
			<input type="text" name="firstname"value=${victims.firstname} > 
			<br/><Br/>
			Last Name :
			<input type="text" name="lastname"value=${victims.lastname} > <br><br>
			DateOfBirth :
			<input type="date" name="dateofbirth"value=${victims.dateofbirth}><br><br>
			Gender :
			<input type="text" name="gender" value=${victims.gender}><br><br>
			PhoneNumber:
			<input type="text" name="phonenumber"value=${victims.phonenumber}><br><br>
			Address :
			<input type="text" name="address"value=${victims.address}><br><br>
			<input type="submit" value="Update" />
 		</center>
	</form>
	<c:if test="${param.victimid!=null && param.phonenumber!=null}">
	<jsp:useBean id="victimUpdated" class="com.java.crime.Victims" />
	<jsp:setProperty property="*" name="victimUpdated"/>
	<c:out value="${beanVictimDao.updateVictimDao(victimUpdated)}" />
	<jsp:forward page="VictimShow.jsp" />
	</c:if>
</body>
</html>