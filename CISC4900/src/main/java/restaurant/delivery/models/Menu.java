package restaurant.delivery.models;

public class Menu {
	private
	int item_id;
	String item_name;
	int Location_id;
	float Cost;
	String Description;
	String image;
	
	//Constructor
	public Menu() {
		this.item_id = 0;
		this.item_name = "";
		this.Location_id = 0;
		this.Cost = 0;
		this.Description = "";
		this.image = "";
	}
	
	//ITEMID FROM MENU TABLE
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	//ITEM NAME FROM MENU TABLE
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	//LOCATION_ID FROM MENU TABLE
	public int getLocation_id() {
		return Location_id;
	}
	public void setLocation_id(int location_id) {
		Location_id = location_id;
	}
	
	//COST FROM MENU TABLE
	public double getCost() {
		return Cost;
	}
	public void setCost(float cost) {
		Cost = cost;
	}
	
	//DESCRIPTION FROM MENU TABLE
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void displayDescription() {
		System.out.println(this.Description);
	}
	//DISPLAYS NAME OF IMAGE
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
