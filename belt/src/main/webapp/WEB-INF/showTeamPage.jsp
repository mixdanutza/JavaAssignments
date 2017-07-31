<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Team Page</title>
<link rel="stylesheet" type="text/css" href="css/showTeam.css">
</head>
<style>

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}

</style>
<body>
<c:if test="${errorMessage != null}">
    <c:out value="${errorMessage}"/>
</c:if>


<h1><a href="/admin/foolCreator">back</a></h1>
<h1>${team.name}</h1>

<h3>Team status: <c:out value="${team.size}"/>/<c:out value="${team.getUsers().size()}"/> </h3>
<table>
        <thead>
                <th>Username</th>
                <th>Age</th>
                <th>Action</th>

        </thead>
        <tbody>
                <c:forEach var="u" items="${team.getUsers()}">    
                <tr>                      
                	<td>${u.username}</td>
                	<td><c:out value="${Math.floor((today.getTime()- u.createdAt.getTime())/(1000*60*60*24)).intValue()}"/> days</td>
                	<td>
		        		 <form method="POST" action="/admin/deleteJoin">
				  			<input type="hidden" value="${u.id}" name="userId"/>
				  			<input type="hidden" value="${team.id}" name="teamId"/>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<button type="submit">Destroy</button>
						 </form>  
		                 <a href="/admin/updateUser/${u.id}">Update User</a>
                	</td>
                	</tr>
                </c:forEach>
        </tbody>
</table>


</body>
</html>