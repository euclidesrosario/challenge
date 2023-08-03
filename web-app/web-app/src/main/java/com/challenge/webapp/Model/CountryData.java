package com.challenge.webapp.Model;

import java.math.BigDecimal;

public class CountryData {
	
	private long population;
	private BigDecimal gdp;
	private String country;
	
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public BigDecimal getGdp() {
		return gdp;
	}
	public void setGdp(BigDecimal gdp) {
		this.gdp = gdp;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
