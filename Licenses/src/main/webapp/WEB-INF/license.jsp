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
<h1>New License</h1>



<form:form action="/createLicense" method="post" modelAttribute="license" class="form">
    <form:hidden path="number"></form:hidden>
    <form:label path="person">
        Person:
        <form:select path="person">
            <c:forEach items="${persons}" var="x">
                <form:option value="${x.id}">${x.firstname} ${x.lastname}</form:option>

            </c:forEach>
        </form:select>
    </form:label><br>
    <form:label path="state">State:
        <form:errors path="state"></form:errors>
        <form:input path="state"/>
    </form:label><br>
    <form:label path="expiration">
        Expiration Date:
        <form:errors path="expiration"></form:errors>
        <form:input path="expiration" type="date"/>
    </form:label><br>
    <input type="submit" value="Submit"/>

</form:form>


</body>
</html>