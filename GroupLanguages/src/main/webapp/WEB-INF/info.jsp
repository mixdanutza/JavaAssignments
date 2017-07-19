<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<h1>Information </h1>

    	<form action="/" method="GET" class="form">
    		<button class="button">dashboard</button>
    	</form>
<p>
Language: <strong><c:out value="${language.name}"/></strong><br>
Creator: <strong><c:out value="${language.creator}"/></strong><br>
Version: <strong><c:out value="${language.version}"/></strong>


</p>




</body>
</html>