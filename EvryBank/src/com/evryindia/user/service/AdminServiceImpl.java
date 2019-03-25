package com.evryindia.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.evryindia.user.dao.AdminOperationDao;
import com.evryindia.user.service.AdminOperationDaoImpl;
import com.evryindia.foundation.domain.Account;
import com.evryindia.foundation.domain.AccountDetails;
import com.evryindia.foundation.domain.Country;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.util.CryptographyUtil;
import com.evryindia.util.KeyGenerator;

public class AdminServiceImpl implements AdminService {
	String CLASS_NAME = this.getClass().getName();

	Country country;
	Scanner sc = new Scanner(System.in);

	@Override
	public int ebAddCustomer(Customer customer) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebAddCustomer():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		if (customer != null) {
			AdminOperationDao adminDao = new AdminOperationDaoImpl();
				
//					UserType userType = null;
//					Country country = null;

				// to do account id generation, auto-generation

				System.out.println("Enter customer fname");
				//customer.setId(16);//TODO need to generate id
				customer.setFirstName(sc.next());
				System.out.println("Entr Last name");
				customer.setLastName(sc.next());
				System.out.println("Entr city");
				customer.setCity(sc.next());
				// System.out.println("ent country");
//					customer.setCountry(country);
				System.out.println("Entr email");
				customer.setEmailId(sc.next());
				// System.out.println("ntr usertype: ADMIN/CUSTOMER");
//					customer.setUserType(userType);	
				System.out.println("Entr mob. no.");
				customer.setMobileNumber(sc.next());
				System.out.println("Entr password");

				String encryptpass = CryptographyUtil.generateDigest(sc.next());
				customer.setPassword(encryptpass);
				customer.setCountry(new Country(1,"India"));
				String generatedCustomerId = KeyGenerator.generateKey();
				System.out.println("Generated Customer id " + generatedCustomerId);
				customer.setCustomerId(generatedCustomerId);
				//customer.setUserType();//TODO
				
				AccountDetails accountDetails = new AccountDetails();
				accountDetails.setAccountNumber(generatedCustomerId);
				//accountDetails.setAccountTypeId(accountTypeId);//TODO need to improve
				
				adminDao.addCustomer(customer);
				adminDao.createAccount(customer);

			/*
			 * if (customer.getId() <= 0) { adminDao.addCustomer(customer); } else {
			 * //adminDao.ebUpdateCustomer(customer); }
			 */
				sc.close();
				System.out.println("New Customer Created with customer id ***** " + generatedCustomerId );
				System.out.println(METHOD_NAME+"Completed <<<<<<<<");
				
			}

		return 0;
	}

	public int ebDeleteCustomer(String customerId) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebDeleteCustomer():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		Customer customer = new Customer();
		AdminOperationDao adminDao = new AdminOperationDaoImpl();
		
		System.out.println("\n Enter customer ID : ");
		customer.setCustomerId(sc.next());
		adminDao.deleteAccount(customer);

		adminDao.deleteCustomer(customer);
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return 0;
	}

	public List<Customer> ebViewCustomerList() throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebViewCustomerList():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();
		
		List<Customer> customerList = adminDao.listAllCustomers();
		if(customerList != null )
		{
			for(int i=0; i< customerList.size();i++)
			{
				Customer c = customerList.get(i);
				System.out.println("\n"+c);
			}
		}
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return customerList;
	}

	public Customer ebViewCustomerDetails(String accountId) throws SQLException {
		
		String METHOD_NAME = CLASS_NAME + ".ebViewCustomerList():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();			
		System.out.println("\n Enter customer ID : ");

		Customer c = adminDao.viewCustomersDetails(sc.next());
		System.out.println("\n"+c);
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");

		return c;
	}

	public int ebAddMoneyToAnyAccount(String accountId) throws SQLException {
		String METHOD_NAME = CLASS_NAME + ".ebAddMoneyToAnyAccount():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		
		AdminOperationDao adminDao = new AdminOperationDaoImpl();		
		
		System.out.println("\n Enter customer ID OR Account Numbe : ");
		//String customerId = sc.next();
		
		System.out.println("\n Enter to be Deposit Amout : ");
		String depositAmount = sc.next();
		
		
		Customer c = new Customer(accountId);
		
		Transaction txn = new Transaction();
		txn.setCust(c);
		txn.setOperation("DEPOSIT");
		txn.setApprovalStatus("APPROVED");
		txn.setApprovedBy("ADMIN");
		txn.setTransTime(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		txn.setApprovedWhen(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
		txn.setTransId(KeyGenerator.generateKey());
		txn.setTransAmount(depositAmount);
		
		adminDao.addMoney(txn);
		System.out.println("\n"+txn);
		
		System.out.println(METHOD_NAME+"Completed <<<<<<<<");
		
		return 0;
	}

	public boolean ebApproveTranction(String accountId) {
		String METHOD_NAME = CLASS_NAME + ".ebApproveTranction():";
		System.out.println(METHOD_NAME+"Starting >>>>>>>>");
		
		//AdminOperationDao adminDao = new AdminOperationDaoImpl();
		//Customer c = new Customer( accountId );
		//AccountDetails ad = new AccountDetails();
		
		System.out.println("\n Enter account ID : ");
		//c.se(Integer.valueOf(sc.next()));
		
		Account a = new Account();
		a.setAccountNumber(sc.next());
		
		
		return true;
	}

	public boolean ebApprovideLoan(String customerId) {
		return true;
	}

}