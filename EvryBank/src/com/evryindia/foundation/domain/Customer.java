package com.evryindia.foundation.domain;

import com.evryindia.foundation.domain.UserType;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private Country country;
	private String mobileNumber;
	private String emailId;
	private UserType userType;
	private String password;
	private AccountDetails accountDetails;
	private Account account;
	private String customerId;
	
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer(String custId) {
		this.setCustomerId(custId); 
	}
	public Customer() {
	}
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb  = new StringBuilder();
		sb.append("\n Customer ID : ");
		sb.append(this.getCustomerId());
		
		sb.append(" \n First Name : ");
		sb.append(this.getFirstName());
		
		sb.append("\n Last Name : ");
		sb.append(this.getLastName());
		
		sb.append( "\n city : " );
		sb.append( this.city );
		
		sb.append( "\n country : " );
		sb.append( this.country == null ? null : this.country.getId()  );
		
		sb.append( "\n mobileNumber : " );
		sb.append( this.mobileNumber );
		
		sb.append( "\n emailId : " );
		sb.append( this.emailId );
		
		sb.append( "\n userType : ");
		sb.append( this.userType );
				
		if(null != this.getAccountDetails())
		{
			sb.append( "\n\n\r\r AccountDetails : ");
			sb.append("\r\r" + this.getAccountDetails().toString());
		}

		
		return sb.toString();
	}
}