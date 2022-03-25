package com.sapient.percapitaincome.util;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.sapient.percapitaincome.exception.RateExchangeException;

@Component
public class PerCapitiaIncomeUtils {
	
	
	public static JSONObject readexchangeRateJson(String key) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Resource resource = new ClassPathResource("exchangeRates.json");
			InputStream input = resource.getInputStream();
			
			File file = resource.getFile();
			
			Object obj = parser.parse(new FileReader(file));
			
			JSONObject json =  (JSONObject) obj;
			
			jsonObject = (JSONObject) json.get(key);
			
			
		}catch(Exception e) {
			throw new RateExchangeException("Error occured while reading exchange rate file : " +e.getMessage());
		}
		
		return jsonObject;
		
	}

}
