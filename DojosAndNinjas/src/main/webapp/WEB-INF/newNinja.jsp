<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>New Ninja</h1>

<form:form method="POST" action="/ninjas/new" modelAttribute="ninja" class="form">
	<form:label path="dojo">Dojo
		<form:select path="dojo">
			<c:forEach items="${dojos}" var="d">
				<form:option value="${d.id}">${d.name}</form:option>
			</c:forEach>
		</form:select>
	</form:label>
	
	<br><br><br>

	<form:label path="firstName">First Name
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	</form:label>
	
	<br><br><br>
	
	<form:label path="lastName">Last Name
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	</form:label>
	
	<br><br><br>
	
	<form:label path="age">Age
	<form:errors path="age"/>
	<form:input path="age" type="number" max="100" min="1"/>
	</form:label>
	
	<br><br><br>
	
	<input type="submit" value="Add Ninja">
</form:form>

</body>
</html>