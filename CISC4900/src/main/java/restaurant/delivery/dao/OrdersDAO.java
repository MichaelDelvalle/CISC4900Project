package restaurant.delivery.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Orders;
import restaurant.delivery.models.Registers;
import restaurant.delivery.util.SQLConstants;

public class OrdersDAO {
	public Orders getMaxUserID() throws ClassNotFoundException, IOException, SQLException {
		Orders returnObj = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try
		{
			conn = OracleConnect.getConnection();
			stmt = conn.prepareStatement("SELECT MAX(ORDER_ID) FROM ORDERS");
			//stmt.setString(1, email); //first question mark in query will be replaced by this
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				returnObj = new Orders();
				returnObj.setOrder_id(resultSet.getInt(1));
			}
			else {
				returnObj.setOrder_id(0);
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
	public int saveOrder(Orders save) throws ClassNotFoundException, IOException, SQLException {
		OrdersDAO getmax = new OrdersDAO();
		Orders savemax = getmax.getMaxUserID();
		int IDCount = savemax.getOrder_id();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		System.out.println("Hey, I found the max OrderID! ("+IDCount+") Incrementing now...");
		try
		{
			IDCount++;
			conn = OracleConnect.getConnection();
			stmt = conn.prepareStatement(SQLConstants.Orders_NEWORDER);
			stmt.setInt(1, IDCount);
			stmt.setInt(2, save.getUser_id());
			java.sql.Date sDate = new java.sql.Date(save.getOrder_date().getTime());
			stmt.setDate(3, sDate);
			stmt.setInt(4, save.getLocation_id());
			stmt.setDouble(5, save.getTotal_amount());
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.getStackTrace();
		}finally {
				stmt.close();
				conn.close();
			}
		return IDCount;
	}
		public List<Orders> getAllOrders() throws ClassNotFoundException, IOException, SQLException {
			List<Orders> returnme = new ArrayList<Orders>();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			Orders o = null;
			
			try {
				conn = OracleConnect.getConnection(); //initiates a connection
				stmt = conn.prepareStatement(SQLConstants.Orders_SELECTALL); //creates object that will allow injection to pre-defined Query
				//stmt.setString(1, email);//sets value to index 1 (first question mark in constants statement)
				resultSet = stmt.executeQuery(); //executes query
				while(resultSet.next()) {
					o = new Orders();
					o.setOrder_id(resultSet.getInt(1));
					o.setUser_Id(resultSet.getInt(2));
					o.setOrder_date(resultSet.getDate(3));
					o.setLocation_id(resultSet.getInt(4));
					o.setTotal_amount(resultSet.getDouble(5));
					returnme.add(o);
				}

			}finally {
				
			}
			
			return returnme; //finish later
	}

		public Orders byOrderID(int OrderID) throws SQLException, ClassNotFoundException, IOException {
			Orders returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Orders_BYOrderID);
				stmt.setInt(1, OrderID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Orders();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_Id(resultSet.getInt(2));
					returnObj.setOrder_date(resultSet.getDate(3));
					returnObj.setLocation_id(resultSet.getInt(4));
					returnObj.setTotal_amount(resultSet.getFloat(5));
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
		public Orders byUserID(int user_ID) throws ClassNotFoundException, IOException, SQLException {
			Orders returnObj = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.Orders_BYUserID);
				stmt.setInt(1, user_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					returnObj = new Orders();
					returnObj.setOrder_id(resultSet.getInt(1));
					returnObj.setUser_Id(resultSet.getInt(2));
					returnObj.setOrder_date(resultSet.getDate(3));
					returnObj.setLocation_id(resultSet.getInt(4));
					returnObj.setTotal_amount(resultSet.getFloat(5));
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
}
