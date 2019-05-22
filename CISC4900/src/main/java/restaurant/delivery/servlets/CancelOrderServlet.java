package restaurant.delivery.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cancelorder")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("orderTotal") != null && session.getAttribute("ItemList") != null) {
		session.removeAttribute("orderTotal");
		session.removeAttribute("ItemList");
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}
		else {
			request.setAttribute("message", "Something went wrong...please login again..");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
 	}
}