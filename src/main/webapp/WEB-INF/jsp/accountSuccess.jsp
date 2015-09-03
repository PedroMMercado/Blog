<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Successfully Created</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="alert alert-success" role="alert">
			<h1>Congratulations, Your Account ${username} Has Been Successfully Created</h1>
			<a href="<spring:url value="/"/>" role="button" class="btn btn-primary">Return to Home Page</a> 
		</div>
	</div>
</body>
</html>