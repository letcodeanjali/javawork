<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<form action="Login">
   First Name: <input type="text" name="fn"> Last Name: <input type="text" name="ln"><br>
   Male<input type="radio" name="r1">
    Female<input type="radio" name="r1"><br>
    <select>
    <option>Select</option>
    <option value="Hyderabad">Hyderabad</option>
    <option value="Kolkatta">Kolkatta</option>
    <option value="Banglore">Banglore</option>
    <option value="Chennai">Chennai</option>
    <option value="Mumbai">Mumbai</option>
    <option value="Delhi">Delhi </option>
     
    </select><br>
    java<input type="checkbox" name="c1">
     java script<input type="checkbox" name="c2">
     react<input type="checkbox" name="c3"><br>
     <input type="submit" value="Register"><br>
     <a href="form.jsp">BACK</a>
  </form>
</body>
</html>