package restaurant.delivery.models;

public class Reviews {
private
	int User_id;
	int Location_id;
	String Review;
	
	
	//Constructor
	public Reviews() {
		this.User_id = 0;
		this.Location_id = 0;
		this.Review = "";
	}
	
	//Method: USERID
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	
	//Method: LOCATIONID
	public int getLocation_id() {
		return Location_id;
	}
	public void setLocation_id(int location_id) {
		Location_id = location_id;
	}
	
	//Method: REVIEW
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}

}
