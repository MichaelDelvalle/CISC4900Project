package restaurant.delivery.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.delivery.dao.MenuDAO;
import restaurant.delivery.models.Menu;

public class MenuBO {
	public int getItem(final String Item_name) throws SQLException, ClassNotFoundException, IOException { //gets item information by item name
		final MenuDAO getID = new MenuDAO();
		int id = 0;
		
		id = getID.getItem(Item_name);
		
		return id;
	}
	public Menu getItem(final int Item_ID) throws SQLException, ClassNotFoundException, IOException { //gets item information by item ID
		final MenuDAO getName = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getName.getItem(Item_ID);
		return menu;
	}
	public List<Menu> getItemList() throws SQLException, ClassNotFoundException, IOException { //returns an array of objects with list of items on menu + info
		final MenuDAO getItemList = new MenuDAO();
		
		List<Menu> menu = new ArrayList<Menu>();
		
		menu = getItemList.getItemList();
		
		
		return menu;
	}/*
	public void pushUpdate(Menu menuObj) throws SQLException { //updates information for item 
		final MenuDAO push = new MenuDAO();
		//push.updateItemInfo(menuObj.getItem_name());
		push.updateItemInfo(menuObj);
		System.out.println("Item successfully updated!");
	}*/
	
	/*public void setItem_ID(final String Item_Name, final int NewID) throws SQLException { //updates table and sets item ID for item name
		final MenuDAO setID = new MenuDAO();
		setID.setItem_ID(Item_Name, NewID);
	}
	public void setItem_Name(final int Item_ID, final String NewName) throws SQLException { //sets item name by ID
		final MenuDAO setName = new MenuDAO();
		setName.setItem_Name(Item_ID, NewName);
		
	}
	public Menu getLocation_ID(final String Item_Name) throws SQLException { //gets location ID based on name provided
		final MenuDAO getID = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getID.getLocation_ID(Item_Name);
		
		
		return menu;
	}
	public void setLocation_ID(final String Item_Name, final int ID) throws SQLException { //gets location ID based on name provided
		final MenuDAO setID = new MenuDAO();
		setID.setLocation_ID(Item_Name, ID);

	}
	public Menu getCost(final String item_name) throws SQLException { //gets cost of item by name
		final MenuDAO getCost = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getCost.getCost(item_name);
		
		
		return menu;
	}
	public Menu getCost_ID(final int item_ID) throws SQLException { //gets cost of item by item ID
		final MenuDAO getCost_ID = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getCost_ID.getCost_ID(item_ID);
		
		
		return menu;
	}
	
	public void setCost(final String item_name, final double cost) throws SQLException { //sets cost of item by item name
		final MenuDAO setCost = new MenuDAO();
		setCost.setCost(item_name, cost);
	
	}
	public Menu getDescription(final int item_ID) throws SQLException { //gets description of item by item ID
		final MenuDAO getDescription_ID = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getDescription_ID.getDescription(item_ID);
		
		return menu;
	}
	public Menu getDescription(final String item_name) throws SQLException { //gets description of item by item ID
		final MenuDAO getDescription_item_name = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getDescription_item_name.getDescription(item_name);
		
		return menu;
	}
	public void setDescription(final int item_ID, final String newdescription) { //sets description of item by item ID
		final MenuDAO setDescription_ID = new MenuDAO();
		
		setDescription_ID.setDescription(item_ID, newdescription);

	}
	public void setDescription(final String item_name, final String newdescription) { //sets description of item by item ID
		final MenuDAO setDescription_item_name = new MenuDAO();
		
		setDescription_item_name.setDescription(item_name, newdescription);

	}
	public Menu getImageName(final String item_name) throws SQLException { //gets image name of item by item name
		final MenuDAO getImage_name = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getImage_name.getImage(item_name);
		
		return menu;
	}
	public Menu getImageName(final int item_ID) throws SQLException { //gets image name of item by item ID
		final MenuDAO getImage_byID = new MenuDAO();
		Menu menu = new Menu();
		
		menu = getImage_byID.getImage(item_ID);
		
		return menu;
	}*/
	
	/*get 1 item by name/ID
	list of items <- list
	modify one item <- accpet obj as peram
	delete item <- delte by item name or ID*/
	
//	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//		List<Menu> printList = new ArrayList<Menu>();
//		Menu getlist = null;
//		
//		MenuBO item1 = new MenuBO();
//		Menu pizza = item1.getItem("pizza");
//		System.out.println(pizza.getDescription() + " is " + pizza.getCost());
//		
//		printList = item1.getItemList();
//		
//		for(int i = 0; i < printList.size(); i++) {
//			getlist = new Menu(); //creates a new instance of Menu every interaction
//			getlist = printList.get(i);
//			System.out.println("Item_ID:\tName\tLocID\tPrice\tDescription\tImage");
//			System.out.println(getlist.getItem_id()+"\t\t"+getlist.getItem_name()+"\t"+getlist.getLocation_id()+"\t"+getlist.getCost()+"\t"+getlist.getDescription()+"\t"+getlist.getImage());
//		}
//	}
}
