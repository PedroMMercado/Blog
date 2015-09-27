<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body onload='document.f.j_username.focus();'>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">NoobCoder | Login</a>
        </div>
      </div>
    </nav>
	<div class="container">
		<h1>Please Log In</h1>
		<c:if test="${not empty error }">
			<div class="alert alert-danger" role="alert">
  				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  				<span class="sr-only">Error:</span>
				Your login was unsuccessful <br> Caused:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
			</div>
		</c:if>
		<form action="j_spring_security_check" name="f" method="post">
			<div class="form-group">
				<label for="j_username">Enter User Name</label> <input type="text"
					class="form-control" name="j_username" placeholder="User Name">
			</div>
			<div class="form-group">
				<label for="j_password">Password</label> <input type="password"
					class="form-control" name="j_password" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default">Log In</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>




</body>
</html>



