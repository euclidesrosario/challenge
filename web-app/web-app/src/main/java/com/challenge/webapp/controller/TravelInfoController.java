package com.challenge.webapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.webapp.Model.CountryData;
import com.challenge.webapp.Model.Exchange;
import com.challenge.webapp.Model.Response;
import com.challenge.webapp.Model.Weather;
import com.challenge.webapp.utils.Utils;

@RestController
@RequestMapping("/api/travel/")
@CrossOrigin("*")
public class TravelInfoController {

	
	@GetMapping
	@Async
	public Response responseRequest(String value) {
		
//		String value="zimbabwe";
		Response response= new Response();

		Weather weather = getWeather(value);
		
		
		if(weather!=null) {
			System.out.println(" nao e null");
			response.setWeather(weather);	
			CountryData CountryData = getCountryData(weather.getMain());
			
			response.setCountryData(CountryData);
			response.setExchange(getExchange(getCountryCurrency(CountryData.getCountry().replace(" ", ""))));


			return response;
		} else
		{
			CountryData CountryData = getCountryData(value);
			response.setCountryData(CountryData);
			response.setExchange(getExchange(getCountryCurrency(value)));


			response.setHttpStatus(org.springframework.http.HttpStatus.BAD_REQUEST);
			return response;

			
		}


	}
	

	
	// 1. 
	public  Weather getWeather(String city) {

		try {

			URL url = new URL(Utils.OPEN_WEATHER_API_ENDPOINT.replace("{city}", city).replace("{apiKey}",
					Utils.OPEN_WEATHER_API_KEY));

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			 connection.setRequestMethod("GET");

	            
	            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuilder response = new StringBuilder();

	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }

	                in.close();

	               return parseWeatAndCreateherData(response.toString());
	            } else {
	                System.out.println("error:"+ connection.getResponseCode());
	        		return null;

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;

	}
	
	
//1.
	public  Weather  parseWeatAndCreateherData(String jsonResponse) {
		
		try {
			JSONObject jsonObject = new JSONObject(jsonResponse);
			Weather weather = new Weather();
	        JSONObject main = jsonObject.getJSONObject("main");
	        JSONObject sys = jsonObject.getJSONObject("sys");
			weather.setCity(jsonObject.getString("name"));
			weather.setHumidity(main.getInt("humidity"));
			weather.setTemperature(main.getDouble("temp"));
			weather.setTemp_max(main.getBigDecimal("temp_max"));
			weather.setTemp_min(main.getBigDecimal("temp_min"));
			weather.setMain(sys.getString("country"));
	        System.out.println( weather.toString());
	        
	        

			return weather;
			
		} catch (Exception e) {
			return null;
		}

	}

	
	
	//2.
	
	public  Exchange getExchange(String coin) {
		Exchange exchange = new Exchange();	

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(Utils.EXCENGERETE_API_ENDPOINT.replace("{COIN}", coin));

			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseBody = EntityUtils.toString(entity);
			JSONObject jsonObject = new JSONObject(responseBody);
			exchange.setConversion_rate(jsonObject.getBigDecimal("conversion_rate"));
			exchange.setBase_code(jsonObject.getString("base_code")); ;
			
	        System.out.println( exchange.toString());
	        
	        


		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}
		return exchange;

	}
	
	
	//3
	
	
	public   CountryData getCountryData(String countryAcronym) {
		CountryData countryData = new CountryData();	

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

				HttpGet gdpRequest = new HttpGet(Utils.WORDBANK_GDP_ENPOINT.replace("{country}", countryAcronym));
		        HttpResponse gdpResponse = httpClient.execute(gdpRequest);
		        HttpEntity gdpEntity = gdpResponse.getEntity();
			
			
		        
		     
		        String gdpResponseBody = EntityUtils.toString(gdpEntity);
	
		        JSONArray gdpJsonArray = new JSONArray(gdpResponseBody);
		        JSONArray gdpDataArray = gdpJsonArray.getJSONArray(1);
		        JSONArray countryDataArray = gdpJsonArray.getJSONArray(1);

	
		        JSONObject latestGdpObject = gdpDataArray.getJSONObject(gdpDataArray.length() - 1);
		        BigDecimal gdp = latestGdpObject.getBigDecimal("value");
	
	
		        JSONObject latestPopulationObject = countryDataArray.getJSONObject(countryDataArray.length() - 1);
		        int pop = latestPopulationObject.getInt("value");
		        JSONObject countryObject = latestPopulationObject.getJSONObject("country");
		        String country = countryObject.getString("value");
		        
		        
		        

		        System.out.println("Resposta gdp gdp: " + country); 
		        System.out.println("Resposta pop: " + country); 
		        countryData.setGdp(gdp);
		        countryData.setPopulation(pop);
		        countryData.setCountry(country);
		        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countryData;

	}
	
	
	

	//3.

	
	    private  String parseIndicatorValues(String jsonResponse) {
        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);
            JSONArray data = jsonArray.getJSONObject(1).getJSONArray("data");

            if (data.length() > 0) {
                JSONObject latestData = data.getJSONObject(data.length() - 1);
                return latestData.getString("value");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Dados não disponíveis";
    }
    
    //3.
	    
	    
	    public String  getCountryCurrency(String countryName) {
	    	

	    	 try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	    	        HttpGet countryRequest = new HttpGet("https://restcountries.com/v3.1/name/" + countryName + "?fullText=true");
	    	        HttpResponse countryResponse = httpClient.execute(countryRequest);
	    	        HttpEntity countryEntity = countryResponse.getEntity();
	    	        String countryResponseBody = EntityUtils.toString(countryEntity);

	    	        JSONArray countryJsonArray = new JSONArray(countryResponseBody);

	    	        if (countryJsonArray.length() > 0) {
	    	            JSONObject countryObject = countryJsonArray.getJSONObject(0);

	    	            JSONObject countryNamesObject = countryObject.getJSONObject("name");
	    	            String country = countryNamesObject.getString("common");

	    	            JSONObject currenciesObject = countryObject.getJSONObject("currencies");
	    	            String currency = currenciesObject.keys().next();

	    	            String currencyw = currenciesObject.keys().next();
				        System.out.println("Resposta gdp gdp: " + currency); 
				        
				        return currency;
	    	        }

	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
			return "mzn";


	    }
    

}
