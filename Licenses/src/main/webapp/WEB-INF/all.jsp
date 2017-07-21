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
<h1>All Person</h1>

            <c:forEach items="${persons}" var="x">
                <h1>${x.firstname} ${x.lastname}</h1>
                <p>License number: ${x.license.number}</p>
                <p>State: ${x.license.state}</p>
                <p>Expiration Date: ${x.license.expiration}</p>
                
                <hr>

            </c:forEach>


</body>
</html>