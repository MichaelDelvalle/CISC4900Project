package restaurant.delivery.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.delivery.models.Menu;

@WebServlet("/confirm")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		double total = 0;
		if(session.getAttribute("orderTotal") != null)
			total = (Double) session.getAttribute("orderTotal");
			System.out.println("The total for this purchase is: " + total);
		if ("updateCart".equals(action)) {
			int found = 0;
			if(session.getAttribute("orderTotal") != null)
			total = (Double)session.getAttribute("orderTotal");
			System.out.println("The total for this purchase is: " + total);
			System.out.println("DEBUG:..submit detected..looking for what item user wants to remove");
			if (request.getParameter("itemnumber") != null)
			found = Integer.parseInt(request.getParameter("itemnumber"));
			System.out.println("User wants to remove item"+found+" - is this correct? lets hope so because its gone...");
			List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
			List<Menu> printList = (List<Menu>)session.getAttribute("menuList");
			if (currentOrder == null || printList == null) {
				request.setAttribute("message", "Something went wrong...Please sign in again.");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
				for(Menu m: printList) {
				if (currentOrder.get(found-1).equals(m.getItem_name())) {
					total -= m.getCost();
					break;
				}
			}
			currentOrder.remove(found-1);
			session.setAttribute("ItemList", currentOrder);
			session.setAttribute("orderTotal", total);
			System.out.println("Updating cart...The new total is: "+total);
		}

		RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		double total = 0;
		if(session.getAttribute("orderTotal") != null)
			total = (Double) session.getAttribute("orderTotal");
			System.out.println("The total for this purchase is: " + total);
		if ("updateCart".equals(action)) {
			int found = 0;
			if(session.getAttribute("orderTotal") != null)
			total = (Double)session.getAttribute("orderTotal");
			System.out.println("The total for this purchase is: " + total);
			System.out.println("DEBUG:..submit detected..looking for what item user wants to remove");
			if (request.getParameter("itemnumber") != null)
			found = Integer.parseInt(request.getParameter("itemnumber"));
			System.out.println("User wants to remove item"+found+" - is this correct? lets hope so because its gone...");
			List<String> currentOrder = (List<String>)session.getAttribute("ItemList");
			List<Menu> printList = (List<Menu>)session.getAttribute("menuList");
			if (currentOrder == null || printList == null) {
				request.setAttribute("message", "Something went wrong...Please sign in again.");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
				for(Menu m: printList) {
				if (currentOrder.get(found-1).equals(m.getItem_name())) {
					total -= m.getCost();
					break;
				}
			}
			currentOrder.remove(found-1);
			session.setAttribute("ItemList", currentOrder);
			session.setAttribute("orderTotal", total);
			System.out.println("Updating cart...The new total is: "+total);
		}

		RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
		rd.forward(request, response);
	}
}
