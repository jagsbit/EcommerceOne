package pack;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     HttpSession session=req.getSession();
		 Boolean isLoggedin=(Boolean) session.getAttribute("isLoggedIn");
		  PrintWriter out=resp.getWriter();
		 if(isLoggedin!=null) {
	   
		 int product_id=Integer.parseInt(req.getParameter("product_id"));
		 Order o=new Order();
		 HttpSession hs=req.getSession();
		 int user_id=(Integer)hs.getAttribute("user_id");
		 int qunatity=1;
		 o.setUser_id(user_id);
		 o.setId(product_id);
		 o.setQuntity(qunatity);
		 String query="select * from product where id=(?)";
		 try {
			 Connection con=DBConnection.getConnection();
			 PreparedStatement st=con.prepareStatement(query);
			 st.setInt(1, product_id);
			 ResultSet rs=st.executeQuery();
			 while(rs.next()) {
				 o.setName(rs.getString("name"));
				 o.setCategory(rs.getString("category"));
				 o.setPrice(rs.getDouble("price"));
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			 resp.setContentType("text/html");
			 out.println("<h3 style='color:red'> Exception Occured"+e.getMessage()+"</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			 rd.include(req, resp);
		}
		 hs.setAttribute("single_order", o);
		 
		 RequestDispatcher rd=req.getRequestDispatcher("/BuyNow.jsp");
		 rd.forward(req, resp);
		 }
		 else {
			 resp.setContentType("text/html");
			  out.println("<h3 style='color:red'>You are not LoggedIn, Please Login first</h3>");
			  RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			  rd.include(req, resp);
		 }
}
}
