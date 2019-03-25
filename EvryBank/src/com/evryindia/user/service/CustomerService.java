package com.evryindia.user.service;

import java.sql.SQLException;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;
import com.evryindia.user.dao.CustomerOperationDao;

public interface CustomerService extends CustomerOperationDao{
		public Customer ebViewCustomerDetails(int accountId);
		public void ebAskForLoan(Customer c, Transaction t);
		public int ebWithdrawMoney(String accountId) throws SQLException;
		public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId);
		public int ebAddMoneyToOwnAccount(String accountId, int amount);


}
