package pack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 static String url="jdbc:mysql://localhost:3306/ecommerceone";
	 static String user="root";
	 static String pass="9937@Jitu";
   public static Connection con=null;
  
   public static Connection getConnection() throws Exception{
	   if(con==null) {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection(url,user,pass);
		   System.out.println("connected");
	   }
	   return con;
   }
}
