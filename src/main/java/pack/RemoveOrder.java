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
@WebServlet("/removeOrder")
public class RemoveOrder extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int order_id = Integer.parseInt(req.getParameter("order_id"));
			String query = "delete from orders where id=(?)";
	        PrintWriter out=resp.getWriter();
			try {
				Connection con=DBConnection.getConnection();
				PreparedStatement st=con.prepareStatement(query);
				st.setInt(1, order_id);
				int count=st.executeUpdate();
				if(count>0) {
					RequestDispatcher rd=req.getRequestDispatcher("/orders.jsp");
					rd.forward(req, resp);
				}
				else {
					resp.setContentType("text/html");
					 out.println("<h3 style='color:red'>some error occured</h3>"+order_id+"**"+count);
					 RequestDispatcher rd=req.getRequestDispatcher("/orders.jsp");
					 rd.include(req, resp);
					
				}

			} catch (Exception e) {
				 resp.setContentType("text/html");
				 out.println("<h3 style='color:red'> Exception Occured"+e.getMessage()+"</h3>");
				 RequestDispatcher rd=req.getRequestDispatcher("/orders.jsp");
				 rd.include(req, resp);

			}
	}
}
