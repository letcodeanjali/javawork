<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu.jsp"  />
<form method="post" action="login.jsp">
<center>
<h2>Please Login :</h2>
Username : <input type="text" name="username" size="50"> <br/><br/>
Password : <input type="password" name="pass" size="50"> <br/><br/>
<input type="submit" value="Login">
</center>
</form>
<%
	if (request.getParameter("username")!=null && request.getParameter("pass")!=null) {
		LibraryDaoImpl impl = new LibraryDaoImpl();
		int count = impl.authenticate(request.getParameter("username"), request.getParameter("pass"));
		if (count==1) {
			session.setAttribute("user", request.getParameter("username"));
%>
	<jsp:forward page="Menu.jsp" />
<%
		} else {
			out.println("Invalid Credentials...");
		}
	}
%>

</body>
</html>