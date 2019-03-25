package com.evryindia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDao
{
	public static int insertIntoDb(String firstName,String lastName, String city, int countryId, String mobileNumber,
			String emailId, int userTypeId, String password){
		
//		String sql = "insert into customer values('"+firstName+"','"+lastName+"', '"+city+"','"+countryId+"','"mobileNumber"'+'"emailId"'+)";
		String sql = "insert into customer values('"+firstName+" , '"+lastName+"', '"+city+"', 1, '"+mobileNumber+"' , '"+emailId+"' , userTypeId, '"+password+"')";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException ex) {
			
			ex.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		int i = 0;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			stmt = con.createStatement();
			i = stmt.executeUpdate(sql);
		} 
		catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		finally{
			
			if(stmt != null){
				
				try {
					
					stmt.close();
					stmt = null;
				}
				catch (SQLException ex) {
				
					ex.printStackTrace();
				}
			}
			
			if(con != null){
				
				try {
					
					
					con.close();
					con = null;
				}
				catch (SQLException ex) {
				
					ex.printStackTrace();
				}
			}
		}
		return i;
	}
	
	public static int insertIntoDb(String s1, String s2, Connection con)
	{
		String sql= "insert into customer values('"+s1+"','"+s2+"')";
		Statement stmt= null;
		int i=0;
		try
		{
			stmt= con.createStatement();
			i= stmt.executeUpdate(sql);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
				{
					stmt.close();
					stmt=null;
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		return i;
	}
}