/**
 * 
 */
package com.evryindia.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evryindia.foundation.domain.Customer;
import com.evryindia.foundation.domain.Transaction;

/**
 * @author rashmi.kiran
 *
 */
public interface AdminOperationDao {

	void addCustomer(Customer customerId) throws SQLException;
	void deleteCustomer (Customer customerId) throws SQLException;
	//to do bulk delete
	void bulkDeleteCustomer (List<Customer> customerIds) throws SQLException;

	void addMoney(Transaction t) throws SQLException;
	void approveTransaction(Transaction t);
	void provideLoan(Customer customerId,Transaction t);
	Customer viewCustomersDetails(String customerId) throws SQLException;
	ArrayList<Customer> listAllCustomers() throws SQLException;
	void createAccount(Customer customer) throws SQLException;
	void deleteAccount(Customer c) throws SQLException;
}
