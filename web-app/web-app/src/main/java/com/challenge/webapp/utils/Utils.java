package com.challenge.webapp.utils;

public class Utils {
	

	public static String OPEN_WEATHER_API_ENDPOINT="http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";
	public static final String OPEN_WEATHER_API_KEY = "0575781fdf815b81704e3c0b091cc616";
	
	public static final String EXCENGERETE_ACCESS_API_KEY = "a4d91b912fd69d7429d907fa";
	public static final String EXCENGERETE_API_ENDPOINT = "https://v6.exchangerate-api.com/v6/"+EXCENGERETE_ACCESS_API_KEY+"/pair/{COIN}/MZN";
	
	public static final String WORDBANK_POPUTAION_END_POINT = "http://api.worldbank.org/v2/countries/" + "{country}" + "/indicators/SP.POP.TOTL?date=2022&format=json";

     // Endpoint para obter o PIB de um país específico
	public static final String WORDBANK_GDP_ENPOINT = "http://api.worldbank.org/v2/countries/" +"{country}"+"/indicators/SP.POP.TOTL?date=2022&format=json";



}
