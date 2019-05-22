package restaurant.delivery.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.dao.RegistersDAO;
import restaurant.delivery.models.Registers;
public class RegistersBO {
	public List<Registers> getAllCustomers() throws ClassNotFoundException, IOException, SQLException {
		final RegistersDAO getall=new RegistersDAO();
		List<Registers> Registers = new ArrayList<Registers>();
		
		Registers = getall.getAllCustomers();
		
		return Registers;
		
	}
	public void addUser(Registers newuser) throws ClassNotFoundException, IOException, SQLException {
		RegistersDAO adduser = new RegistersDAO();
		adduser.saveCustomer(newuser);
	}
	public void updateUser(Registers user) throws ClassNotFoundException, IOException, SQLException {
		RegistersDAO dao = new RegistersDAO();
		dao.updateCustomer(user);
	}
	public Registers getInfoByUserID(final int registerID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item name
		final RegistersDAO getdetails = new RegistersDAO();
		Registers registerinfo = new Registers();
		
		registerinfo = getdetails.byUserID(registerID);
		
		return registerinfo;
		
	}
	public Registers getInfoByFirstName(final String FirstName) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final RegistersDAO getdetails = new RegistersDAO();
		Registers registerinfo = new Registers();
		
		registerinfo = getdetails.byFirstName(FirstName);
		
		return registerinfo;
	}
	public Registers getInfoByEmail(final String Email) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final RegistersDAO getdetails = new RegistersDAO();
		Registers registerinfo = new Registers();
		
		registerinfo = getdetails.byEmail(Email);
		
		return registerinfo;
	}
//	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//		
//		RegistersBO item1 = new RegistersBO();
//		Registers getregister = item1.getInfoByUserID(2727);
//		System.out.println( "USER NAME with 2727 is " + getregister.getFname());
//		RegistersDAO test = new RegistersDAO();
//		Registers test1 = new Registers();
//		test1 = test.getMaxUserID();
//		int max = test1.getUserId();
//		System.out.println(max);
//		
//	}
}
