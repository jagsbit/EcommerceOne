package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addOrder")
public class AddOrder extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 HttpSession hs=req.getSession();
	 Order o=(Order) hs.getAttribute("single_order");
	 int product_id=o.getId();
     int user_id=o.getUser_id();
     int quantiy=o.getQuntity();
     LocalDate currentDate=LocalDate.now();
     String orderDate = currentDate.toString(); 
     String address=req.getParameter("address");
     String query="insert into orders(product_id,user_id,quantity,address,order_date) values(?,?,?,?,?)";
     PrintWriter out=resp.getWriter();
     hs.removeAttribute("single_order");
     try {
    	 Connection con=DBConnection.getConnection();
    	 PreparedStatement st=con.prepareStatement(query);
    	 st.setInt(1, product_id);
    	 st.setInt(2, user_id);
    	 st.setInt(3, quantiy);
    	 st.setString(4,address);
    	 st.setString(5, orderDate);
    	 int count=st.executeUpdate();
    	 if(count>0) {
    		 
    		 RequestDispatcher rd=req.getRequestDispatcher("/orderSuccess.jsp");
    		 rd.include(req, resp);
    		 
    	 }
    	 else {
    		 resp.setContentType("text/html");
    		 out.println("order not placed");
    		 RequestDispatcher rd=req.getRequestDispatcher("/BuyNow.jsp");
    		 rd.include(req, resp);
    	 }
		
	} catch (Exception e) {
		resp.setContentType("text/html");
		 out.println("excetion occured");
		 RequestDispatcher rd=req.getRequestDispatcher("/BuyNow.jsp");
		 rd.include(req, resp);
	}
}
}
