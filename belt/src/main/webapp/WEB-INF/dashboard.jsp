<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/dash.css">
</head>
<body>
	
	<h1>Welcome, ${currentUser.username}</h1>
		<div class="welcome">
		<form id="logoutForm" method="POST" action="/logout">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    <input type="submit" value="Logout!" />
		</form>
	</div>
	<p class="welcome">
		Welcome to your awesome magical ring finder, put the ring on, only good things will happen. 
		Maybe it'll make you live forever, go invisible, turn your inherent hunger for riches or power
		into an insatiable curse that eventually dooms your entire species.
	</p>
	
	<div class="box1">
	<p class="green"><c:out value="${success}"/></p>
			<form method="POST" action="/addRing">
				<h2>
					<select name="ringId">
						<c:forEach items="${allRings}" var="ring">
							<option value="${ring.getId()}"> ${ring.getName()}</option>
						</c:forEach>
					</select>
				</h2>	
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button type="submit">BIND YOURSELF IN DARKNESS</button>
			</form>
	</div>

	<p><strong>Roles:</strong><c:forEach items="${currentUser.roles}" var="role"> ${role.name}</c:forEach></p>
	
	<p>Username: ${currentUser.username}</p>
	<p>Email: ${currentUser.email}</p>
	<p>Sign up date: ${currentUser.createdAt}</p>


	
	<c:choose>
		<c:when test="${checkAdmin==true}">
			<a href="/admin/ringCreator">Ring Creator (Powerful Ainur only)</a>
			<br> <br>
			<a href="admin/foolCreator">Person/Team Creator (Powerful Ainur only)</a>
		</c:when>
		<c:otherwise>
			<a href="/">Ring Creator (Powerful Ainur only)</a>
			<br> <br>
			<a href="/">Person/Team Creator (Powerful Ainur only)</a>
		</c:otherwise>
	</c:choose>

	
	<div class="box2">
	<table>
	  <tr>
	    <th>Rings you have found</th>
	    <th>Action</th>
	  </tr>
	 <c:forEach items="${myRings}" var="ring">
		  <tr>
		    <td>${ring.getName()}</td>
		    <td>
	  			<form method="POST" action="/deleteRing">
	  			<input type="hidden" value="${ring.getId()}" name="ringId"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button type="submit">delete</button>
				</form>
		    </td>
	
		  </tr>	 
	 </c:forEach>
	</table>
	</div>
	



</body>
</html>