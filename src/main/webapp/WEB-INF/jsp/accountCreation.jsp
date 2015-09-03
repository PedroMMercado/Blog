<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Creation</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2><label>Create Account</label></h2>
		<form:form commandName="user">
			<div class="form-group">
				<label for="userName">Enter User Name</label>
				<form:input path="userName" class="form-control" placeholder="User Name" />
			</div>
			<div class="form-group">
				<label for="password">Enter Password</label>
				<form:input path="password" class="form-control" placeholder="Password" />
			</div>
			<div class="form-group">
				<label for="User Domain">Enter Domain</label>
				<form:input path="userDomain" class="form-control" placeholder="Domain" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>