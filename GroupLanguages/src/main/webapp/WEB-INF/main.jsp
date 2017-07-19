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

<h1>Languages </h1>

  <c:forEach items="${errors}" var="error" varStatus="index">
   <p class="red"><c:out value="${error}"/></p>

  </c:forEach>


<hr>
<table>
  <tr>
    <th>Name</th>
    <th>Creator</th>
    <th>Version</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${languages}" var="lan" varStatus="index">
  <tr>
    <td><a href="/show/${index.index}"><c:out value="${lan.name}"/></a></td>
    <td><c:out value="${lan.creator}"/></td>
    <td><c:out value="${lan.version}"/></td>
    <td>
    	<form action="/delete/${index.index}" method="POST" class="form">
    		<button class="button">delete</button>
    	</form>
    	<form action="/edit/${index.index}" method="GET" class="form">
    		<button class="button">edit</button>
    	</form>
    </td>
  </tr>
  </c:forEach>
  
</table>


<div class="formBox">
<form:form method="POST" action="/languages/new" modelAttribute="language">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    
    <form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:input path="creator"/></form:label>
    
    <form:label path="version">Version
    <form:errors path="version"/>
    <form:input path="version"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
</div>




</body>
</html>