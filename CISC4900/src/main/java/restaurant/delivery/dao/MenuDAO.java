package restaurant.delivery.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Registers;
import restaurant.delivery.util.SQLConstants;

public class MenuDAO {
	public int getItem(final String item_name) throws SQLException, ClassNotFoundException, IOException { //returns Menu object with itemID that matches name provided
		Menu iteminfo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try
		{
			conn = OracleConnect.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SELECT_BYNAME);
			stmt.setString(1, item_name); //first question mark in query will be replaced by this
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				iteminfo = new Menu();
				iteminfo.setItem_id(resultSet.getInt(1));
				iteminfo.setItem_name(resultSet.getString(2));
				iteminfo.setLocation_id(resultSet.getInt(3));
				iteminfo.setCost(resultSet.getFloat(4));
				iteminfo.setDescription(resultSet.getString(5));
				iteminfo.setImage(resultSet.getString(6));
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
		return iteminfo.getItem_id();
	}

	public Menu getItem(int item_ID) throws ClassNotFoundException, IOException, SQLException {

		Menu iteminfo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try
		{
			conn = OracleConnect.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SELECT_BYID);
			stmt.setInt(1, item_ID); //first question mark in query will be replaced by this
			resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				iteminfo = new Menu();
				iteminfo.setItem_id(resultSet.getInt(1));
				iteminfo.setItem_name(resultSet.getString(2));
				iteminfo.setLocation_id(resultSet.getInt(3));
				iteminfo.setCost(resultSet.getFloat(4));
				iteminfo.setDescription(resultSet.getString(5));
				iteminfo.setImage(resultSet.getString(6));
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
		return iteminfo;
	}
	
	public List<Menu> getItemList() throws ClassNotFoundException, IOException, SQLException { //returns arraylist of items
		List<Menu> menulist = null;
		Menu menu = null; //new ArrayList<Registers>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		//System.out.println("DEBUG: inside getItemList MENUDAO method");
		try {
			conn = OracleConnect.getConnection(); //initiates a connection
			stmt = conn.prepareStatement(SQLConstants.MENU_SELECTALL); //creates object that will allow injection to pre-defined Query
			//executes query
			
			menulist = new ArrayList<Menu>();
			
			resultSet = stmt.executeQuery(); 
			while(resultSet.next()){
				//System.out.println("DEBUG: in while loop!");
				menu = new Menu();
				
				menu.setItem_id(resultSet.getInt(1));
				menu.setItem_name(resultSet.getString(2));
				
				menu.setLocation_id(resultSet.getInt(3));
				
				menu.setCost(resultSet.getFloat(4));
				
				menu.setDescription(resultSet.getString(5));
				
				menu.setImage(resultSet.getString(6));				
				menulist.add(menu);
				
				
			}
		}catch (SQLException e) {
			e.getStackTrace();
		}finally {
			resultSet.close();
			stmt.close();
			conn.close();
		}
		
		return menulist;
	}
	public void updateItemInfo(Menu menuObj) {
		// TODO Auto-generated method stub
		
	}

}
