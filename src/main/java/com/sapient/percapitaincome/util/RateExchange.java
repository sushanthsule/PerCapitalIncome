package com.sapient.percapitaincome.util;

import org.springframework.stereotype.Component;

@Component
public interface RateExchange {

	public Double convertAsPerRate(String Currency, Double amount);
}
