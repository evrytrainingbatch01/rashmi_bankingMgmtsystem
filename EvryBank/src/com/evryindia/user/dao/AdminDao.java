package com.evryindia.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.evryindia.foundation.domain.Customer;

public interface AdminDao {
	
	public int ebAddCustomer(Customer customer) throws SQLException;
	public int ebUpdateCustomer(Customer customer);

	public int ebDeleteCustomer(int customerId);
	public List<Customer> ebViewCustomerList();
	public Customer ebViewCustomerDetails(int  accountId);
	
	public int ebAddMoneyToAnyAccount(int accountId);
	public boolean ebApproveTranction(int customerId);
	public boolean ebApprovideLoan(int customerId);
}