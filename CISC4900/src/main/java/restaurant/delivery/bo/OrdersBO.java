package restaurant.delivery.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.dao.LocationsDAO;
import restaurant.delivery.dao.MenuDAO;
import restaurant.delivery.dao.Order_DetailsDAO;
import restaurant.delivery.dao.OrdersDAO;
import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Orders;

public class OrdersBO {
	public Orders getInfoByOrderID(final int orderID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item name
		final OrdersDAO getdetails = new OrdersDAO();
		Orders orderinfo = new Orders();
		
		orderinfo = getdetails.byOrderID(orderID);
		
		return orderinfo;
		
	}

	
	public Orders getInfoByUserID(final int User_ID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final OrdersDAO getdetails = new OrdersDAO();
		Orders orderinfo = new Orders();
		
		orderinfo = getdetails.byUserID(User_ID);
		
		return orderinfo;
	}

	public int updateOrders(Orders save) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final OrdersDAO getdetails = new OrdersDAO();
	
		int orderID = getdetails.saveOrder(save);
		
		return orderID;
	}
	
	public List<Orders> getOrderList() throws SQLException, ClassNotFoundException, IOException { //returns an array of objects with list of items on menu + info
		final OrdersDAO getOrders = new OrdersDAO();
		
		List<Orders> orderlist = new ArrayList<Orders>();
		
		orderlist = getOrders.getAllOrders();
		
		
		return orderlist;
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		OrdersBO item1 = new OrdersBO();
		Orders o = new Orders();
		
		o = item1.getInfoByUserID(2727);
		
		System.out.println(o.getUser_id());
//test this later
		//user ID = 2727
		//item ID = 1
		//location_ID = 123
	}
}
