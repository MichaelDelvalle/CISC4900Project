<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSSFiles/style.css" rel="stylesheet" type="text/css">
<title>Login to RestaurantDelivery</title>
</head>
<jsp:include page = "HTMLFiles/headerWelcome.html"/>
<body bgcolor ="rgb(135,206,250)">
<div id="header"></div>
	<br><br><br><br>
<form action="RegisterServlet?action=login" method="post">
<div class="loginDiv" align="center">	
			<div class="subDiv1" align="center">
				<br><strong>Login</strong><br>
<%if (request.getAttribute("message") != null) {%>
<div class="subDiv2" ><%=request.getAttribute("message")%></div>
<%}%>
<br/>
<table align="center">
<tr><td><input type = "text" name = "loginEmail" placeholder="Email Address"/><br /></td></tr>
<tr><td><input type = "password" name = "loginPass" placeholder="Password"/><br /></td></tr>
<table>
					<tr>
						<td><a href='register.jsp'>Register?&nbsp;</a><td><input type="submit" name="login" value="Login" /></td>
				   </tr>
				   <tr>
						<td><a href='admin/page'>Admin?&nbsp;</a></td>
				   </tr>
				</table>
			
		    </div>
	    </div>

</form>


<br><br><br><br>
<jsp:include page = "HTMLFiles/footer.html" />
	<div id="footer"></div>
</body>
</html>