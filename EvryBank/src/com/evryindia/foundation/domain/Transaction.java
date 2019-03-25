/**
 * 
 */
package com.evryindia.foundation.domain;

import java.util.ArrayList;

/**
 * @author rashmi.kiran
 *
 */
public class Transaction {
	private Customer customer;
	private String operation;
	private String transId;
	private String approvedBy;
	private String approvalStatus;
	private String approvedWhen;
	private String transTime;
	private String transAmount;
	
	public String getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}
	public Customer getCust() {
		return customer;
	}
	public void setCust(Customer customer) {
		this.customer = customer;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	@Override
	public String toString() {
		return "Transaction [customer=" + customer + ", operation=" + operation + ", transId=" + transId
				+ ", approvedBy=" + approvedBy + ", approvalStatus=" + approvalStatus + ", approvedWhen=" + approvedWhen
				+ ", transTime=" + transTime + ", transAmount=" + transAmount + "]";
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprovedWhen() {
		return approvedWhen;
	}
	public void setApprovedWhen(String approvedWhen) {
		this.approvedWhen = approvedWhen;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public static ArrayList<String> getTransOperType() {
		return TRANS_OPER_TYPE;
	}
	public static final ArrayList<String> TRANS_OPER_TYPE = new ArrayList<String>();
	static {
		TRANS_OPER_TYPE.add("DEPOSIT");
		TRANS_OPER_TYPE.add("WITHDRAW");
	}
	

}
