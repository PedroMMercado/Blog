<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Blog Template for Bootstrap</title>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>	
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">NoobCoder | ${blogURL}</a>
        </div>
      </div>
    </nav>
    <br>
    <br>
	<div class="container">
		<div class="row">
		<c:set var="count" value= "0"/>
			<c:forEach items="${blog}" var="blog">
				<div class="col-md-8">			
					<h1>${blog.title}</h1>
					<h3>${blog.content }</h3> 
				</div>
				<c:if test="${count == 0}">
					<div class="col-md-4">
						<h1>Top 5 Recent Post</h1>
					</div>
				</c:if>
				<c:set var="count" value="${count + 1}"/>
			 </c:forEach>
		</div>	
	</div>
	


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>


