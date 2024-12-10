package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetOrders {
	 
		public static ArrayList<Order> getOrder(int user_id){
			ArrayList<Order> orders=new ArrayList<Order>();
			String query="SELECT orders.id,orders.user_id,orders.product_id,orders.quantity,product.name,product.category,product.price FROM orders JOIN product ON orders.product_id=product.id WHERE orders.user_id=(?) ";
		    try {
		    	 Connection con=DBConnection.getConnection();
				  PreparedStatement st=con.prepareStatement(query);
				  st.setInt(1, user_id);
				  ResultSet rs=st.executeQuery();
				   
				   
				 
				  while(rs.next()) {
					   user_id=rs.getInt("user_id");
					  int order_id=rs.getInt("id");
					  int product_id=rs.getInt("product_id");
					  int quantity=rs.getInt("quantity");
					  String name=rs.getString("name");
					  String category=rs.getString("category");
					  double price=rs.getDouble("price");
					  Order o=new Order();
					  o.setId(product_id);
					  o.setName(name);
					  o.setCategory(category);
					  o.setPrice(price);
					  o.setOrder_id(order_id);
					  o.setQuntity(quantity);
					  o.setUser_id(user_id);
					  orders.add(o);
				  }
				
			} catch (Exception e) {
				 System.out.println(e.getMessage());
			}
			return orders;
		}
		 
}



