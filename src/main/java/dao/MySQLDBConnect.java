package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnect 
{
  public static Connection getMySQLConnection()
  {
	Connection mysqlconnectionobj = null;  
	try 
	{
	   //STEP 1 LOAD DRIVER CLASS
	   Class.forName("com.mysql.cj.jdbc.Driver");
				
	  //STEP 2 ESTABLISH CONNECTION FROM JAVA Prog TO Database
	   mysqlconnectionobj = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/edubridge_fullstack","root","abc123");
		   
	   System.out.println("DATABASE CONNECTION WITH MYSQL SUCCESS.....");
		   
	}catch (ClassNotFoundException e) {e.printStackTrace();}
	 catch (SQLException e) { e.printStackTrace();}
	
	 return mysqlconnectionobj;
   }   
}
