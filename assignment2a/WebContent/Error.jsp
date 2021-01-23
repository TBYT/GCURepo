<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR</title>
</head>
<body>
One of these is blank or null!<br>
First Name: <%= request.getAttribute("firstname") %>
<br>
Last Name: <%= request.getAttribute("lastname") %>
</body>
</html>