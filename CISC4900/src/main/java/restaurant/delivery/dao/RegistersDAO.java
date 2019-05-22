package restaurant.delivery.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Registers;
import restaurant.delivery.util.SQLConstants;

public class RegistersDAO {
		public List<Registers> getAllCustomers() throws ClassNotFoundException, IOException, SQLException {
			List<Registers> returnme = null;
			Registers reg = null; //new ArrayList<Registers>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			System.out.println("inside method");
			try {
				conn = OracleConnect.getConnection(); //initiates a connection
				stmt = conn.prepareStatement(SQLConstants.Registers_SELECTALL); //creates object that will allow injection to pre-defined Query
				//executes query
				
				returnme = new ArrayList<Registers>();
				resultSet = stmt.executeQuery(); 
				while(resultSet.next()){
					System.out.println("while");
					reg = new Registers();
					
					reg.setUserId(resultSet.getInt(1));
					reg.setFname(resultSet.getString(2));
					reg.setLname(resultSet.getString(3));					
					reg.setPass(resultSet.getString(4));					
					reg.setGender(resultSet.getString(5));					
					reg.setAddress(resultSet.getString(6));					
					reg.setPhone(resultSet.getString(7));
					System.out.println(returnme.size());
					reg.setEmail(resultSet.getString(8));
					reg.setRole(resultSet.getString(9));
					returnme.add(reg);
					
				}
			}catch (SQLException e) {
				e.getStackTrace();
			}finally {
//				resultSet.close();
				stmt.close();
				conn.close();
			}			
			return returnme; //finish later (returns object)
	}
		public Registers byFirstName(String firstName) throws SQLException, ClassNotFoundException, IOException {
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_BYFIRSTNAME);
				stmt.setString(1, firstName); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Registers();
					returnObj.setUserId(resultSet.getInt(1));
					returnObj.setFname(resultSet.getString(2));
					returnObj.setLname(resultSet.getString(3));
					returnObj.setPass(resultSet.getString(4));
					returnObj.setGender(resultSet.getString(5));
					returnObj.setAddress(resultSet.getString(6));
					returnObj.setPhone(resultSet.getString(7));
					returnObj.setEmail(resultSet.getString(8));
					returnObj.setRole(resultSet.getString(9));
				}
				stmt.close();
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
					resultSet.close();
					stmt.close();
					conn.close();
				}
			
			return returnObj;
		}
		public Registers byUserID(int user_ID) throws ClassNotFoundException, IOException, SQLException {
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_BYUSERID);
				stmt.setInt(1, user_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Registers();
					returnObj.setUserId(resultSet.getInt(1));
					returnObj.setFname(resultSet.getString(2));
					returnObj.setLname(resultSet.getString(3));
					returnObj.setPass(resultSet.getString(4));
					returnObj.setGender(resultSet.getString(5));
					returnObj.setAddress(resultSet.getString(6));
					returnObj.setPhone(resultSet.getString(7));
					returnObj.setEmail(resultSet.getString(8));
					returnObj.setRole(resultSet.getString(9));
				}
				stmt.close();
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
					resultSet.close();
					stmt.close();
					conn.close();
				}
			
			return returnObj;
		}

		public Registers byEmail(String email) throws ClassNotFoundException, IOException, SQLException {
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_BYEMAIL);
				stmt.setString(1, email); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				System.out.println("gets");
				if (resultSet.next()) {
					System.out.println("getting some data");
					returnObj = new Registers();
					returnObj.setUserId(resultSet.getInt(1));
					returnObj.setFname(resultSet.getString(2));
					returnObj.setLname(resultSet.getString(3));
					returnObj.setPass(resultSet.getString(4));
					returnObj.setGender(resultSet.getString(5));
					returnObj.setAddress(resultSet.getString(6));
					returnObj.setPhone(resultSet.getString(7));
					returnObj.setEmail(resultSet.getString(8));
					returnObj.setRole(resultSet.getString(9));
				}
				else {
					System.out.println("nope");
					returnObj = new Registers();
					returnObj.setUserId(1);
					returnObj.setFname("notfound");
					returnObj.setLname("lastname");
					returnObj.setPass("password");
					returnObj.setGender("m");
					returnObj.setAddress("not found");
					returnObj.setPhone("123");
					returnObj.setEmail("not found");
					returnObj.setRole("not found");
				}
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
					resultSet.close();
					stmt.close();
					conn.close();
				}
			return returnObj;
	
		}
		public Registers getMaxUserID() throws ClassNotFoundException, IOException, SQLException {
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement("SELECT MAX(USER_ID) FROM REGISTERS");
				//stmt.setString(1, email); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Registers();
					returnObj.setUserId(resultSet.getInt(1));
				}
				stmt.close();
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
					resultSet.close();
					stmt.close();
					conn.close();
				}
			
			return returnObj;
		}
		public void saveCustomer(Registers reg) throws ClassNotFoundException, IOException, SQLException {
			RegistersDAO getmax = new RegistersDAO();
			Registers savemax = getmax.getMaxUserID();
			int IDCount = savemax.getUserId();
			IDCount++;
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			System.out.println("DEBUG: Trying to add user number " + IDCount + " now...");
			try
			{
				
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_ADDUSER);
				stmt.setInt(1, IDCount);
				stmt.setString(2, reg.getFname()); //first question mark in query will be replaced by this
				stmt.setString(3, reg.getLname());
				stmt.setString(4, reg.getPass());
				stmt.setString(5, reg.getGender());
				stmt.setString(6, reg.getAddress());
				stmt.setString(7, reg.getPhone());
				stmt.setString(8, reg.getEmail());
				stmt.setString(9, "customer");
				System.out.println("DEBUG: creating new user...");
				stmt.executeUpdate();
				System.out.println("DEBUG: New user added to database.");
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
//					resultSet.close();
					stmt.close();
					conn.close();
				}
		}
		public void updateCustomer(Registers reg) throws ClassNotFoundException, IOException, SQLException {
			int userID = reg.getUserId();
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			try
			{
				
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_UPDATEUSER);
				
				stmt.setInt(1, userID);
				stmt.setString(2, reg.getFname()); //first question mark in query will be replaced by this
				stmt.setString(3, reg.getLname());
				stmt.setString(4, reg.getPass());
				stmt.setString(5, reg.getGender());
				stmt.setString(6, reg.getAddress());
				stmt.setString(7, reg.getPhone());
				stmt.setString(8, reg.getEmail());
				stmt.setString(9, reg.getRole());
				stmt.setInt(10, userID);
				System.out.println("DEBUG: Attempting to update information for user "+userID);
				stmt.executeUpdate();
				System.out.println("DEBUG: User updated");
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
//					resultSet.close();
					stmt.close();
					conn.close();
				}
		}
		
/*		public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
			RegistersDAO test = new RegistersDAO();
			Registers o = test.byEmail("okokok");
			System.out.println(o.getEmail());
		}*/
////			List<Registers> listofregisters = test.getAllCustomers();
//			Registers displayme = new Registers();
////			displayme.setUserId(59);
////			displayme.setFname("Ee");
////			displayme.setLname("Ee");
////			displayme.setAddress("dss");
////			displayme.setEmail("sdf");
////			displayme.setGender("m");
////			displayme.setPass("sfdsf");
////			displayme.setPhone(33333333);
//			displayme = test.byEmail("testing@email.com");
//			System.out.println(displayme.getFname());
////			System.out.println(listofregisters.size());
////			for(int i = 0; i < listofregisters.size(); i++) {
////				displayme = listofregisters.get(i);
////				System.out.println("Customer number "+(i+1)+" is "+displayme.getFname());
////			}
//		}
}
