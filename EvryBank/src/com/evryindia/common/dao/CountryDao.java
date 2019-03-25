package com.evryindia.common.dao;

import java.io.Serializable;
import java.util.List;

import com.evryindia.foundation.domain.Country;

public interface CountryDao extends Serializable {
	
	public List<Country> countryList();	
	public int insertCountry(Country country);
	public Country getCountry(int countryId);
	public int updateCountry(Country country);
	public int deleteCountry(int countryId);
	
}
