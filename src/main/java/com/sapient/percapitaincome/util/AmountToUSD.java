package com.sapient.percapitaincome.util;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AmountToUSD implements RateExchange{

	@Override
	public Double convertAsPerRate(String currency, Double amount) {
		
		JSONObject json = PerCapitiaIncomeUtils.readexchangeRateJson(IPerCapitiaIncomeConstants.CONVERTION_TO_USD);
		
		Double rate = (Double) json.get(currency);
		
		Double covertedAmount =amount * rate.doubleValue();
		
		return covertedAmount;
	}

}
