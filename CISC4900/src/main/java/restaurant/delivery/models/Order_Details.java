package restaurant.delivery.models;

public class Order_Details {
private
	int Order_id;
	int User_id;
	int Item_id;
	int Location_id;
	
	//Constructors
	public Order_Details() {
		this.Order_id = 0;
		this.User_id = 0;
		this.Item_id = 0;
		this.Location_id = 0;
	}
	
	//Order_ID from Order_Details TABLE
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	
	//User_ID from Order_Details TABLE
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	
	//Item_ID from Order_Details TABLE
	public int getItem_id() {
		return Item_id;
	}
	public void setItem_id(int item_id) {
		Item_id = item_id;
	}
	
	//Location_ID from Order_Details TABLE
	public int getLocation_id() {
		return Location_id;
	}
	public void setLocation_id(int location_id) {
		Location_id = location_id;
	}
}
