import java.sql.*;

//Class for individual query statements
public class RQ {
	
	//instantiate a new result set for the return statements
	static ResultSet rs = null;
	
	
	public static ResultSet SelectTitle(String search) {
		
	      //Create a statement and execute a query
		  Statement stmt = null;
	      System.out.println("Creating statement...");
	      try {
	      stmt = Database.conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM movies WHERE title like \"%" + search + "%\"";
	      rs = stmt.executeQuery(sql);
	     
	      //Clean-up environment
	      rs.close();
	      stmt.close();
	      
	      
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }
			return rs;
	       }
	
	public static ResultSet SelectGenre(String search) {
		  
		  //Create a statement and execute a query
		  Statement stmt = null;
	      System.out.println("Creating statement...");
	      try {
	      stmt = Database.conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM movies WHERE genre like \"%" + search + "%\"";
	      rs = stmt.executeQuery(sql);
	      //Clean-up environment
	      rs.close();
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }
			return rs;
			
	}
	
	public static ResultSet SelectActor(String search) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      System.out.println("Creating statement...");
	      try {
	      stmt = Database.conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM movies WHERE lead_role like \"%" + search + "%\"";
	      rs = stmt.executeQuery(sql);
	      //Clean-up environment
	      rs.close();
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }
			return rs;
		
	}
	public static void RemoveMovie(String title) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      System.out.println("Creating statement...");
	      try {
	      stmt = Database.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM movies WHERE movie = " + "\"" + title + "\"";
	      stmt.executeQuery(sql);
	      //Clean-up environment
	      rs.close();
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
	}
	public static void RemoveUser(String user_id) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      System.out.println("Creating statement...");
	      try {
	      stmt = Database.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM cust WHERE  C_ID = " + "\"" + user_id + "\"";
	      stmt.executeQuery(sql);
	      //Clean-up environment
	      rs.close();
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
	}
	
	public static void AddUser(int C_ID, String c_first, String c_last, String phone_num, String email,String password) {

	      try {
	    	  String sql = "INSERT INTO cust VALUES(" + C_ID + ", \'" + c_first + "\', " + "\'" + c_last + "\', " +  "\'" + phone_num + "\', " + "\'" + email +"\', " + "\'" + password + "\')";	      	      
	    	  Statement stmt = Database.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}

		
	}
}
//End class


