<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response Page</title>
</head>
<body>

Hello <%= request.getAttribute("firstname") %>

Your last name is <%= request.getAttribute("lastname") %>

</body>
</html>