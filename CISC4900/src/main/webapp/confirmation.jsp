<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.*, restaurant.delivery.models.Menu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="CSSFiles/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
#items{
width: 100px;
height: 100px;
border-radius: 50%;
border: 1px solid black;
margin-left: 100px;
}
</style>
<head>
<div id="header"><jsp:include page="HTMLFiles/headerCart.html"></jsp:include></div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Review</title>
</head>
<body bgcolor="rgb(135,206,250)">
<p align="right"><a href="pay">Process Order</a> <a href="cancelorder">Cancel Order</a></p>
<h1><center>Review Your Order</center></h1>
<%
 
List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
List<Menu> printList = (List<Menu>)session.getAttribute("menuList");

int itemnum = 0;
double total = 0;

  for(String x: currentOrder) {
	for(Menu m: printList) {
	if (x.equals(m.getItem_name())) {
		total += m.getCost();
		
%>
<form action = "confirm?action=updateCart" method = "post">
<img id="items" alt="image" src=<%="images/"+m.getImage()%> />
<%=m.getCost()%> <%=m.getItem_name() %>
	<input type = "HIDDEN" name = "itemnumber" VALUE = "<%=++itemnum%>"/>
  <input type = "submit" name = "submit" value = "Remove Item"/><br/>
  </form>
<% 	  }
	}
  }
session.setAttribute("orderTotal", total); %>

<jsp:include page="HTMLFiles/footer.html"></jsp:include>
	<div id="footer"></div>
</body>
</html>