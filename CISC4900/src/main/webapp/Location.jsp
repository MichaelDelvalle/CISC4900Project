<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "restaurant.delivery.bo.LocationsBO, java.util.*, restaurant.delivery.models.Locations" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select your location</title>
<link href="CSSFiles/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="rgb(135,206,250)">
<jsp:include page = "HTMLFiles/headerLocation.html" />
<%
List<Locations> locationList = null;
if(session.getAttribute("locationList") != null) {
locationList = (List<Locations>)session.getAttribute("locationList");
}
%>
<form action = "LocationServlet?action=selectLocation" method = "post">
<center><select name="location">
<%for (int i = 0; i < locationList.size(); i++) { %>
	<option value=<%= locationList.get(i).getLocationID()%>><%= locationList.get(i).getLocation_name()%></option>
<%}%>
</select></center>
<input type = "submit" name = "submit" value = "Select" />
</form>
<div id="header"></div>

			<%
				for(Locations x: locationList) {
			%>
			<div><tr>
				<td><img src= "images/<%=x.getImage()%>" alt="Location" width="150" height="150"></td></div>
				<td><div align="center" style="max-width:904px; color:white"><br><br>
				<input type = "hidden" name = "locationID" value =<%=x.getLocationID()%>/>
					<input type="hidden" name="restaurant" value=<%=x.getLocation_name()%> /><%=x.getLocation_name()%><br>
					<input type="hidden" name="address" value=<%=x.getAddress()%> /><%=x.getAddress()%><br><br><br><br><br>
					<hr color="lightgrey" width="300" align="center"></hr> 
				</div></td>
			</tr>
			<%	
			}
			%>
			</table>
		</div>


<jsp:include page = "HTMLFiles/footer.html" />
<div id="footer"></div>
</body>
</html>