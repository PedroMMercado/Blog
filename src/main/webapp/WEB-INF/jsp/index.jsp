<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome to NoobCoder.com</title>

    <!-- Bootstrap core CSS -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">NoobCoder  <c:if test="${not empty username}">| Welcome ${username}</c:if> </a>
        </div>
		<sec:authorize access="hasRole('ROLE_USER')">  
		  <c:url var="logoutUrl" value="j_spring_security_logout"/>    
          <form class="navbar-form navbar-right" action="${logoutUrl}" method="post">
          	<a href="<spring:url value="/blogpost"/>" role="button" class="btn btn-primary">Create Post</a>
          	<a href="<spring:url value="/${blogname}"/>" role="button" class="btn btn-primary">My Profile</a>
  			<input type="submit" value="Log out" role="button" class="btn btn-primary" />
  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </form>
          
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
         <form class="navbar-form navbar-right">
         	<a href="<spring:url value="/login"/>" role="button" class="btn btn-primary">Sign In</a> 
          	<a href="<spring:url value="/createUser"/>" role="button" class="btn btn-primary">Create Account</a> 
         </form>
        </sec:authorize>  
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p>Welcome to the Latest and Greatest Blog Platform, Find out what our current Users are Blogging About, or sign up for an account</p>
      </div>
    </div>
	
    <div class="container">
		<c:choose>
    		<c:when test="${not empty error}">
    			<div class="alert alert-danger" role="alert">
  					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  					<span class="sr-only">Error:</span>
					No More Pages to be Displayed
				</div>
    		</c:when>    
    		<c:otherwise>
	    		<div class="row">
	       			<c:forEach items="${temp1}" var="temp1">
	        			<div class="col-md-4">
	          				<h2>${temp1.title}</h2>
	          				<p>${temp1.content}</p>
	          				<p><a class="btn btn-default" href="<spring:url value="/${temp1.blogname}/${temp1.id}/${temp1.title}"/>" role="button">View Post &raquo;</a></p>
	        			</div>
	       			</c:forEach>
	      		</div>  
	       		<div class="row">
	        		<c:forEach items="${temp2}" var="temp2">
	        			<div class="col-md-4">
	          				<h2>${temp2.title }</h2>
	          				<p>${temp2.content }</p>
	          				<p><a class="btn btn-default" href="<spring:url value="/${temp2.blogname}/${temp2.id}/${temp2.title}"/>" role="button">View Post &raquo;</a></p>
	        			</div>
	        		</c:forEach>
	      		</div>
    		</c:otherwise>
		</c:choose>
		<c:if test="${previousPage != false}">
				<a href="<spring:url value="/?pageNumber=${pageNumberPrevious}"/>" role="button" class="btn btn-primary">Previous</a>
		</c:if>
		<c:if test="${nomorepages != true}">
			<a href="<spring:url value="/?pageNumber=${pageNumberNext}"/>" role="button" class="btn btn-primary">Next</a>
		</c:if>     	
      <hr>
      <footer>
        <p>&copy; NoobCoder 2015</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="styling/js/bootstrap.min.js"></script>
  </body>
</html>
