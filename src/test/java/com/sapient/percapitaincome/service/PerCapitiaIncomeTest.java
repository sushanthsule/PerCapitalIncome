package com.sapient.percapitaincome.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.percapitaincome.model.AverageIncomeCity;
import com.sapient.percapitaincome.model.AverageIncomeCountry;
import com.sapient.percapitaincome.util.AmountToUSD;
import com.sapient.percapitaincome.util.RateExchangeFactory;

@SpringBootTest
public class PerCapitiaIncomeTest {
	
	@Mock
	private RateExchangeFactory rateExchangeFactory;

	@Test
	void test_happy_path()
	{
		List<AverageIncomeCity> input = new ArrayList<AverageIncomeCity>();
		AverageIncomeCity avg1 = new AverageIncomeCity("Boston","USA","F","USD",49430D);
		AverageIncomeCity avg2 = new AverageIncomeCity("Houston","USA","M","USD",59994D);
		AverageIncomeCity avg3 = new AverageIncomeCity("Houston","USA","F","USD",46879D);
		input.add(avg1);
		input.add(avg2);
		input.add(avg3);
		
		when(rateExchangeFactory.getRateExchange("USD")).thenReturn(new AmountToUSD());
			
		
		
		List<AverageIncomeCountry> expectedOutput = new ArrayList<AverageIncomeCountry>();
		AverageIncomeCountry avg11 = new AverageIncomeCountry("USA","F",48154.5D);
		AverageIncomeCountry avg21 = new AverageIncomeCountry("USA","M",59994D);
		expectedOutput.add(avg11);
		expectedOutput.add(avg21);
		
		
		
		IPerCapitalIncomeService p = new PerCapitalIncomeService(rateExchangeFactory);
		List<AverageIncomeCountry> actualOutput = p.getAverageIncomeByCountryAndGender(input, "USD");
		
		verify(rateExchangeFactory).getRateExchange("USD");
		
		Assertions.assertEquals(expectedOutput, actualOutput);
		
		
	}
	
}
