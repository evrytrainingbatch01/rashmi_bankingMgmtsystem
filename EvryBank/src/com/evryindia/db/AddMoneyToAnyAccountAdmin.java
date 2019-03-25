package com.evryindia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMoneyToAnyAccountAdmin {

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

			String sql = "INSERT INTO accountdetails (id,currentBalance)"
					+ " VALUES (?, ?)";

			statement =  conn.prepareStatement(sql);
			
			statement.setInt(1, 3);
			statement.setString(2, "26668844");
			
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A row inserted successfully!");
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

				try {


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