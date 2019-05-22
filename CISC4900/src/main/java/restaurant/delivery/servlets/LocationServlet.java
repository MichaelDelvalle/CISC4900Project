package restaurant.delivery.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int ID = 0;
		HttpSession session = request.getSession();
			if ("selectLocation".equals(action)) {
				if (session.getAttribute("locationID") == null) {
					ID = Integer.parseInt(request.getParameter("location"));
					session.setAttribute("locationID", ID);
				}
				System.out.println("LocationID HAS BEEN SET TO:" + session.getAttribute("locationID"));
				RequestDispatcher rd = request.getRequestDispatcher("/Menu.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Location.jsp");
				rd.forward(request, response);
			}
		
	}

}
