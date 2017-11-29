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
}//End class


