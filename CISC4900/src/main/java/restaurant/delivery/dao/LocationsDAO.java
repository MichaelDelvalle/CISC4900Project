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
import restaurant.delivery.util.SQLConstants;

public class LocationsDAO {
		public List<String> getLocations() throws ClassNotFoundException, IOException, SQLException {
			List<String> returnme = new ArrayList<String>();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			Locations l = null;
			
			try {
				conn = OracleConnect.getConnection(); //initiates a connection
				stmt = conn.prepareStatement(SQLConstants.SELECT_BYNAME); //creates object that will allow injection to pre-defined Query
				//stmt.setString(1, email);//sets value to index 1 (first question mark in constants statement)
				ResultSet result = stmt.executeQuery(); //executes query
				l = new Locations();
				
				
			}finally {
				
			}//finish later
			
			return returnme;
	}

		public Locations byLocationName(String location_name) throws SQLException, ClassNotFoundException, IOException {
			Locations locationbyname = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			System.out.println(SQLConstants.LOCATIONS_BYNAME);
			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.LOCATIONS_BYNAME);
				stmt.setString(1, location_name); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					locationbyname = new Locations();
					locationbyname.setLocationID(resultSet.getInt(1));
					locationbyname.setLocationNAME(resultSet.getString(2));
					locationbyname.setAddress(resultSet.getString(3));
					locationbyname.setStaff_num(resultSet.getInt(4));
					locationbyname.setZipcode(resultSet.getInt(5));
					locationbyname.setImage(resultSet.getString(6));
					locationbyname.setCategory(resultSet.getString(6));
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
			
			return locationbyname;
		}

		public Locations byLocationID(int location_ID) throws ClassNotFoundException, IOException, SQLException {
			Locations locationbyID = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;

			try
			{
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement(SQLConstants.LOCATIONS_BYID);
				stmt.setInt(1, location_ID); //first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					locationbyID = new Locations();
					locationbyID.setLocationID(resultSet.getInt(1));
					locationbyID.setLocationNAME(resultSet.getString(2));
					locationbyID.setAddress(resultSet.getString(3));
					locationbyID.setStaff_num(resultSet.getInt(4));
					locationbyID.setZipcode(resultSet.getInt(5));
					locationbyID.setImage(resultSet.getString(6));
					locationbyID.setCategory(resultSet.getString(6));
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
			
			return locationbyID;
		}
		
		
		public List<Locations> LocationAll() throws ClassNotFoundException, IOException, SQLException {
			Locations locationbyID = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet resultSet = null;
			List<Locations> locationList = null;
			try
			{
				locationList = new ArrayList<Locations>();
				conn = OracleConnect.getConnection();
				stmt = conn.prepareStatement("SELECT * FROM Locations");
				//first question mark in query will be replaced by this
				resultSet = stmt.executeQuery();
				while (resultSet.next()) {
					locationbyID = new Locations();
					locationbyID.setLocationID(resultSet.getInt(1));
					locationbyID.setLocationNAME(resultSet.getString(2));
					locationbyID.setAddress(resultSet.getString(3));
					locationbyID.setStaff_num(resultSet.getInt(4));
					locationbyID.setZipcode(resultSet.getInt(5));
					locationbyID.setImage(resultSet.getString(6));
					locationbyID.setCategory(resultSet.getString(7));
					locationList.add(locationbyID);
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
			
			return locationList;
		}
}
