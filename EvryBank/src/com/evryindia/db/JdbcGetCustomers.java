package com.evryindia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcGetCustomers {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException ex) {

			ex.printStackTrace();
		}
		Connection conn = null;
		Statement statement = null;
		
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evrybank","root","root");
			
			String sql = "SELECT * FROM customer";
			
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while (result.next()){
				String name = result.getString(2);
				String pass = result.getString(7);
				String fullname = result.getString("city");
				String email = result.getString("emailId");
				
				String output = "Customer Detail #%d: %s - %s - %s - %s";
				System.out.println(String.format(output, ++count, name, pass, fullname, email));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}