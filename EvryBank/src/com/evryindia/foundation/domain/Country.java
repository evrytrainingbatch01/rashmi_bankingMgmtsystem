package com.evryindia.foundation.domain;

public class Country {
	private int id;
	private String name;
	private String countryCode;
	 public Country(int i, String string) {
		 this.setId(i);
		 this.setName(name);
	 }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}