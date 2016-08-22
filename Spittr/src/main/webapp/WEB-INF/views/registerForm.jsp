<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spitter</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/style.css"/>"/>
</head>
<body>
		<h1>REGISTER</h1>
		<form method="POST">
			FIRST NAME:<input type="text" name="firstName"/>
			LAST NAME:<input type="text" name="lastName"/>
			USERNAME:<input type="text" name="userName"/>
			PASSWORD:<input type="password" name="password"/>
			<input type="submit" value="REGISTER"/>
		</form>
</body>
</html>