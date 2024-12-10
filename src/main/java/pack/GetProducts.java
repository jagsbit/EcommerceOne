package pack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetProducts {
	 
	 public static ArrayList<Products> getProducts(){
		 ArrayList<Products> products=new ArrayList<Products>();
		 String query="select * from product";
		  try {
			  Connection con=DBConnection.getConnection();
			  Statement st=con.createStatement();
			  ResultSet rs=st.executeQuery(query);
			  while(rs.next()) {
				  int id=rs.getInt("id");
				  String name=rs.getString("name");
				  double price=rs.getDouble("price");
				  String category=rs.getString("category");
				  String img=rs.getString("img");
				  Products p=new Products(id,name,price,category,img);
				  products.add(p);
			  }
			  System.out.print("fetched");
			
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		 return products;
	 }
	 
}
