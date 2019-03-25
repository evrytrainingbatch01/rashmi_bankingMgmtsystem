package com.evryindia.user.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.evryindia.foundation.domain.Account;
import com.evryindia.foundation.domain.AccountDetails;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.user.dao.AdminOperationDao;
import com.evryindia.user.dao.CustomerOperationDao;
import com.evryindia.util.KeyGenerator;


public class CustomerServiceImpl implements CustomerService{
	String CLASS_NAME = this.getClass().getName();

	Country country;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void ebAddMoneyToOwnAccount(Transaction t) {
	}

	@Override
	public void ebWithdrawMoney(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ebAskForLoan(Customer c, Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer viewCustomersDetails(int accountId) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebViewCustomerList():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		
		CustomerOperationDao custDao = new CustomerOperationDaoImpl();
		Customer c = new Customer( accountId+"" );
						
		System.out.println("\n Enter account ID : ");
		c.setId(Integer.valueOf(sc.next()));
		
		ArrayList<Customer> customerList= new ArrayList<Customer>();
		customerList.add(c);
		
		custDao.viewCustomersDetails(accountId);
		

//		
//		if(c != null )
//		{
//				System.out.println("\n"+c);
//		
//		}

		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return c;
		
		
		
//		ArrayList<Customer> customerList= new ArrayList<Customer>();
//		customerList.add(c);
//		
//		ArrayList<Customer> returnedCustomerList = custDao.ebViewCustomerDetails(customerList);
//		
//		if(returnedCustomerList != null && !returnedCustomerList.isEmpty() )
//		{
//				c = returnedCustomerList.get(0);
//				System.out.println("\n"+c);
//		}
//		else
//			return null;
//		
//		System.out.println(METHOD_NAME+"Completed <<<<<<<<");
//
//		return c;
	}

	@Override
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Customer> ebViewCustomerDetails(ArrayList<Customer> customerList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer ebViewCustomerDetails(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ebWithdrawMoney(String accountId) throws SQLException {
		
		String METHOD_NAME = CLASS_NAME + ".ebWithdrawMoney():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();		
		
		System.out.println("\n Enter customer ID OR Account Numbe : ");
		String customerId = sc.next();
		
		System.out.println("\n Enter to be Deposit Amout : ");
		String depositAmount = sc.next();
		
		
		Customer c = new Customer(accountId);
		
		Transaction txn = new Transaction();
		txn.setCust(c);
		txn.setOperation("WITHDRAW");
		txn.setApprovalStatus("APPROVED");
		txn.setApprovedBy("ADMIN");
		txn.setTransTime(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		txn.setApprovedWhen(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		txn.setTransId(KeyGenerator.generateKey());
		txn.setTransAmount(depositAmount);
		
		CustomerOperationDaoImpl co = new CustomerOperationDaoImpl();
		co.ebWithdrawMoney(txn);

		System.out.println("\n"+txn);
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");
		

		
		return 0;
	}

	@Override
	public int ebAddMoneyToOwnAccount(String accountId, int amount) {

		return 0;
	}

}
