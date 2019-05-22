package DAOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.delivery.dao.Order_DetailsDAO;
import restaurant.delivery.models.Order_Details;

public class Order_DetailsDAO_Test {
Order_Details od = null;
Order_Details found = null;
Order_DetailsDAO order_detailsdao = null;
List<Order_Details> odlist = null;
@Before
public void beforeTest() {
	od = new Order_Details();
	order_detailsdao = new Order_DetailsDAO();
}
@Test
public void test1() throws ClassNotFoundException, IOException, SQLException {
	odlist = order_detailsdao.getAllOrderDetails();
	System.out.println("Woohoo! We managed to execute the SQL command without hitting an exception.");
}
@Test
public void test2() throws ClassNotFoundException, IOException, SQLException {
	od = new Order_Details();
	od.setItem_id(1);
	od.setLocation_id(123);
	od.setOrder_id(3000);
	od.setUser_id(1);
	order_detailsdao.saveOrder(od);
	System.out.println("Order successfully saved...running test!");
	odlist = order_detailsdao.getAllOrderDetails();
	for(Order_Details find: odlist) {
		if (find.getOrder_id() == 3000) {
			System.out.println("passed!");
		}
	}
	

	
}

}
