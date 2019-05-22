package restaurant.delivery.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.delivery.bo.LocationsBO;
import restaurant.delivery.bo.MenuBO;
import restaurant.delivery.bo.RegistersBO;
import restaurant.delivery.dao.RegistersDAO;
import restaurant.delivery.models.Locations;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Registers;
import restaurant.delivery.util.ConstantVariables;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = null;
		HttpSession session = request.getSession();
		if ("register".equals(action)) {
			if(request.getParameter(ConstantVariables.SUBMIT) != null) {
			//fix user_ID make sure user_ID column in Registers table increments by 1 (FIXED, hard coded solution avail in RegistersDAO)
				String FIRST_NAME = request.getParameter("fName");
				String LAST_NAME = request.getParameter("lName");
				String PASSWD = request.getParameter("pass");
				String Gender = request.getParameter("Gender");
				String Address = request.getParameter("Address");
				String Phone = request.getParameter("Phone");
				String Email = request.getParameter("Email");
				Registers newreg = new Registers();
				newreg.setFname(FIRST_NAME);
				newreg.setLname(LAST_NAME);
				newreg.setPass(PASSWD);
				newreg.setGender(Gender);
				newreg.setAddress(Address);
				newreg.setPhone(Phone);
				newreg.setEmail(Email);
				newreg.setRole("customer");
				RegistersBO adduser = new RegistersBO();
				try {
					adduser.addUser(newreg);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				page = "/login.jsp";
			}
		}
		else if ("login".equals(action)) {
			System.out.println("in login");
			String loginEmail = request.getParameter("loginEmail");
			String loginPWD = request.getParameter("loginPass");
			int userID = 0;
			RegistersBO getuser = new RegistersBO();
			Registers customer = new Registers();
			try {
				customer = getuser.getInfoByEmail(loginEmail);
				System.out.println(loginPWD.equals(customer.getPass()) + " < - is pwd correct?");
				if(loginPWD.equals(customer.getPass())) { //if user exists, take him to menu...
					System.out.println(loginPWD.equals(customer.getPass()) + " < - is pwd correct?");
					page = "/Location.jsp";
					userID = customer.getUserId();
					session.setAttribute("userID", userID);
					session.setAttribute("userOBJ", customer);
					List<Menu> printList = new ArrayList<Menu>(); //creates an arrayList of menu items
					MenuBO menubo = new MenuBO(); //creates menuBO which communicates with back-end DAO to return a list for us
					printList = menubo.getItemList();
					session.setAttribute("menuList", printList);
					LocationsBO getLocation = new LocationsBO(); 
					List<Locations> locationList = getLocation.AllLocations();
					session.setAttribute("locationList", locationList);
				}
				else {
					request.setAttribute("message", "Incorrect email/password. Register if you do not have an account");
					page = "/login.jsp"; //if user doesn't exist, take him back to the login
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
