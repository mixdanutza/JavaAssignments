<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Team Page</title>
<link rel="stylesheet" type="text/css" href="css/new.css">
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
.error{
	color:red;
}
.formBox{
	margin:0% 40% 0% 40%;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=email], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=password] select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
.password{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;

}
.submitBtn{
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
.red{
color:red;
}


</style>
<body>
<p class="green"><c:out value="${success}"/></p>
<h1>
	<a href="/">back</a>
</h1>

<table>
        <thead>
                <th>User Name</th>
                <th>Team Name</th>
                <th>Age</th>
                <th> Action </th>

        </thead>
        <tbody>
                <c:forEach var="row" items="${all}">                          
                <tr>
                        <td>${row[0].username}</td>
                        <td><a href="/admin/showTeam/${row[1].id}">${row[1].name}</a></td>
                        <td>
							<c:out value="${Math.floor((today.getTime()- row[0].createdAt.getTime())/(1000*60*60*24)).intValue()}"/> days
                        </td>
                        <td>
	                 		  <form method="POST" action="/admin/deleteJoin">
					  			<input type="hidden" value="${row[0].id}" name="userId"/>
					  			<input type="hidden" value="${row[1].id}" name="teamId"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button type="submit">Destroy</button>
							 </form>  
 	                 		  <form method="POST" action="/admin/makeAdmin/${row[0].id}">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button type="submit">Make user admin</button>
							 </form>
							 
                        
                        
                        </td>
                </tr>
                </c:forEach>
        </tbody>
</table>



	<hr>

<div class="formBox">
<c:if test="${error != null}">
    <p class="red"><c:out value="${error}"/></p>
</c:if>
		<form  method="POST" action="/admin/join">
			<select name="userId">
				<c:forEach items="${allUsers}" var="u">
					<option value="${u.getId()}"> ${u.getUsername()}</option>
				</c:forEach>
				
			</select>
			<br><br>
			<select name="teamId">
				<c:forEach items="${allTeams}" var="t">
					<option value="${t.getId()}"> ${t.getName()}</option>
				</c:forEach>
				
			</select>
			
			
			
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    <input type="submit" value="Join" />
		</form>
</div>

<hr>

<div class="formBox">
	<form:form action="/admin/newTeam" method="POST" modelAttribute="team">
	    <p>
	        Team Name:
	        <strong class="error"><form:errors path="name"/></strong>   
	        <form:input path="name"/>
	    </p>
	    
	    <p>
	        Team Size:
	        <strong class="error"><form:errors path="size"/></strong>   
	        <form:input path="size" type="number" max="100" min="1"/>
	    </p>
	    
	    <button class="submitBtn" type="submit">Create Team!</button>
	</form:form>
</div>

</body>
</html>