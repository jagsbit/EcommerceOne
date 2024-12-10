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
@WebServlet("/register")
public class Register extends HttpServlet {
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String name=req.getParameter("name");
	 String email=req.getParameter("email");
	 String pass=req.getParameter("pass1");
	 String confpass=req.getParameter("pass2");
	 PrintWriter out=resp.getWriter();
	 if(pass.equals(confpass)==false) {
		 resp.setContentType("text/html");
		 out.println("<h3 style='color:red'>Password Not Matching</h3>");
		 RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
		 rd.include(req, resp);
		 return;
		 
	 }
	 String query="insert into users(name,email,password) values(?,?,?)";
	
	 
	 try {
		 Connection con=DBConnection.getConnection();
		 PreparedStatement st=con.prepareStatement(query);
		 st.setString(1, name);
		 st.setString(2, email);
		 st.setString(3,pass);
		 int cnt=st.executeUpdate();
		 if(cnt>0) {
			 
			 RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			 rd.forward(req, resp);
		 }
		 else {
			 resp.setContentType("text/html");
			 out.println("<h3 style='color:red'>User Not Registered Succesfully</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
			 rd.include(req, resp);
			 
		 }
		 
		 
		 
	 }
	  catch (Exception e) {
		  resp.setContentType("text/html");
			 out.println("<h3 style='color:red'> Exception Occured"+e.getMessage()+"</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
			 rd.include(req, resp);
	}
}
}
