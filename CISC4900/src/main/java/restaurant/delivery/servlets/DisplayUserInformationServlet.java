package restaurant.delivery.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.delivery.bo.RegistersBO;
import restaurant.delivery.models.Registers;

/**
 * Servlet implementation class DisplayUserInformationServlet
 */
@WebServlet("/userinfo")
public class DisplayUserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("userinfo.jsp");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if ("updateUser".equals(action)) {
			if(request.getParameter("password").equals(request.getParameter("passwordconfirm"))) {
			RegistersBO update = new RegistersBO();
			Registers user = (Registers)session.getAttribute("userOBJ");
			user.setFname(request.getParameter("fname"));
			user.setLname(request.getParameter("lname"));
			user.setPass(request.getParameter("password"));
			user.setGender(request.getParameter("gender"));
			user.setAddress(request.getParameter("address"));
			user.setPhone(request.getParameter("phonenumber"));
			user.setEmail(request.getParameter("email"));
			try {
				update.updateUser(user);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("userupdatemessage", "Your information has been updated successfully.");
		}
			else {
				session.setAttribute("userupdatemessage", "Your passwords do not match. Please re-enter.");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("userinfo.jsp");
		rd.forward(request,response);
	}

}
