package restaurant.delivery.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.dao.LocationsDAO;
import restaurant.delivery.dao.Order_DetailsDAO;
import restaurant.delivery.dao.OrdersDAO;
import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Orders;

public class Order_DetailsBO {
	public void saveOrderDetails(Order_Details save) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final Order_DetailsDAO getdetails = new Order_DetailsDAO();
		getdetails.saveOrder(save);
	
	}
	public List<Order_Details> getOrderList() throws SQLException, ClassNotFoundException, IOException { //returns an array of objects with list of items on menu + info
		final Order_DetailsDAO getOrders = new Order_DetailsDAO();
		
		List<Order_Details> orderlist = new ArrayList<Order_Details>();
		
		orderlist = getOrders.getAllOrderDetails();
		
		
		return orderlist;
	}
	public int getcount(final int order_ID) {
		Order_DetailsBO bo = new Order_DetailsBO();
		int count = bo.getcount(order_ID);
		return count;
	}
	public Order_Details getInfoByOrderID(final int orderID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item name
		final Order_DetailsDAO getdetails = new Order_DetailsDAO();
		Order_Details orderinfo = new Order_Details();
		
		orderinfo = getdetails.byOrderID(orderID);
		
		return orderinfo;
		
	}
	public Order_Details getInfoByLocID(final int Location_ID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final Order_DetailsDAO getdetails = new Order_DetailsDAO();
		Order_Details orderinfo = new Order_Details();
		
		orderinfo = getdetails.byLocID(Location_ID);
		
		return orderinfo;
	}
	public Order_Details getInfoByUserID(final int User_ID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final Order_DetailsDAO getdetails = new Order_DetailsDAO();
		Order_Details orderinfo = new Order_Details();
		
		orderinfo = getdetails.byUserID(User_ID);
		
		return orderinfo;
	}
	public Order_Details getInfoByItemID(final int Item_ID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final Order_DetailsDAO getdetails = new Order_DetailsDAO();
		Order_Details orderinfo = new Order_Details();
		
		orderinfo = getdetails.byItemID(Item_ID);
		
		return orderinfo;
	}

	/*	public Locations[] getItemList() throws SQLException { //returns an array of objects with list of items on menu + info
	final LocationsDAO getItemList = new LocationsDAO();
	Menu[] objarr = null;
	objarr = getItemList.getLocations();		
//	objarr[0] = new Menu(); initializes array 
	
	return objarr; // FIX AND REVISE LATER, CREATE ARRAY OBJECT AND NAME OBJS BY ITEM_NAME
}*/
	
	/*get 1 item by name/ID
	list of items <- list
	modify one item <- accpet obj as peram
	delete item <- delte by item name or ID*/
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		Order_DetailsBO item1 = new Order_DetailsBO();
		Order_Details o = new Order_Details();
		
		o = item1.getInfoByLocID(123);
		
		System.out.println(o.getUser_id());
//test this later
		//user ID = 2727
		//item ID = 1
		//location_ID = 123
	}
}
