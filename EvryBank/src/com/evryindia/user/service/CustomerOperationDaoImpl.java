package com.evryindia.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.evryindia.user.dao.CustomerOperationDao;
import com.evryindia.foundation.domain.Account;
import com.evryindia.foundation.domain.AccountDetails;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.util.DbUtil;

public class CustomerOperationDaoImpl implements CustomerOperationDao {
	String CLASS_NAME =  this.getClass().getName();
	Scanner sc = new Scanner(System.in);

	@Override
	public void ebAddMoneyToOwnAccount(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ebWithdrawMoney(Transaction t) throws SQLException {

			String METHOD_NAME = CLASS_NAME+".ebWithdrawMoney():";
			System.out.println(METHOD_NAME + "*******Starting ****");
			System.out.println(METHOD_NAME + "input : " + t);
			
			AdminOperationDaoImpl ao = new AdminOperationDaoImpl();
			AccountDetails acd = ao.viewAccountDetails(t.getCust().getCustomerId());
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
					String updated_balance = (Integer.valueOf(acd.getCurrentBalance()) - Integer.valueOf(t.getTransAmount()))+"";
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
	public void ebAskForLoan(Customer c, Transaction t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId) {
		
		return 0;
	}

	@Override
	public Customer viewCustomersDetails(int customerId) throws SQLException {
		String METHOD_NAME = CLASS_NAME+".viewCustomersDetails():";
		System.out.println(METHOD_NAME + "*******Starting ****");
		System.out.println(METHOD_NAME + "input : " + customerId);
		
		Customer c = null;
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = DbUtil.getConnection();

			String sql = "SELECT ID,FIRSTNAME,LASTNAME,CITY,COUNTRYID,(SELECT NAME FROM COUNTRY WHERE ID = COUNTRYID) COUNTRYNAME,MOBILENUMBER,EMAILID FROM CUSTOMER WHERE ID = ?" ;
			statement =  conn.prepareStatement(sql);
			statement.setInt(1, customerId);

			
			ResultSet rs = statement.executeQuery();
				while (rs.next()){
					c = new Customer(sql);
//changed c = new Customer()  to c = new Customer(sql)
					int ID= rs.getInt("ID");
					String FIRSTNAME= rs.getString("FIRSTNAME");
					String LASTNAME= rs.getString("LASTNAME");
					String CITY= rs.getString("CITY");
					int COUNTRYID= rs.getInt("COUNTRYID");
					String COUNTRYNAME= rs.getString("COUNTRYNAME");
					String MOBILENUMBER= rs.getString("MOBILENUMBER");
					String EMAILID= rs.getString("EMAILID");
					
					c.setId(ID);
					c.setFirstName(FIRSTNAME);
					c.setLastName(LASTNAME);
					c.setCity(CITY);
					Country co = new Country(COUNTRYID,COUNTRYNAME);
					c.setCountry(co);
					c.setMobileNumber(MOBILENUMBER);
					c.setEmailId(EMAILID);
					
				}
		}catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		finally{
			DbUtil.closeAll(null, statement, conn);
		}
	
		return c;
	}

	@Override
	public ArrayList<Customer> ebViewCustomerDetails(ArrayList<Customer> customerList) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public void addMoneys(String accountId, String amount) {
//		String METHOD_NAME = CLASS_NAME+".addMoney():";
//		System.out.println(METHOD_NAME + "*******Starting ****");
//		System.out.println(METHOD_NAME + "accountId : " + accountId + ", amount : " + amount);
//		
//		Connection conn = null;
//		PreparedStatement statement = null;
//	
//		try {
//
//			conn = DbUtil.getConnection();
//
//			String sql = "INSERT INTO accountdetails (accountTypeId, accountNumberId, branchCodeId,  branchNameId,accountOpeningDate,currentBalance, unclearedAmount,amountOnHold,interestAcruedTillDate)"
//					+ " VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
//
//			statement =  conn.prepareStatement(sql);
//			
//			Transaction t = new Transaction();
//			AccountDetails ac = new AccountDetails();
//			
////			//statement.setInt(1, c.getId());
////			statement.setInt(2, ac.getAccountTypeId());
////			statement.setString(3, ac.getLastName());
////			statement.setString(4, ac.getCity());
////			statement.setString(5, ac.getMobileNumber());
////			statement.setString(6, ac.getEmailId());
////			statement.setString(7, ac.getPassword());
////			statement.setInt(8, ac.getCountry().getId());
////			
//			int rowsInserted = statement.executeUpdate();
//			if (rowsInserted > 0) {
//				System.out.println("A new user was inserted successfully!");
//			}
//
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			//throw ex;
//		}
//
//		finally{
//			DbUtil.closeAll(null, statement, conn);
//		}
//		
//		System.out.println(METHOD_NAME + "*******Completed ****");
//
//		
//	}

}
