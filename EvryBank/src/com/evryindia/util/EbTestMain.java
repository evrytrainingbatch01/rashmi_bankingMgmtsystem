package com.evryindia.util;
import java.sql.SQLException;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.user.service.AdminOperationDaoImpl;
import com.evryindia.user.service.CustomerOperationDaoImpl;
public class EbTestMain {

	public static void main(String[] args) {
		AdminOperationDaoImpl aop = new AdminOperationDaoImpl();
		
		try {
			System.out.println(aop.viewCustomersDetails("8897253673098136302"));

			Transaction txn = new Transaction();
			txn.setCust(new Customer("8897253673098136302"));
			txn.setOperation("DEPOSIT");
			txn.setApprovalStatus("APPROVED");
			txn.setApprovedBy("ADMIN");
			txn.setTransTime(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
			txn.setApprovedWhen(java.sql.Date.valueOf(java.time.LocalDate.now()).toString());
			txn.setTransId(KeyGenerator.generateKey());
			txn.setTransAmount("2000");
			
			
			CustomerOperationDaoImpl coi = new CustomerOperationDaoImpl();
			coi.ebWithdrawMoney(txn);
			//aop.addMoney(txn);
			
			
			System.out.println(aop.viewCustomersDetails("8897253673098136302"));

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
