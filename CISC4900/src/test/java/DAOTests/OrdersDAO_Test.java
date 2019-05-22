package DAOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.delivery.dao.OrdersDAO;
import restaurant.delivery.models.Orders;

public class OrdersDAO_Test {
Orders order = null;
OrdersDAO ordersDAO = null;
List<Orders> orderList = null;

@Before
public void beforeTest() throws ClassNotFoundException, IOException, SQLException {
	order = new Orders();
	ordersDAO = new OrdersDAO();
	orderList = ordersDAO.getAllOrders();
}

@Test
public void test1() {
	order.setLocation_id(123);
	order.setOrder_date(new Date());
	order.setOrder_id(3334);
	order.setTotal_amount(5555);
	order.setUser_Id(3);
	try {
		ordersDAO.saveOrder(order);
	} catch (ClassNotFoundException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		orderList = ordersDAO.getAllOrders();
	} catch (ClassNotFoundException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //refreshes order list
	for(Orders orderobj: orderList) {
		if(orderobj.getTotal_amount() == 55555) {
			order = new Orders();
			order = orderobj;
		}
	}
	assertThat(order.getOrder_id(), is(3334));
	}
}
