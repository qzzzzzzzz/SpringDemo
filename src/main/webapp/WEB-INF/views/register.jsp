<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h2>Register here</h2>

	<sf:form action="register" method="POST" modelAttribute="blank_register_user">
		Username: <sf:input path="username" type="text" />
		Password: <sf:input path="password" type="password" />
		<input type="submit" value="click me!!!">
	</sf:form>
	<span style="color: red;">${fail_msg}</span>

	<h6>Your password should:</h6>
	<h6>at least 8 characters long</h6>
	<h6>contain at least ONE capital letter</h6>
	<h6>contain at least ONE lowercase letter</h6>
	<h6>contain at least ONE number</h6>
	<h6>contain at least ONE special symbol</h6>

	<a href="index">back to main page</a>

</body>
</html>