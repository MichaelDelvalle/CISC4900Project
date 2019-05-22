package restaurant.delivery.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //fill code here.
        HttpSession session = req.getSession();
        String page = "login.jsp";
        session.invalidate();
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, resp);
    }

}
