package restaurant.delivery.util;

public class SQLConstants {

		public static final String SELECT_BYNAME = "SELECT ITEM_ID, ITEM_NAME, LOCATION_ID, COST, DESCRIPTION, IMAGE FROM Menu WHERE ITEM_NAME = ? ";
		public static final String SELECT_BYID = "SELECT ITEM_ID, ITEM_NAME, LOCATION_ID, COST, DESCRIPTION, IMAGE FROM Menu WHERE ITEM_ID = ? ";
		public static final String MENU_SELECTALL = "SELECT * FROM MENU";
		
		public static final String LOCATIONS_BYNAME = "SELECT * FROM LOCATIONS WHERE LOCATION_NAME LIKE '%?%'";
		public static final String LOCATIONS_BYID = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		public static final String Orders_BYUserID = "SELECT * FROM ORDERS WHERE USER_ID = ?";
		public static final String Orders_BYOrderID = "SELECT * FROM ORDERS WHERE ORDER_ID = ?";
		public static final String Orders_NEWORDER = "INSERT INTO ORDERS(ORDER_ID, USER_ID, ORDER_DATE, LOCATION_ID, TOTAL_AMOUNT) VALUES(?, ?, ?, ?, ?)";
		public static final String Orders_SELECTALL = "SELECT * FROM ORDERS";
		
		public static final String OD_SELECTALL = "SELECT * FROM ORDER_DETAILS";
		public static final String OD_BYLOCID = "SELECT * FROM ORDER_DETAILS WHERE LOCATION_ID = ?";
		public static final String OD_BYITEMID = "SELECT * FROM ORDER_DETAILS WHERE ITEM_ID = ?";
		public static final String OD_BYORDERID = "SELECT * FROM ORDER_DETAILS WHERE ITEM_ID = ?";
		public static final String OD_BYUSERID = "SELECT * FROM ORDER_DETAILS WHERE ITEM_ID = ?";
		public static final String OD_ADDOD = "INSERT INTO ORDER_DETAILS(ORDER_ID, USER_ID, ITEM_ID, LOCATION_ID) VALUES(?, ?, ?, ?)";

		public static final String Registers_ADDUSER = "INSERT INTO REGISTERS (USER_ID, FIRST_NAME, LAST_NAME, PASSWD, GENDER, ADDRESS, PHONE, EMAIL, ROLE) "+
		"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String Registers_UPDATEUSER = "UPDATE REGISTERS "+ 
				"SET USER_ID = ?, FIRST_NAME = ?, LAST_NAME = ?, PASSWD = ?, GENDER = ?, ADDRESS = ?, PHONE = ?, EMAIL = ?, ROLE = ?," + 
				"WHERE USER_ID = ?;";
		public static final String Registers_SELECTALL = "SELECT * FROM REGISTERS";
		public static final String Registers_BYUSERID = "SELECT * FROM REGISTERS WHERE USER_ID = ?";
		public static final String Registers_BYFIRSTNAME = "SELECT * FROM REGISTERS WHERE FIRST_NAME = ?";
		public static final String Registers_BYEMAIL = "SELECT * FROM REGISTERS WHERE EMAIL = ?";
}
