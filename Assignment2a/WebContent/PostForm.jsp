<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Form</title>
</head>
<body>

<form action="TestServlet"method="post">
  <label>First name:</label><br>
  <input type="text" name="firstname"><br>
  <label>Last name:</label><br>
  <input type="text" name="lastname"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>