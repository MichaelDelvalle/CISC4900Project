package restaurant.delivery.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnect {
	public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		final Properties prop = new Properties();
		final InputStream inputStream = OracleConnect.class.getClassLoader().getResourceAsStream(
													"restaurant/delivery/resources/restaurantdb.properties");
	prop.load(inputStream);
	Class.forName(prop.getProperty("driver"));
	final Connection connection = DriverManager.getConnection(prop.getProperty("url"),
			prop.getProperty("user"), prop.getProperty("password"));
	return connection;
	
	}
}
