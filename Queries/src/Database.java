import java.sql.*;

public class Database {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://webdev.cislabs.uncw.edu:3306/klk8027";

   //  Database credentials
   static final String USER = "klk8027";
   static final String PASS = "ONArfYtFw";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM movies ORDER BY title";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
    	  	 String title = rs.getString("title");
         String genre = rs.getString("genre");
         String lead = rs.getString("lead_role");
         String director = rs.getString("director");
         int year = rs.getInt("year");
         int qty = rs.getInt("qty");
         String rating = rs.getString("mpaa_rating");

         //Display values
         System.out.print("Title "+title);
         System.out.print(", Genre "+genre);
         System.out.print(", Lead Role "+lead);
         System.out.println(", Director "+director);
         System.out.println(", Year "+year);
         System.out.println(", Quantity "+qty);
         System.out.println(", Rating "+rating);
         
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end class
