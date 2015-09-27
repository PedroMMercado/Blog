<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Post</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">Blog Post | <sec:authentication property="principal.username" /></a>
        </div>
      </div>
    </nav>
	<div class="container">
		<form:form commandName="blog">
			<div class="form-group">
				<label for="title">Enter Title</label>
				<form:input path="title" class="form-control" placeholder="Title" />
			</div>
			<div class="form-group">
				<label for="content">Enter Content</label>
				<form:textarea path="content" class="form-control" placeholder="Content" rows="3" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>