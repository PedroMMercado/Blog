<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">Admin Panel</a>
        </div>
      </div>
    </nav>
	<div class="container">
		<table class="table">
		    <thead>
		      <tr>
		        <th>User Name</th>
		        <th>Blog Domain</th>
		        <th>Enabled</th>
		        <th>Suspend User</th>
		      </tr>
		    </thead>
		    <tbody>
		    <c:forEach items="${users}" var="users">
		      <tr>
		        <td>${users.userName }</td>
		        <td>${users.userDomain }</td>
		        <td>${users.enabled }</td>      
		        <c:choose>
				  <c:when test="${users.enabled == true}">
				  	<td><a href="<spring:url value="/suspend/${users.userName}"/>">Suspend User</a></td>
				  </c:when>
				  <c:otherwise>
				  	<td><a href="<spring:url value="/enable/${users.userName}"/>">Enable User</a></td>
				  </c:otherwise>
				</c:choose>
		      </tr>
		    </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>