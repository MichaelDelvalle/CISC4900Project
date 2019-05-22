package restaurant.delivery.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.delivery.bo.MenuBO;
import restaurant.delivery.bo.Order_DetailsBO;
import restaurant.delivery.bo.OrdersBO;
import restaurant.delivery.dao.Order_DetailsDAO;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Orders;

@WebServlet("/OrderProcessingServlet")
public class OrderProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderProcessingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/*
	 * way to improve disgusting itemID order line being added:
	 * add a "else" to record actions that saves the action from a given URL (when you click on burger, it appends burger to action "action=burger")
	 * when button is clicked, create new form tags in a for loop inside the menu JSP page that is dynamic in a for loop in the menu, that way, this can save a list of items.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> currentOrder = null;
		int count = 0;
		HttpSession session=request.getSession();
		String action = request.getParameter("action");
		System.out.println(action + " was selected to be added to customers order!...adding now...");
		MenuBO menubo = new MenuBO();
			//if ("addItem".equals(action)) {
		if(action != null) {
			if(session.getAttribute("ItemList") == null) {
				List<String> temp = new ArrayList<String>();
				session.setAttribute("ItemList", temp);
			
			}
				if(session.getAttribute("ItemList") != null) {
					double total = 0;
					currentOrder = (List<String>)session.getAttribute("ItemList");
					currentOrder.add(action);
					session.setAttribute("ItemList", currentOrder);
					List<Menu> printList = (List<Menu>)session.getAttribute("menuList");
					for(String x: currentOrder) {
						for(Menu m: printList) {
						if (x.equals(m.getItem_name())) {
							total += m.getCost();
						}
					}
				}
					session.setAttribute("orderTotal", total);
			}
				else if(session.getAttribute("ItemList") == null) {
					currentOrder = new ArrayList<String>();
					currentOrder.add(action);
					session.setAttribute("ItemList", currentOrder);
	
				}
				
				System.out.println("Current item list:");
				for(String x: (List<String>)session.getAttribute("ItemList")) {
					System.out.print(x + ", ");
				}
				System.out.println("\n"+"$"+session.getAttribute("orderTotal") + " is the customers new total");
				
				

			
/*			else if ("processOrder".equals(action)) {
				if (session.getAttribute("itemList") != null) {
					int orderID = 0;
					OrdersBO bo = new OrdersBO();
					Orders order = new Orders();
					order.setUser_Id((int)session.getAttribute("userID"));
					order.setOrder_date(new Date());
					order.setLocation_id((int)session.getAttribute("locationID"));
					order.setTotal_amount(30.0);
					try {
						orderID = bo.updateOrders(order);
						List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
						for (int i = 0; i < currentOrder.size(); i++) {
							Order_DetailsBO detailsbo = new Order_DetailsBO(); implemet BO for updating 
							Order_Details detailsm = new Order_Details();
							Order_DetailsDAO submit = new Order_DetailsDAO();
							detailsm.setOrder_id(orderID);
							detailsm.setUser_id((Integer)session.getAttribute("userID"));
							detailsm.setItem_id(Integer.parseInt(currentOrder.get(i)));
							detailsm.setLocation_id((int)session.getAttribute("locationID"));
							submit.saveOrder(detailsm);
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}*/
				
		}	
		RequestDispatcher rd = request.getRequestDispatcher("/Menu.jsp");
		rd.forward(request, response);
	}
}
