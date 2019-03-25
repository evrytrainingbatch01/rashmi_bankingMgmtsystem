package com.evryindia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertIntoCustomer {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException ex) {

			ex.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evrybank","root","root");

			String sql = "INSERT INTO customer (id,firstName, lastName, city,  mobileNumber,emailId,password, countryId)"
					+ " VALUES (?, ?, ?, ?,?, ?, ?, ?)";

			statement =  conn.prepareStatement(sql);
			
			statement.setInt(1, 8);
			statement.setString(2, "Srinivas");
			statement.setString(3, "Gates");
			statement.setString(4, "America");
			
			statement.setString(5, "98-35306629");
			statement.setString(6, "bill.gates@microsoft.com");
		
			statement.setString(7, "bill@1234");
			statement.setInt(8, 1);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		finally{

			if(statement != null){

				try {

					statement.close();
					statement = null;
				}
				catch (SQLException ex) {

					ex.printStackTrace();
				}
			}

			if(conn != null){

				try 
				{
					conn.close();
					conn = null;
				}
				catch (SQLException ex) {

					ex.printStackTrace();
				}
			}
		}
	}
}