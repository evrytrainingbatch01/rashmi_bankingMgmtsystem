package com.evryindia.user.service;

import java.sql.SQLException;
import java.util.List;

import com.evryindia.foundation.domain.Customer;

public interface AdminService {
	public int ebAddCustomer(Customer customer) throws SQLException;
	public int ebDeleteCustomer(String customerId) throws SQLException;
	public List<Customer> ebViewCustomerList() throws SQLException;
	public Customer ebViewCustomerDetails(String  accountId) throws SQLException;
	
	public int ebAddMoneyToAnyAccount(String accountId) throws SQLException;
	public boolean ebApproveTranction(String customerId);
	public boolean ebApprovideLoan(String customerId);

}