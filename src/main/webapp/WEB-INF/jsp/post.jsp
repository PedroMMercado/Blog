<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="well well-lg">
			<c:if test="${not empty blogID}">
					<c:forEach var="blogID" items="${blogID}">
						<h1>${blogID.title}</h1>
						<p>${blogID.content}</p>
					</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>