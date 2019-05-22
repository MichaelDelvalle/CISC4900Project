package DAOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.delivery.dao.MenuDAO;
import restaurant.delivery.models.Menu;

public class MenuDAO_Test {
	MenuDAO menuDAO = null;
	List<Menu> menuList = null;
	Menu menuobj = null;
@Before
public void beforeTest() throws ClassNotFoundException, IOException, SQLException {
	menuDAO = new MenuDAO();
	menuList = menuDAO.getItemList();
}
@Test
public void Test1() {
		assertThat(menuList.size(), is(2));
	}
@Test
public void Test2() {
		menuobj = menuList.get(1);
		if (menuobj.getItem_id() == 1)
			assertThat(menuobj.getItem_name(), is("pizza"));
		else if (menuobj.getItem_id() == 2)
			assertThat(menuobj.getItem_name(), is("burger"));
	}
}
