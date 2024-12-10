package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addOrderfromcart")
public class OrderFromCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        int user_id = (Integer) hs.getAttribute("user_id");
        String query1 = "SELECT * FROM cart WHERE user_id = ?";
        LocalDate currentDate = LocalDate.now();
        String orderDate = currentDate.toString();
        String address = req.getParameter("address");
        String query2 = "INSERT INTO orders(product_id, user_id, quantity, address, order_date) VALUES(?, ?, ?, ?, ?)";
        String query3="delete from cart where user_id=(?)";
        PrintWriter out = resp.getWriter();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement st1 = con.prepareStatement(query1);
            st1.setInt(1, user_id);
            ResultSet rs = st1.executeQuery();

            boolean orderPlaced = false; // Flag to check if any orders were successfully placed

            while (rs.next()) {
                PreparedStatement st2 = con.prepareStatement(query2);
                int product_id = rs.getInt("product_id");
                double quantity = rs.getDouble("quantity");
                st2.setInt(1, product_id);
                st2.setInt(2, user_id);
                st2.setDouble(3, quantity);
                st2.setString(4, address);
                st2.setString(5, orderDate);

                int count = st2.executeUpdate();
                if (count > 0) {
                    orderPlaced = true; // Update flag if at least one order is placed
                }
            }

            if (orderPlaced) {
            	PreparedStatement st3=con.prepareStatement(query3);
            	st3.setInt(1, user_id);
            	int count=st3.executeUpdate(); // order placed form the cart so remove all the entry from the cart
                RequestDispatcher rd = req.getRequestDispatcher("/orderSuccess.jsp");
                rd.forward(req, resp); // Render success page only once
            } else {
                resp.setContentType("text/html");
                out.println("No orders placed. Please try again.");
                RequestDispatcher rd = req.getRequestDispatcher("/cartCheckOut.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            resp.setContentType("text/html");
            out.println("Error: " + e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("/cartCheckOut.jsp");
            rd.include(req, resp);
        }
    }
}
