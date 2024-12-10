package pack;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 HttpSession hs=req.getSession();
    	 hs.setAttribute("isLoggedIn", false);
    	 hs.invalidate();
    	 RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
    	 rd.forward(req, resp);
    }
}
