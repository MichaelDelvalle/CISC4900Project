package DAOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.delivery.dao.LocationsDAO;
import restaurant.delivery.models.Locations;
import org.junit.*; 

public class LocationsDAO_Test {
	LocationsDAO locationdao = null;
	List<Locations> locationList = null;
	Locations location = null;
@Before
public void beforeTest() throws ClassNotFoundException, IOException, SQLException {
	locationdao = new LocationsDAO();
	locationList = locationdao.LocationAll();
	location = locationList.get(1);
}

@Test
public void LocationsInDBTest() {
	assertThat(locationList.size(), is(3));
}

@Test
public void getLocation1() throws ClassNotFoundException, IOException, SQLException {
	assertThat(location.getLocation_name(), is(not("Brooklyn Deli")));
	
	}
}
