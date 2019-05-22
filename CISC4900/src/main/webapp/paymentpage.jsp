<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check out - Restaurant Delivery</title>
</head>
<body>
<p align="right"><a href="cancelorder">Cancel Order</a></p>

<h3>Payment Information</h3>
<form action="pay?action=processOrder" method = "post">
Credit Card Number: <input type = "text" name = "ccnumber"/> <br />
Secure number: <input type = "text" name = "securenumber"/> <br />
Zipcode: <input type = "text" name = "zipcode"/> <br />
<input type = "submit" name = "submit" value = "Process" />
</form>
</body>
</html>