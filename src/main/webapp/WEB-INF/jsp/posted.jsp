<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>You have successfully Posted Your Blog ${blog.username}</h1>
	<h1>${blog.title}</h1>
	<p>${blog.content}</p>
	<a href="<spring:url value="/"/>">Return to Home Page</a> | <a href="<spring:url value="/${blog.blogname}"/>">Go to Profile Page</a>
</body>
</html>