package restaurant.delivery.models;

public class Locations {
	private int locationID;
	private String location_name;
	private String address;
	private int staff_num;
	private int zipcode;
	private String image;
	private String category;
	
	
	//Constructor
	public Locations() {
		this.locationID = 0;
		this.location_name = "";
		this.address = ""; 
		this.staff_num = 0; 
		this.zipcode = 0;
		this.setImage("");
		this.category = "";
	}
	
	//Method: LOCATIONID
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	//Method: LOCATIONNAME
	public String getLocation_name() {
		return location_name;
	}
	public void setLocationNAME(String location_name) {
		this.location_name = location_name;
	}
	
	//Method: ADDRESS
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Staff_num from Locations table
	public int getStaff_num() {
		return staff_num;
	}
	public void setStaff_num(int staff_num) {
		this.staff_num = staff_num;
	}
	
	//Zipcode from Locations table
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	//Category from Locations table
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	//Image string from Locations table
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
