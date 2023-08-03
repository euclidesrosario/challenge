package com.challenge.webapp.Model;

import org.springframework.http.HttpStatus;

public class Response {
	
	private Weather Weather;
	private CountryData CountryData;
	private Exchange Exchange;
	private HttpStatus httpStatus;
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Weather getWeather() {
		return Weather;
	}
	public void setWeather(Weather weather) {
		Weather = weather;
	}
	public CountryData getCountryData() {
		return CountryData;
	}
	public void setCountryData(CountryData countryData) {
		CountryData = countryData;
	}
	public Exchange getExchange() {
		return Exchange;
	}
	public void setExchange(Exchange exchange) {
		Exchange = exchange;
	}

}
