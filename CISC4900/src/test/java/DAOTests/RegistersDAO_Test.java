package DAOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.delivery.dao.RegistersDAO;
import restaurant.delivery.models.Registers;

public class RegistersDAO_Test {
Registers customer = null;
List<Registers> customerList = null;
RegistersDAO registersdao = null;

@Before
public void beforeTest() {
	customer = new Registers();
	registersdao = new RegistersDAO();
	try {
		customerList = registersdao.getAllCustomers();
		} catch (ClassNotFoundException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
@Test
public void test1() {
	if (customerList != null)
		System.out.println("first test passed, customer list is not invalid!");
	else
		assertThat(customerList.get(1).getFname(), is("invalid"));
}
@Test
public void test2() {
	customer.setAddress("JUNIT");
	customer.setEmail("test@junit.org");
	customer.setFname("jUnit");
	customer.setGender("M");
	customer.setLname("lastname_JUNIT");
	customer.setPass("password");
	customer.setPhone("634-424-9482");
	customer.setRole("customer");
	try {
		registersdao.saveCustomer(customer);
	} catch (ClassNotFoundException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
System.out.println("second test passed, no errors on adding user...checking if new user was really added ");
}
@Test
public void test3() {
	for(Registers c: customerList) {
		if(c.getAddress().equals("JUNIT")) {
			assertThat(c.getPhone(), is("634-424-9482"));
		}
	}
}
}
