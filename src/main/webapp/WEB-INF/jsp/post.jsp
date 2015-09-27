<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#hide").hide();
	$(".editBlog").hide();
    $("#edit").click(function(){
        $(".editBlog").show();
        $("#edit").hide();
        $("#hide").show();
    });
    
    $("#hide").click(function(){
    	$(".editBlog").hide();
    	$("#edit").show();
    	$("#hide").hide();
    });
});
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">Blog Post | ${blogID.title }</a>
        </div>
      </div>
    </nav>
	<div class="container">
		<div class="well well-lg">
			<c:if test="${not empty blogID}">
				<h1>${blogID.title}</h1>
				<p>${blogID.content}</p>
				<p>Written by: ${blogID.username }</p>
				<c:if test="${edit}">
					<form:form commandName="editedBlog" class="editBlog">
						<div class="form-group">
							<label for="title">Update Title</label>
							<form:input path="title" class="form-control" placeholder="title" />
						</div>
						<div class="form-group">
							<label for="content">Update Content</label>
							<form:textarea path="content" class="form-control" placeholder="Content" />
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form:form>
					<button id="edit"class="btn btn-default">Edit</button>
					<button id="hide" class="btn btn-default">Hide</button>
				</c:if>
			</c:if>
		</div>
		<c:forEach var="comments" items="${comments}">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 well well-sm">
					<h3>${comments.comment}</h3>
					<p>Written By ${comments.username}</p>	
				</div>
				<div class="col-md-3"></div>
			</div>	
		</c:forEach>
		<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
			<form:form commandName="comment">
				<div class="form-group">
					<label for="comment">Enter Comment</label>
					<form:input path="comment" class="form-control" placeholder="Enter Comment Here" />
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</form:form>
		</sec:authorize>
		
	</div>
</body>
</html>