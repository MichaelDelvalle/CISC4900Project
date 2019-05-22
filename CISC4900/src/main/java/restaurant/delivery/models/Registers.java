package restaurant.delivery.models;

public class Registers {
	private int userId;
	private String fname;
	private String lname;
	private String pass;
	private String gender;
	private String address;
	private String phone;
	private String email;
	private String role;

	//Constructor
	public Registers() {
		this.userId = 0;
		this.fname = "";
		this.lname = "";
		this.pass = "";
		this.gender = "";
		this.address = "";
		this.phone = "";
		this.email = "";
	}
	
	//Method: REGISTERID
	public int getUserId() {
		return userId;
	}
	public void setUserId(int registerId) {
		this.userId = registerId;
	}
	
	//Method: FIRSTNAME
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	//Method: LASTNAME
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	//Method: PASSWORD
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	//Method: GENDER
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//Method: ADDRESS
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Method: PHONE
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//Method: EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Role
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
