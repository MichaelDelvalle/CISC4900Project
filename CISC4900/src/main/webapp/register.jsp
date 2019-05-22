<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link href="CSSFiles/style.css" rel="stylesheet" type="text/css">
<jsp:include page = "HTMLFiles/headerWelcome.html"/>
</head>
<body bgcolor="rgb(135,206,250)">
<div id="header"></div>
	<br><br><br><br>

<br />
<form action="RegisterServlet?action=register" method="post">
<div class="regDiv" align="center">
<div class="subRegDiv1" align="center">
<br><strong>Register</strong><br>
<table align="center">
<tr><td><input type = "text" name = "fName" placeholder = "First Name"/> <br /></td></tr>
<tr><td><input type = "text" name = "lName" placeholder = "Last Name"/> <br /></td></tr>
<tr><td><input type = "password" name = "pass" placeholder = "Password"/> <br /></td></tr>
<tr><td><input type = "text" name = "Gender" placeholder = "Gender F/M?"/> <br /></td></tr>
<tr><td><input type = "text" name = "Address" placeholder = "Address"/> <br /></td></tr>
<tr><td><input type = "text" name = "Phone" placeholder = "Phone Number"/> <br /></td></tr>
<tr><td><input type = "text" name = "Email" placeholder = "Email"/> <br /></td></tr>
</table>
<table>
				<tr><td><input type="submit" name="Register" value="Register" /><td><a href='login.jsp'>Login?</a></td></tr>
			</table>
		    </div>
		</div>
</form>




<br><br><br><br>
<jsp:include page = "HTMLFiles/footer.html" />
	<div id="footer"></div>
</body>
</html>