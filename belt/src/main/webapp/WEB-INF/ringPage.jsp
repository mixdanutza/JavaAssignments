<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Ring Page</title>
<link rel="stylesheet" type="text/css" href="css/dash.css">
</head>
<body>
<p class="green"><c:out value="${success}"/></p>
<h1>
	<a href="/">back</a>
</h1>
<h1>Forge ring power</h1>


<div class="formBox">
	<form:form action="/admin/newRing" method="POST" modelAttribute="ring">
	    <p>
	        Ring Name:
	        <strong class="error"><form:errors path="name"/></strong>   
	        <form:input path="name"/>
	    </p>
	    
   	    <p>  
	        <form:input path="creatorId" type="hidden" value="${admin.getId()}"/>
	    </p>
	    <button class="submitBtn" type="submit">Create Ring</button>
	</form:form>
</div>

</body>
</html>