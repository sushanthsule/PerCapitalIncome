package com.sapient.percapitaincome.util;

import org.springframework.stereotype.Component;

@Component
public class RateExchangeFactory {
	
	public RateExchange getRateExchange(String currency){
	      if(currency == null){
	         return null;
	      }		
	      if(currency.equalsIgnoreCase("USD")){
	         return new AmountToUSD();
	      }  
	      
	      return null;
	   }

}
