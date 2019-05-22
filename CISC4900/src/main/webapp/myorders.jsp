<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.*, restaurant.delivery.models.Registers, restaurant.delivery.models.Menu, restaurant.delivery.bo.OrdersBO, restaurant.delivery.models.Orders, restaurant.delivery.models.Order_Details, restaurant.delivery.bo.Order_DetailsBO, restaurant.delivery.models.Locations" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Orders</title>
</head>
<body>
<% Registers user = (Registers)session.getAttribute("userOBJ");
List<Menu> MenuList = (List<Menu>)session.getAttribute("menuList");
Menu menu = new Menu();
OrdersBO getorders = new OrdersBO();
List<Orders> orderList = getorders.getOrderList();
Order_DetailsBO od = new Order_DetailsBO();
Order_Details details = od.getInfoByUserID(user.getUserId());
List<Order_Details> orderDetailsList = od.getOrderList();
List<Locations> locationList = (List<Locations>)session.getAttribute("locationList");
for(Order_Details x: orderDetailsList) {
	for(Orders o: orderList) {
		for(Menu m: MenuList) {
	if (x.getItem_id() == m.getItem_id() && o.getOrder_id() == x.getOrder_id()) {
		int count = od.getcount(o.getOrder_id());
		int ID = o.getLocation_id();
		double Total = o.getTotal_amount();
		int Tax = (int)(Total*.10);
%>
<img id="items" alt="image" src=<%="images/"+m.getImage()%> />
<%=m.getCost()%>
<%=m.getItem_name()%>

 <p align="right">Total: $<%=Total%></p>
 <p align="right">Tax: $<%=Tax%></p>
 <p align="right">Items: <%=count%></p>
 <%  
 for(Locations L: locationList) {
		if (ID == L.getLocationID()) {
%>
<p align="right"><%=L.getLocation_name() %></p>
<p align="right"><%=L.getAddress() %></p>
		<%
		  }
		}
	  }
	}
  }
}
 %>

</body>
</html>