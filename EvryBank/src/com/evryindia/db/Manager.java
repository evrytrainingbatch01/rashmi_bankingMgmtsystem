package com.evryindia.db;

import java.sql.SQLException;
import java.util.Scanner;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.foundation.domain.UserType;
import com.evryindia.user.service.AdminServiceImpl;
import com.evryindia.user.service.CustomerServiceImpl;

public class Manager
{
	public static void main(String[] args) throws SQLException {	
		CustomerServiceImpl customerService =new CustomerServiceImpl();
		AdminServiceImpl adminSrvice =new AdminServiceImpl();
		Customer customer = new Customer();
		
		String accountId = "";
		int toAccountId = 0;
		int fromAccountId = 0;
		Transaction transaction = null;
		Customer  cust = null;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email: ");
		String email = sc.next();

		System.out.println("Enter password: ");
		String password = sc.next();
		
		System.out.println("Enter userType, for ADMIN type 1, for normal  CUSTOMER type 2 ");
		System.out.println("entr usertype id : ");
		int userTypeId = sc.nextInt();
		System.out.println("entr usertype name : ");
		String name = sc.next();

		UserType userType = new UserType();
		userType.setId(userTypeId);
		userType.setName(name);
		//TODO user id and password validation is not used
		
		customer.setEmailId(email);
		customer.setUserType(userType);
	
	while(true)	{
		if(customer.getUserType().getId() == 1) { 
			System.out.println("1. Add Customer");
			System.out.println("2. Delete a Customer");
			System.out.println("3. Customers list");
			System.out.println("4. Customer details");
			System.out.println("5. Add money to any account");
			System.out.println("6. Provide Loan");
			System.out.println("7. Approve tranaction");
			System.out.println("13. TO EXIT PLEASE ENTER  ************");

			
		}
		else if (customer.getUserType().getId()==2){ 
			System.out.println("8. Add money to own account");
			System.out.println("9. Customer account details");
			System.out.println("10. Send money to another account");
			System.out.println("11. Withdrawal money");
			System.out.println("12. Ask for loan");
			System.out.println("13. TO EXIT PLEASE ENTER  ************");

		}
		else
		{
			System.out.println("invalid input: Non bank customer not allowed, Must have an account");
		}
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			adminSrvice.ebAddCustomer(customer);
			break;
		case 2:
			adminSrvice.ebDeleteCustomer(accountId);
			break;
		case 3:
			adminSrvice.ebViewCustomerList();
			break;
		case 4:
			adminSrvice.ebViewCustomerDetails(accountId);
			break;
		case 5:
			adminSrvice.ebAddMoneyToAnyAccount(accountId);
			break;
		case 6:
			adminSrvice.ebApproveTranction(accountId);
			break;
		case 7:
			adminSrvice.ebApprovideLoan(accountId);
			break;
		case 8:     
			customerService.ebAddMoneyToOwnAccount(transaction);
			break;
		case 9:
			customerService.ebViewCustomerDetails(null);
			break;
		case 10:
			customerService.ebAskForLoan(cust,  transaction);
			break;
		case 11:
			customerService.ebWithdrawMoney(transaction);	     
			break;
		case 12:
			customerService.ebMoneyTransferToAnyAccount(toAccountId, fromAccountId);
			break;
		case 13:
			System.exit(0);
		default: 
			System.out.println("Wrong Entry");	
		}


	}
//		int action;
//		if(sc.nextInt() == 1)
//		{
//			adminOperations(sc);
//		}
//		else if(sc.nextInt() == 2)
//		{
//			customerOperation(sc);
//		}
//		else
//		{
//			System.out.println("input is not proper ");
//			System.out.println("input 1 for admin and 2 for customer ");
//		}
	}
}
