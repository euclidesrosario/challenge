package com.challenge.webapp.Model;

import java.math.BigDecimal;

public class Weather {

	private long id;
	private String city;
	private String main;
	private String description;
	private String icon;
	private	double temperature;
	private int humidity ;
	private String country;
	private BigDecimal temp_min;
	private BigDecimal temp_max;
	
	
	
	
	

	public BigDecimal getTemp_min() {
		return temp_min;
	}



	public void setTemp_min(BigDecimal temp_min) {
		this.temp_min = temp_min;
	}



	public BigDecimal getTemp_max() {
		return temp_max;
	}



	public void setTemp_max(BigDecimal temp_max) {
		this.temp_max = temp_max;
	}



	public double getTemperature() {
		return temperature;
	}



	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}



	public int getHumidity() {
		return humidity;
	}



	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public long getId() {
		return id;
	}

	
	
	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public void setId(long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}



	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", main=" + main + ", description=" + description + ", icon="
				+ icon + ", temperature=" + temperature + ", humidity=" + humidity + ", country=" + country
				+ ", getTemperature()=" + getTemperature() + ", getHumidity()=" + getHumidity() + ", getCountry()="
				+ getCountry() + ", getId()=" + getId() + ", getCity()=" + getCity() + ", getMain()=" + getMain()
				+ ", getDescription()=" + getDescription() + ", getIcon()=" + getIcon() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
