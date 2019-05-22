<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.*, restaurant.delivery.models.Menu, restaurant.delivery.models.Locations" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receipt</title>
</head>
<style type="text/css">
#items{
width: 100px;
height: 100px;
border-radius: 50%;
border: 1px solid black;
margin-left: 100px;
}
</style>
<body>
<center><h1>Receipt</h1></center>
<%
double gettax = (double)session.getAttribute("orderTotal");
int tax = (int)(gettax*.10);
List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
List<Menu> printList = (List<Menu>)session.getAttribute("menuList");
List<Locations> locationList = (List<Locations>)session.getAttribute("locationList");
int ID = (int)session.getAttribute("locationID");
  for(String x: currentOrder) {
	for(Menu m: printList) {
	if (x.equals(m.getItem_name())) {		
%>
<img id="items" alt="image" src=<%="images/"+m.getImage()%> />
<%=m.getCost()%>
<%=m.getItem_name()%>
 
<% 	  }
	}
  }
 %>
 <p align="right">Total: $<%=session.getAttribute("orderTotal") %></p>
 <p align="right">Tax: $<%=tax%></p>
 <p align="right">Items: <%=currentOrder.size()%></p>
 <%
 
		for(Locations L: locationList) {
			if (ID == L.getLocationID()) {
 %>
 <p align="right"><%=L.getLocation_name() %></p>
 <p align="right"><%=L.getAddress() %></p>
 <%}
}%>
 
 
</body>
</html>