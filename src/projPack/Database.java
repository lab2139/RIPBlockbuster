package projPack;
import java.sql.*;

/**
 * @author JustinSaunders
 * Class for Database constructor and connection object
 */
public class Database {
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://webdev.cislabs.uncw.edu:3306/klk8027";
   
   //  Database credentials
   static final String USER = "klk8027";
   static final String PASS = "ONArfYtFw";
   
   //creates a new Connection object
   public Connection conn = null;
   
   /**
    * Database constructor
    */
   public Database()
   {
	   try{
		   	Class.forName("com.mysql.jdbc.Driver");
		   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
   }

}//end class
