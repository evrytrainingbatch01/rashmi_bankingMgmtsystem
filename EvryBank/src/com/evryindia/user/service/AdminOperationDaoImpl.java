/**
 * 
 */
package com.evryindia.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evryindia.user.dao.AdminOperationDao;
import com.evryindia.foundation.domain.AccountDetails;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.util.DbUtil;
import com.mysql.cj.util.StringUtils;

/**
 * @author rashmi.kiran
 *
 */
public class AdminOperationDaoImpl implements AdminOperationDao {
	String CLASS_NAME =  this.getClass().getName();

	@Override
	public void addCustomer(Customer c) throws SQLException {
			String METHOD_NAME = CLASS_NAME+".addCustomer():";
			System.out.println(METHOD_NAME + "*******Starting ****");
			System.out.println(METHOD_NAME + "input : " + c);
			
			Connection conn = null;
			PreparedStatement statement = null;
			
			try {

				conn = DbUtil.getConnection();

				String sql = "INSERT INTO customer (customerId,firstName, lastName, city,  mobileNumber,emailId,password, countryId,userTypeId)"
						+ " VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";

				statement =  conn.prepareStatement(sql);
				
				statement.setString(1, c.getCustomerId());
				statement.setString(2, c.getFirstName());
				statement.setString(3, c.getLastName());
				statement.setString(4, c.getCity());
				statement.setString(5, c.getMobileNumber());
				statement.setString(6, c.getEmailId());
				statement.setString(7, c.getPassword());
				statement.setInt(8, c.getCountry().getId());
				statement.setInt(9, c.getUserType().getId());

				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted successfully!");
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}

			finally{
				DbUtil.closeAll(null, statement, conn);
			}
			
			
			
			System.out.println(METHOD_NAME + "*******Completed ****");

	}
	public void createAccount(Customer c) throws SQLException
	{
		String METHOD_NAME = CLASS_NAME+".createAccount():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + c);
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {

			conn = DbUtil.getConnection();

			String sql = "INSERT INTO accountdetails (customerId,accountNumber,accountOpeningDate, currentBalance,  unclearedAmount,amountOnHold,interestAcruedTillDate,accountTypeId)"
					+ " VALUES (?, ?, ?, ?,?, ?, ?,?)";

			statement =  conn.prepareStatement(sql);
			
			statement.setString(1, c.getCustomerId());
			statement.setString(2, c.getCustomerId());// TODO as of now same as customerid
			statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));			
			statement.setString(4, "0");
			statement.setString(5, "0");
			statement.setString(6, "0");
			statement.setString(7, "0");
			statement.setInt(8, 1);

			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
		
		System.out.println(METHOD_NAME + "*******Completed ****");

	}
	@Override
	public void deleteAccount(Customer c) throws SQLException {
		String METHOD_NAME = CLASS_NAME+".deleteAccount():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + c);
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			//String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE ID = ?" ;
			String sql = "DELETE FROM accountdetails WHERE customerId = ?";
			statement =  conn.prepareStatement(sql);
			statement.setString(1, c.getCustomerId());

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A new user was deleted successfully!");
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
		System.out.println(METHOD_NAME + "*******Completed ****");

	}
	@Override
	public void deleteCustomer(Customer c) throws SQLException {
		String METHOD_NAME = CLASS_NAME+".deleteCustomer():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + c);
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			//String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE ID = ?" ;
			String sql = "DELETE FROM CUSTOMER WHERE customerId = ?";
			statement =  conn.prepareStatement(sql);
			statement.setString(1, c.getCustomerId());

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A new user was deleted successfully!");
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
		System.out.println(METHOD_NAME + "*******Completed ****");

	}


	@Override
	public Customer viewCustomersDetails(String custId) throws SQLException {

		String METHOD_NAME = CLASS_NAME+".viewCustomersDetails():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + custId);

		Customer c = null;
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT ID,customerId,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE customerId = ?" ;
			statement =  conn.prepareStatement(sql);
			statement.setString(1, custId);


			ResultSet rs = statement.executeQuery();
				while (rs.next()){
					c = new Customer();

					int ID= rs.getInt("ID");
					String customerId = rs.getString("customerId");
					String FIRSTNAME= rs.getString("FIRSTNAME");
					String LASTNAME= rs.getString("LASTNAME");
					String CITY= rs.getString("CITY");
					int COUNTRYID= rs.getInt("COUNTRYID");
					String COUNTRYNAME= rs.getString("COUNTRYNAME");
					String MOBILENUMBER= rs.getString("MOBILENUMBER");
					String EMAILID= rs.getString("EMAILID");
					
					c.setId(ID);
					c.setCustomerId(customerId);
					c.setFirstName(FIRSTNAME);
					c.setLastName(LASTNAME);
					c.setCity(CITY);
					Country co = new Country(COUNTRYID,COUNTRYNAME);
					c.setCountry(co);
					c.setMobileNumber(MOBILENUMBER);
					c.setEmailId(EMAILID);
					c.setAccountDetails(viewAccountDetails(custId));
				}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
		System.out.println(METHOD_NAME + "*******Completed ****");

		return c;
	}

	public AccountDetails viewAccountDetails(String custId) throws SQLException
	{
		String METHOD_NAME = CLASS_NAME+".viewAccountDetails():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + custId);
		
		
		AccountDetails acd = null;
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT CUSTOMERID,accountNumber,accountTypeId,(select name from accounttype where id = accountTypeId) accountTypeName,accountOpeningDate,currentBalance,unclearedAmount,amountOnHold,interestAcruedTillDate FROM ACCOUNTDETAILS WHERE CUSTOMERID = ?" ;
			statement =  conn.prepareStatement(sql);
			statement.setString(1, custId);
			System.out.println(METHOD_NAME + "input sql: " + sql);


			ResultSet rs = statement.executeQuery();
				while (rs.next()){
					acd = new AccountDetails();

					
					String customerId = rs.getString("customerId");
					String accountNumber = rs.getString("accountNumber");
					int accountTypeId = rs.getInt("accountTypeId");
					String accountTypeName  = rs.getString("accountTypeName");
					java.sql.Date accountOpeningDate = rs.getDate("accountOpeningDate");
					
					String currentBalance = rs.getString("currentBalance");
					String unclearedAmount = rs.getString("unclearedAmount");
					String amountOnHold = rs.getString("amountOnHold");
					String interestAcruedTillDate = rs.getString("interestAcruedTillDate");

					acd.setCustomerId(customerId);
					acd.setAccountNumber(accountNumber);
					acd.setAccountTypeId(accountTypeId);
					acd.setAccountType(accountTypeName);
					acd.setAccountOpeningDate(""+accountOpeningDate);
					acd.setCurrentBalance(currentBalance);
					acd.setUnclearedAmount(unclearedAmount);
					acd.setAmountOnHold(amountOnHold);
					acd.setInterestAcruedTillDate(interestAcruedTillDate);
					
					System.out.println("acd = "+acd);
					
				}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
		
		
		
		System.out.println(METHOD_NAME + "*******Completed ****");
		return acd;
	}
	
	@Override
	public ArrayList<Customer> listAllCustomers() throws SQLException {

		String METHOD_NAME = CLASS_NAME+".listAllCustomers():";
		System.out.println(METHOD_NAME + "*******Starting ****");

		Customer c = null;
		ArrayList<Customer> cList = new ArrayList<Customer>(); ; 
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER" ;
			statement =  conn.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				System.out.println("rs" + rs);

				c = new Customer(); 

				int ID= rs.getInt("ID");
				String FIRSTNAME= rs.getString("FIRSTNAME");
				String LASTNAME= rs.getString("LASTNAME");
				String CITY= rs.getString("CITY");
				int COUNTRYID= rs.getInt("COUNTRYID");
				String COUNTRYNAME= rs.getString("COUNTRYNAME");
				String MOBILENUMBER= rs.getString("MOBILENUMBER");
				String EMAILID= rs.getString("EMAILID");
				
				System.out.println(METHOD_NAME + ID + FIRSTNAME + LASTNAME +CITY +COUNTRYID + COUNTRYNAME + EMAILID + MOBILENUMBER);
				c.setId(ID);
				c.setFirstName(FIRSTNAME);
				c.setLastName(LASTNAME);
				c.setCity(CITY);
				Country co = new Country(COUNTRYID,COUNTRYNAME);
				c.setCountry(co);
				c.setMobileNumber(MOBILENUMBER);
				c.setEmailId(EMAILID);
				
				cList.add(c);

			}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
			return cList;
	}

	@Override
	public void addMoney(Transaction t) throws SQLException {
		String METHOD_NAME = CLASS_NAME+".addMoney():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + t);
		
		
		AccountDetails acd = viewAccountDetails(t.getCust().getCustomerId());
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;

		try {
			conn = DbUtil.getConnection();

			String sql = "INSERT INTO tranaction (customerId,accountNumber,operation, transId,  approvedBy,approvalStatus,approvedWhen,transTime,transAmount)"
					+ " VALUES (?, ?, ?, ?,?, ?, ?,?,?)";
			ps =  conn.prepareStatement(sql);
			ps.setString(1, acd.getCustomerId());
			ps.setString(2,acd.getAccountNumber());
			
			ps.setString(3,t.getOperation());
			ps.setString(4,t.getTransId());
			ps.setString(5,t.getApprovedBy());
			ps.setString(6,t.getApprovalStatus());
			ps.setString(7,t.getApprovedWhen());
			ps.setString(8,t.getTransTime());
			ps.setString(9,t.getTransAmount());
			
			
			System.out.println(METHOD_NAME + "input sql: " + ps.toString());



			int rs = ps.executeUpdate();
			if(rs != 0)
			{
				String updated_balance = (Integer.valueOf(acd.getCurrentBalance()) + Integer.valueOf(t.getTransAmount()))+"";
				System.out.println(METHOD_NAME + "Updated Currect Balance = " + updated_balance);
				
				
				String sql1 = "UPDATE accountdetails set currentBalance = ? where customerId = ?";
				ps1 =  conn.prepareStatement(sql1);

				ps1.setString(1, updated_balance);
				ps1.setString(2, t.getCust().getCustomerId());
				int rs1 = ps1.executeUpdate();
				
			}
			else
			{
				String sql2 = "UPDATE tranaction set transStatus = ? where customerId = ?";
				ps2 =  conn.prepareStatement(sql2);

				ps2.setString(1, "FAILED");
				ps2.setString(2, t.getCust().getCustomerId());
				int rs2 = ps2.executeUpdate();
			}

		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, ps, conn);
		}
		
		
		
		System.out.println(METHOD_NAME + "*******Completed ****");


	}

	@Override
	public void approveTransaction(Transaction amount) {
		
		
	}

	@Override
	public void provideLoan(Customer customerId, Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bulkDeleteCustomer(List<Customer> customerIds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}