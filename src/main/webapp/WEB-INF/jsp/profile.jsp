<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Blog Template for Bootstrap</title>

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>

	<div class="container">

		<div class="row">
			<div class="col-md-8">
				<h1>Main</h1>
			</div>
			<div class="col-md-4">
				<h1>Sidebar</h1>
			</div>
			
			
<%-- 			<c:forEach items="${temp2}" var="temp2">
	        		<div class="col-md-4">
	        		<h2>${temp2.title }</h2>
      				<p>${temp2.content }</p>
	   				<p><a class="btn btn-default" href="<spring:url value="/${temp2.blogname}/${temp2.id}/${temp2.title}"/>" role="button">View Post &raquo;</a></p>
	        	</div> --%>
	        	
	 <!--       blog.setBlogname(rs.getString("blogname"));
				blog.setUsername(rs.getString("username"));
				blog.setContent(rs.getString("content"));
				blog.setTitle(rs.getString("title")); -->
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


