package com.evryindia.common.service;

import java.util.List;

import com.evryindia.foundation.domain.Country;

public interface CountryService {
	
	public List<Country> countryList();	
	public void saveCountry(Country country);
	public Country getCountry(int countryId);
	public int updateCountry(Country country);
	public void deleteCountry(int countryId);
}
