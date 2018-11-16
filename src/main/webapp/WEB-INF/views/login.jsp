<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Login here</h2>
	
	<sf:form action = "login" method = "POST" modelAttribute="blank_login_user">
		Username: <sf:input path="username" type="text"/>
		Password: <sf:input path="password" type="password"/>
		<input type="submit" value="click me!!!">
	</sf:form>
	
	
	<span style="color: red;">${success_msg}</span>
	<span style="color: red;">${fail_msg}</span>
	
	<br></br>
	
	<a href = "index">back to main page</a>
	<a href = "forget">forget your username/password?</a>
</body>
</html>