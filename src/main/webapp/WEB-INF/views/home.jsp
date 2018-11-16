<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<!-- <script type="text/javascript">
	function foo() {
		var dropDownElement = document
				.getElementById("drop-down-search-criteria");
		var selectedOption = dropDownElement.options[dropDownElement.selectedIndex].value;
		console.log(selectedOption)
		return selectedOption;
	}
</script> -->
</head>
<body>
	<h1>Welcome ${active_user}</h1>

	<h4>Your lucky gem today is ${lucky_gem}</h4>



	<!-- <button type="button" onclick="location.href=foo()"
		value="do some search!"></button> 
	<input type="submit" onclick="location.href=foo()"
		value="do some search!">
	<a href="index">back to main page</a> -->
	
	
	<sf:form action = "home" method = "POST" modelAttribute="blank_search">
		<select name="searchByGem">
			<option value=2>---select---</option>
			<option value=1>gem</option>
			<option value=0>country</option>
		</select>
		<input type="submit" value="do some search!">
	</sf:form>
	<a href="index">back to main page</a> 


	<%-- <h1>Lucky numbers: 
		<c:forEach items="${lucky_number}" var="individual_number">
		${individual_number}
		</c:forEach>
	</h1> --%>
</body>
</html>