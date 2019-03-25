package com.evryindia.foundation.domain;

import javax.swing.text.AbstractDocument.BranchElement;

public class AccountDetails {

	private int id;
	private int accountTypeId;
	private String accountType;
	private String accountNumber;
	private Branch branchCodeId;
	private Branch branchNameId;
	private String accountOpeningDate;
	private String currentBalance;
	private String unclearedAmount;
	private String amountOnHold;
	private String interestAcruedTillDate;
	private String customerId;
	
	
	@Override
	public String toString()
	{
		StringBuilder sb  = new StringBuilder();
		sb.append("\n Customer ID : ");
		sb.append(this.getCustomerId());
		
//			String sql = "SELECT CUSTOMERID,accountNumber,accountTypeId,accountOpeningDate,currentBalance,unclearedAmount,amountOnHold,interestAcruedTillDate FROM ACCOUNTDETAILS WHERE CUSTOMERID = ?" ;

	
		sb.append("\n accountNumber : ");
		sb.append(this.getAccountNumber());
		
		sb.append("\n accountTypeId : ");
		sb.append(this.getAccountTypeId());
		
		sb.append("\n accountType : ");
		sb.append(this.getAccountType());
		
		sb.append("\n accountOpeningDate : ");
		sb.append(this.getAccountOpeningDate());
		
		sb.append("\n currentBalance : ");
		sb.append(this.getCurrentBalance());
		
		sb.append("\n unclearedAmount : ");
		sb.append(this.getUnclearedAmount());
		
		sb.append("\n amountOnHold : ");
		sb.append(this.getAmountOnHold());
		
		sb.append("\n interestAcruedTillDate : ");
		sb.append(this.getInterestAcruedTillDate());

		return sb.toString();
	}
	
	
	
	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumberId) {
		this.accountNumber = accountNumberId;
	}
	public Branch getBranchCodeId() {
		return branchCodeId;
	}
	public void setBranchCodeId(Branch branchCodeId) {
		this.branchCodeId = branchCodeId;
	}
	public Branch getBranchNameId() {
		return branchNameId;
	}
	public void setBranchNameId(Branch branchNameId) {
		this.branchNameId = branchNameId;
	}
	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getUnclearedAmount() {
		return unclearedAmount;
	}
	public void setUnclearedAmount(String unclearedAmount) {
		this.unclearedAmount = unclearedAmount;
	}
	public String getAmountOnHold() {
		return amountOnHold;
	}
	public void setAmountOnHold(String amountOnHold) {
		this.amountOnHold = amountOnHold;
	}
	public String getInterestAcruedTillDate() {
		return interestAcruedTillDate;
	}
	public void setInterestAcruedTillDate(String interestAcruedTillDate) {
		this.interestAcruedTillDate = interestAcruedTillDate;
	}
}