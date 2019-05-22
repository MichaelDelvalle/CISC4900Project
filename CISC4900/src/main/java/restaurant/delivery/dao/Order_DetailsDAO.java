package restaurant.delivery.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Registers;
import restaurant.delivery.util.SQLConstants;

public class Order_DetailsDAO {
	public void saveOrder(Order_Details save) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = OracleConnect.getConnection();
			stmt = conn.prepareStatement(SQLConstants.OD_ADDOD);
			stmt.setInt(1, save.getOrder_id());
			stmt.setInt(2, save.getUser_id());
			stmt.setInt(3, save.getItem_id());
			stmt.setInt(4, save.getLocation_id());
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.getStackTrace();
		}finally {
				stmt.close();
				conn.close();
			}
	}
		public List<Order_Details> getAllOrderDetails() throws ClassNotFoundException, IOException, SQLException {
			List<Order_Details> returnme = new ArrayList<Order_Details>();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			Order_Details o = null;
			
			try {
				conn = OracleConnect.getConnection(); //initiates a connection
				stmt = conn.prepareStatement(SQLConstants.OD_SELECTALL); //creates object that will allow injection to pre-defined Query
				resultSet = stmt.executeQuery(); //executes query
				
				while(resultSet.next()) {
					o = new Order_Details();
					o.setOrder_id(resultSet.getInt(1));
					o.setUser_id(resultSet.getInt(2));
					o.setItem_id(resultSet.getInt(3));
					o.setLocation_id(resultSet.getInt(4));
					returnme.add(o);
				}
		
			}finally {
				conn.close();
				stmt.close();
				//resultSet.close();
			}
			
			return returnme; //finish later
	}

		public Order_Details byLocID(int location_ID) throws SQLException, ClassNotFoundException, IOException {
			Order_Details returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.OD_BYLOCID);
				stmt.setInt(1, location_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Order_Details();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_id(resultSet.getInt(2));
					returnObj.setItem_id(resultSet.getInt(3));
					returnObj.setLocation_id(resultSet.getInt(4));
				}
				/*private int locationID;
				private String location_name;
				private String address;
				private int staff_num;
				private int zipcode;
				private String image;
				private String category;*/
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

		public Order_Details byOrderID(int OrderID) throws ClassNotFoundException, IOException, SQLException {
			Order_Details returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.OD_BYORDERID);
				stmt.setInt(1, OrderID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Order_Details();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_id(resultSet.getInt(2));
					returnObj.setItem_id(resultSet.getInt(3));
					returnObj.setLocation_id(resultSet.getInt(4));
				}
				/*private int locationID;
				private String location_name;
				private String address;
				private int staff_num;
				private int zipcode;
				private String image;
				private String category;*/
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
		public int count(int order_ID) throws ClassNotFoundException, IOException, SQLException {
			int count = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement("SELECT COUNT(USER_ID) FROM ORDER_DETAILS WHERE ORDER_ID = ?");
				stmt.setInt(1, order_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					count = resultSet.getInt(1);
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
			
			return count;
		}
		public Order_Details byUserID(int user_ID) throws ClassNotFoundException, IOException, SQLException {
			Order_Details returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.OD_BYUSERID);
				stmt.setInt(1, user_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Order_Details();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_id(resultSet.getInt(2));
					returnObj.setItem_id(resultSet.getInt(3));
					returnObj.setLocation_id(resultSet.getInt(4));
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

		public Order_Details byItemID(int item_ID) throws ClassNotFoundException, IOException, SQLException {
			Order_Details returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.OD_BYITEMID);
				stmt.setInt(1, item_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Order_Details();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_id(resultSet.getInt(2));
					returnObj.setItem_id(resultSet.getInt(3));
					returnObj.setLocation_id(resultSet.getInt(4));
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
		
		/*public void saveCustomer(List<String> reg) throws ClassNotFoundException, IOException, SQLException {
			RegistersDAO getmax = new RegistersDAO();
			Registers savemax = getmax.getMaxUserID();
			int IDCount = savemax.getUserId();
			Registers returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			System.out.println("Hey, I found the max UserID! ("+IDCount+") Incrementing now...");
			try
			{
				IDCount++;
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Registers_ADDUSER);
				stmt.setInt(1, IDCount);
				stmt.setString(2, reg.getFname()); //first question mark in query will be replaced by this
				stmt.setString(3, reg.getLname());
				stmt.setString(4, reg.getPass());
				stmt.setString(5, reg.getGender());
				stmt.setString(6, reg.getAddress());
				stmt.setDouble(7, reg.getPhone());
				stmt.setString(8, reg.getEmail());
				stmt.executeUpdate();
				System.out.println("goooot");
//				DatabaseMetaData meta = conn.getMetaData();
//				ResultSet rs = meta.getPrimaryKeys(null, null, "REGISTERS");
				
//				int id = rs.getInt(1);
				System.out.println("hhhhhh");
			}
			catch (SQLException e)
			{
				e.getStackTrace();
			}finally {
//					resultSet.close();
					stmt.close();
					conn.close();
				}
		}*/

}
