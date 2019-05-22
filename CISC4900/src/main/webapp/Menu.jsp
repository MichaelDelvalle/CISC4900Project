<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "restaurant.delivery.models.Menu, java.util.*"%>
    	
<%@ page import='java.util.List' import='java.util.ArrayList' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Delivery's Menu</title>
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
</head>
<body bgcolor="rgb(135,206,250)">
<jsp:include page = "HTMLFiles/headerMenu.html"/>

<!-- <form action = "confirm" method = "post">
<input type = "submit" name = "submit" value = "Process Order" />
</form> -->
<!-- <form action = "OrderProcessingServlet?action=addItem" method = "post"> -->
<%
List<Menu> printList = (List<Menu>)session.getAttribute("menuList"); //creates an arrayList of menu items
Menu menu = null;
if(printList != null) {
for(int i = 0; i < printList.size(); i++) {
	menu = new Menu(); //creates a new instance of Menu every time we loop so we can read from it later
	menu = printList.get(i);
	//request.setAttribute("selectedItem", menu.getItem_name());
	//System.out.println("Name\t\t\tPrice\t\t\t"+"Description");
	//System.out.println(getlist.getItem_name()+"\t\t\t"+getlist.getCost()+"\t\t\t"+getlist.getDescription()+"\t"+getlist.getImage());
%>
<form action = "OrderProcessingServlet?action=<%=printList.get(i).getItem_name()%>" method = "post">
<h1><%="Name\t\t\tPrice\t\t\t"+"Description"%></h1>
<h2><%= printList.get(i).getItem_name()+"\t\t\t"+printList.get(i).getCost()+"\t\t\t"%></h2>
<img id="items" alt="Pizza image" src=<%="images/"+printList.get(i).getImage()%> />
<input type="hidden" name="item_id" value="<%=printList.get(i).getItem_id()%>" />
<h2><%="Description: "+printList.get(i).getDescription()%></h2> <input type = "submit" name ="submit" value = "Add to Cart" />
</form>
<% }
}
else {
%>
<h1>Error occured <a href = "login.jsp">please click here to sign back in</a></h1>
<%} %>
<!-- </form> -->
<jsp:include page = "HTMLFiles/footer.html"/>
</body>
</html>