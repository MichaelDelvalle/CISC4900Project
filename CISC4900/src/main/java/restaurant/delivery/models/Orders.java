package restaurant.delivery.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders {
	private
		int Order_id;
		int user_id;
		Date order_date;
		int Location_id;
		double Total_amount;
	
	//Constructors
	public Orders() {
		this.Order_id = 0;
		this.user_id = 0;
		//this.order_date = 0;
		this.Location_id = 0;
		this.Total_amount = 0.0;
	}
	
	//Order_ID from ORDERS TABLE	
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	
	//User_ID from ORDERS TABLE
	public int getUser_id() {
		return user_id;
	}
	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}
	
	//Location_ID from ORDERS TABLE
	public int getLocation_id() {
		return Location_id;
	}
	public void setLocation_id(int location_id) {
		Location_id = location_id;
	}
	
	//Order_date from ORDERS TABLE
	public Date getOrder_date() {
	/*	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");*/
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	//Total_amount from ORDERS TABLE
	public double getTotal_amount() {
		return Total_amount;
	}
	public void setTotal_amount(double total_amount) {
		Total_amount = total_amount;
	}

}
