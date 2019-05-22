<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import = "restaurant.delivery.models.Registers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>
</head>
<%
Registers user = (Registers)session.getAttribute("userOBJ");
%>
<body>
<center><h1>Your information</h1></center>
<br>
<center>
<form action = "userinfo?action=updateUser" method = "post">
<%if (session.getAttribute("userupdatemessage") != null) {%>
<%=session.getAttribute("userupdatemessage") %><br/>
<%}%>
First name: <input type = "text" name = "fname" value = "<%=user.getFname()%>" /> <br/>
Last name: <input type = "text" name = "lname" value = "<%=user.getLname()%>" /> <br/>
Password: <input type = "password" name = "password" value = "<%=user.getPass()%>" /> <br/>
Re-type Password: <input type = "password" name = "passwordconfirm" value = "<%=user.getPass() %>" /> <br/>
Gender: <input type = "text" name = "gender" value = "<%=user.getGender()%>" /> <br/>
Address: <input type = "text" name = "address" value = "<%=user.getAddress()%>" /> <br/>
Phone number: <input type = "text" name = "phonenumber" value = "<%=user.getPhone()%>" /> <br/>
Email: <input type = "text" name = "email" value = "<%=user.getEmail()%>" /> <br/>
<input type = "submit" name = "submit" value = "Update Info" />
</form>
</center>
</body>
</html>