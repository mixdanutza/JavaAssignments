<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Submited Info:</h1>
	<hr>
	
	<p>Name: <strong><c:out value="${newSurvey.getName()}"/></strong> </p>
	<p>Location: <strong><c:out value="${newSurvey.getLocation()}"/></strong> </p>
	<p>Language: <strong><c:out value="${newSurvey.getLanguage()}"/></strong> </p>
	<p>Comment: <strong><c:out value="${newSurvey.getComment()}"/></strong> </p>

</body>
</html>