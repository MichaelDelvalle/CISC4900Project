package restaurant.delivery.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.delivery.bo.Order_DetailsBO;
import restaurant.delivery.bo.OrdersBO;
import restaurant.delivery.dao.Order_DetailsDAO;
import restaurant.delivery.models.Menu;
import restaurant.delivery.models.Order_Details;
import restaurant.delivery.models.Orders;

@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (session.getAttribute("userID") == null) {
			request.setAttribute("message", "Something went wrong...please login again..");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
	}
			RequestDispatcher rd = request.getRequestDispatcher("paymentpage.jsp");
			rd.forward(request, response);
		
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		Date date = null;
		if ("processOrder".equals(action)) {
			String ccnumber = request.getParameter("ccnumber");
			String securenumber = request.getParameter("securenumber");
			String zipcode = request.getParameter("zipcode");
//			System.out.println("Received the following: ");
//			System.out.println(ccnumber);
//			System.out.println(securenumber);
//			System.out.println(zipcode);
			if (session.getAttribute("ItemList") != null) {
				int orderID = 0;
				date = new Date();
				OrdersBO bo = new OrdersBO();
				Orders order = new Orders();
				order.setUser_Id((int)session.getAttribute("userID"));
				order.setOrder_date(date);
				order.setLocation_id((int)session.getAttribute("locationID"));
				order.setTotal_amount((double)session.getAttribute("orderTotal"));
				try {
					orderID = bo.updateOrders(order);
					List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
					List<Menu> printList = (List<Menu>)session.getAttribute("menuList");
				for(String x: currentOrder) {
					for(Menu m: printList) {
						if(x.equals(m.getItem_name())) {
						Order_DetailsBO submit = new Order_DetailsBO(); //implemet BO for updating 
						Order_Details detailsm = new Order_Details();
						
						detailsm.setOrder_id(orderID);
						detailsm.setUser_id((int)session.getAttribute("userID"));
						detailsm.setItem_id(m.getItem_id());
						detailsm.setLocation_id((int)session.getAttribute("locationID"));
						submit.saveOrderDetails(detailsm);
					}
				} 
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	  }
				RequestDispatcher rd = request.getRequestDispatcher("receipt.jsp");
				rd.forward(request, response);
     }
   }
}