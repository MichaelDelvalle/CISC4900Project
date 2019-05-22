package restaurant.delivery.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.dao.LocationsDAO;
import restaurant.delivery.models.Locations;

public class LocationsBO {
	public Locations getInfoByName(final String Location_name) throws SQLException, ClassNotFoundException, IOException { //gets location information by item name
		final LocationsDAO getloc = new LocationsDAO();
		Locations locationinfo = new Locations();
		
		locationinfo = getloc.byLocationName(Location_name);
		
		return locationinfo;
	}
	public Locations getInfoByID(final int Location_ID) throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final LocationsDAO getloc = new LocationsDAO();
		Locations locationinfo = new Locations();
		locationinfo = getloc.byLocationID(Location_ID);
		
		return locationinfo;
	}
	
	public List<Locations> AllLocations() throws SQLException, ClassNotFoundException, IOException { //gets location information by item ID
		final LocationsDAO getloc = new LocationsDAO();
		List<Locations> locationinfo = new ArrayList<Locations>();
		locationinfo = getloc.LocationAll();
		
		return locationinfo;
	}

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		LocationsBO item1 = new LocationsBO();
		/*Locations Locquery = item1.getInfoByName("Brooklyn Deli");
		System.out.println( "Item ID for Brooklyn Deli is " + Locquery.getLocationID());*/
		Locations locquery = item1.getInfoByID(123);
		System.out.println(locquery.getLocation_name() +" is Location ID: "+locquery.getLocationID());
		//checklater
		
	}
}
