package com.evryindia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteFromCustomer {

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
				
				String sql = "DELETE FROM customer WHERE firstName=?";
				
				statement = conn.prepareStatement(sql);
				statement.setString(1, "bill");
				
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
					System.out.println("A user was deleted successfully!");
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		}
	}