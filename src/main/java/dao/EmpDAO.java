package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.EmpInfoModel;

public class EmpDAO 
{
	//INSERT RECORD INTO DATABASE
	public int addRecord(EmpInfoModel eobj)
	{
	  Connection mysqlconnectionobj = null;  
	  PreparedStatement pst = null;
	  ResultSet rs = null;
	  
	  int empid = -1;
	  
	  //boolean insertstatus = false;
		   
      try 
      {
		mysqlconnectionobj = MySQLDBConnect.getMySQLConnection();
			
		String sqlquery = "insert into emp1(name,email,password,salary,city) values(?,?,?,?,?)";
			   
		pst = mysqlconnectionobj.prepareStatement(sqlquery);
		pst.setString(1, eobj.getName());
		pst.setString(2, eobj.getEmail());
		pst.setString(3, eobj.getPassword());
		pst.setDouble(4, eobj.getSalary());
		pst.setString(5, eobj.getCity());
						   
		int replyfrondb = pst.executeUpdate();
		
		if (replyfrondb > 0)
		{
			pst = mysqlconnectionobj.prepareStatement("select * from emp1 where email = ?");
			pst.setString(1, eobj.getEmail());
			
		    rs = pst.executeQuery();	
			
		    rs.next();
		    empid = rs.getInt(1); 
		    
			//insertstatus = true;
		}
	  }catch (SQLException e) 
       {  
		  empid = -5;
		  e.printStackTrace();
	   }
       finally 
       {
    	 try 
    	 {
		   if (pst != null)
			 pst.close();
		   if (mysqlconnectionobj != null)
			 mysqlconnectionobj.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   }
	
      return empid;
      //return insertstatus;
	}
	
	public EmpInfoModel empLoginCheck(String uid, String pass)
	{
		Connection mysqlconnectionobj = null;  
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		EmpInfoModel empobj = null;
		
		try 
	    {
			mysqlconnectionobj = MySQLDBConnect.getMySQLConnection();
				
			String sqlquery = "select * from emp1 where email=? and password=?";
				   
			pst = mysqlconnectionobj.prepareStatement(sqlquery);
			pst.setString(1, uid);
			pst.setString(2, pass);
									   
			rs = pst.executeQuery();
					
			if (rs.next())
			{
				empobj = new EmpInfoModel();
				empobj.setEmpid(rs.getInt(1));
				empobj.setName(rs.getString(2));
				empobj.setEmail(rs.getString(3));
				empobj.setSalary(rs.getDouble(5));
				empobj.setCity(rs.getString(6));
			}
							   
		  }catch (SQLException e) { e.printStackTrace();}
	       finally 
	       {
	    	 try 
	    	 {
			   if (pst != null)
				 pst.close();
			   if (rs != null)
				 rs.close();
			   if (mysqlconnectionobj != null)
				 mysqlconnectionobj.close();
			 } catch (SQLException e) {e.printStackTrace();}
		   }
		
	   return empobj;
	}
	
	public ArrayList<EmpInfoModel> viewAllRecord()
	{
	  Connection mysqlconnectionobj = null;  
	  PreparedStatement pst = null;
	  ResultSet rs = null;
	  
	  ArrayList<EmpInfoModel> allemplist = new ArrayList<EmpInfoModel>();
	  
	  try 
      {
		mysqlconnectionobj = MySQLDBConnect.getMySQLConnection();
			
		String sqlquery = "select * from emp1";
			   
		pst = mysqlconnectionobj.prepareStatement(sqlquery);
								   
		rs = pst.executeQuery();
		
		while (rs.next())
		{
			EmpInfoModel empobj = new EmpInfoModel();
			
			empobj.setEmpid(rs.getInt(1));
			empobj.setName(rs.getString(2));
			empobj.setEmail(rs.getString(3));
			empobj.setSalary(rs.getDouble(5));
			empobj.setCity(rs.getString(6));
			
			//ADD OBJ TO ARRAYLIST
			allemplist.add(empobj);
		}
		
		if (allemplist.size()==0)
			allemplist = null;
					   
	  }catch (SQLException e) { e.printStackTrace();}
       finally 
       {
    	 try 
    	 {
		   if (pst != null)
			 pst.close();
		   if (rs != null)
			 rs.close();
		   if (mysqlconnectionobj != null)
			 mysqlconnectionobj.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   }
	
      return allemplist;
	}
	
	public boolean deletedRecord(String email)
	{
	  Connection mysqlconnectionobj = null;  
	  PreparedStatement pst = null;
	  
	  boolean deletestatus = false;
		   
      try 
      {
		mysqlconnectionobj = MySQLDBConnect.getMySQLConnection();
			
		String sqlquery = "delete from emp1 where email=?";
			   
		pst = mysqlconnectionobj.prepareStatement(sqlquery);
		pst.setString(1, email);
								   
		int replyfrondb = pst.executeUpdate();
		
		if (replyfrondb > 0)
			deletestatus = true;
			   
	  }catch (SQLException e) { e.printStackTrace();}
       finally 
       {
    	 try 
    	 {
		   if (pst != null)
			 pst.close();
		   if (mysqlconnectionobj != null)
			 mysqlconnectionobj.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   }
	
      return deletestatus;
	}
	
	
	public boolean updateRecord(EmpInfoModel eobj)
	{
	  Connection mysqlconnectionobj = null;  
	  PreparedStatement pst = null;
	  	  
	  boolean updatestatus = false;
		   
      try 
      {
		mysqlconnectionobj = MySQLDBConnect.getMySQLConnection();
			
		String sqlquery = "update emp1 set password=?,salary=?,city=? where email = ?";
			   
		pst = mysqlconnectionobj.prepareStatement(sqlquery);
		pst.setString(1, eobj.getPassword());
		pst.setDouble(2, eobj.getSalary());
		pst.setString(3, eobj.getCity());
		pst.setString(4, eobj.getEmail());
								   
		int replyfrondb = pst.executeUpdate();
		
		if (replyfrondb > 0)
		{
			updatestatus = true;
		}
	  }catch (SQLException e) { e.printStackTrace(); }
       finally 
       {
    	 try 
    	 {
		   if (pst != null)
			 pst.close();
		   if (mysqlconnectionobj != null)
			 mysqlconnectionobj.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   }
	
      return updatestatus;
	}

}
