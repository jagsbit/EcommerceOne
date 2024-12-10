package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 String email=req.getParameter("email");
    	 String pass=req.getParameter("pass");
    	 String query="select * from users where email=(?) and password=(?)";
    	 PrintWriter out=resp.getWriter();
    	 try {
    		 Connection con=DBConnection.getConnection();
    		 PreparedStatement st=con.prepareStatement(query);
    		 st.setString(1,email);
    		 st.setString(2,pass);
    		 ResultSet rs=st.executeQuery();
    		 if(rs.next()) {
    			 HttpSession hs=req.getSession();
    			 hs.setAttribute("name_key", rs.getString("name"));
    			 hs.setAttribute("email_key", rs.getString("email"));
    			 hs.setAttribute("user_id", rs.getInt("id"));
    			 hs.setAttribute("isLoggedIn", true);
    			 RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
    			 rd.forward(req, resp);
    		 }
    		 else {
    			 resp.setContentType("text/html");
    			 out.println("<h3 style='color:red'>Wrong username or password</h3>");
    			 RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
    			 rd.include(req, resp);
    			 
    		 }
    		 
    		 
			
		} catch (Exception e) {
			 resp.setContentType("text/html");
			 out.println("<h3 style='color:red'> Exception Occured"+e.getMessage()+"</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			 rd.include(req, resp);
			 
		}
    }
}
