package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import java.util.ArrayList;

 

public class GetCarts  {
	     
		public static ArrayList<Carts> getCarts(int user_id){
			ArrayList<Carts> carts=new ArrayList<Carts>();
			String query="SELECT cart.id,cart.user_id,cart.product_id,cart.quantity,product.name,product.category,product.price FROM cart JOIN product ON cart.product_id=product.id WHERE cart.user_id=(?) ";
		    try {
		    	 Connection con=DBConnection.getConnection();
				  PreparedStatement st=con.prepareStatement(query);
				  st.setInt(1, user_id);
				  ResultSet rs=st.executeQuery();
				   
				   
				 
				  while(rs.next()) {
					   user_id=rs.getInt("user_id");
					  int cart_id=rs.getInt("id");
					  int product_id=rs.getInt("product_id");
					  int quantity=rs.getInt("quantity");
					  String name=rs.getString("name");
					  String category=rs.getString("category");
					  double price=rs.getDouble("price");
					  Carts c=new Carts(cart_id,user_id,quantity);
					  c.setId(product_id);
					  c.setName(name);
					  c.setCategory(category);
					  c.setPrice(price);
					 
					  carts.add(c);
				  }
				
			} catch (Exception e) {
				 System.out.println(e.getMessage());
			}
			return carts;
		}
}
