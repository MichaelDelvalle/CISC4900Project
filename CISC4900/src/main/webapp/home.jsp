<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Page</title>
	<link href="CSSFiles/style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="rgb(135,206,250)">

	<div id="header"><jsp:include page="HTMLFiles/headerWelcome.html"></jsp:include></div>
	
	<p class="image">
		<img src="images/WelcomeIcon.jpg">
	</p>
	<jsp:include page="HTMLFiles/footer.html"></jsp:include>
	<div id="footer"></div>
</body>
</html>