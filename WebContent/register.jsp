<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>

<div  align = "center" >
<form action="Login" method = "post">
User Name:<br>
  <input type="text" name="uname"><br>
  E-mail:<br>
  <input type="email" name="email"><br>
  Type of rater <br>
	  <select name="rtype">
	    <option value="online">Online</option>
	    <option value="food critic">Food Critic </option>
	    <option value="blogger">Blogger </option>
	  </select> <br>
  Password:<br>
  <input type="password" name="pass"> <br>
  
  <input type="submit" name="submit" value="register"> 
</form>
</div>

</body>
</html>