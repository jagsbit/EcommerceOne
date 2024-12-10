package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/AddToCartServlet")
public class AddToCart extends HttpServlet {
   @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 HttpSession session=req.getSession();
	 Boolean isLoggedin=(Boolean) session.getAttribute("isLoggedIn");
	 PrintWriter out=res.getWriter();
	 int product_id=Integer.parseInt(req.getParameter("product_id"));
	
	 String query="insert into cart(product_id,user_id,quantity)values(?,?,?)";
	 if(isLoggedin!=null) {
		 int user_id=(Integer)session.getAttribute("user_id");
		  try {
			 Connection con=DBConnection.getConnection();
			 PreparedStatement st=con.prepareStatement(query);
			 st.setInt(1, product_id);
			 st.setInt(2,user_id);
			 st.setInt(3,1);
			 int cnt=st.executeUpdate();
			 if(cnt>0) {
				 
				  RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
				  rd.include(req, res);
			 }
			 else {
				 res.setContentType("text/html");
				  out.println("<h3 style='color:red'>some error occured</h3>");
				  RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
				  rd.include(req, res);
			 }
		} catch (Exception e) {
			 res.setContentType("text/html");
			 out.println("<h3 style='color:red'> Exception Occured"+e.getMessage()+"</h3>"+user_id);
			 RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			 rd.include(req, res);
		}
	 }
	 else {
		  res.setContentType("text/html");
		  out.println("<h3 style='color:red'>You are not LoggedIn, Please Login first</h3>");
		  RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
		  rd.include(req, res);
	 }
}
}
