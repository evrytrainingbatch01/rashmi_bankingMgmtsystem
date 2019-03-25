/**
 * 
 */
package com.evryindia.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.evryindia.foundation.domain.AccountDetails;
import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;

/**
 * @author rashmi.kiran
 *
 */
public interface CustomerOperationDao {

	void ebAddMoneyToOwnAccount(Transaction t);
	void ebWithdrawMoney(Transaction t) throws SQLException;
	void ebAskForLoan(Customer c, Transaction t);
	public Customer viewCustomersDetails(int customerId) throws SQLException;
	public int ebMoneyTransferToAnyAccount(int ownAccountId, int beneficiaryAccountId);
	ArrayList<Customer> ebViewCustomerDetails(ArrayList<Customer> customerList);

}
