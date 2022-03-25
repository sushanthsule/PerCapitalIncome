package com.sapient.percapitaincome.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sapient.percapitaincome.datasource.IDataSource;
import com.sapient.percapitaincome.model.AverageIncomeCity;
import com.sapient.percapitaincome.model.AverageIncomeCountry;
import com.sapient.percapitaincome.util.RateExchange;
import com.sapient.percapitaincome.util.RateExchangeFactory;

@Service
@Primary
public class PerCapitalIncomeService implements IPerCapitalIncomeService {
	
	private final RateExchangeFactory rateExchangeFactory;
	
	
	public PerCapitalIncomeService(RateExchangeFactory rateExchangeFactory) {
		super();
		this.rateExchangeFactory = rateExchangeFactory;
	}

	public List<AverageIncomeCountry> getAverageIncomeByCountryAndGender(List<AverageIncomeCity> averageIncomeCityList, String currency){
		
		
		List<AverageIncomeCity> averageIncomeCityListModified  = convertAsPerRateInData(averageIncomeCityList, currency);
		
		List<AverageIncomeCountry> averageIncomeCountryList = averagecalculationByGrouping(averageIncomeCityListModified);
		
		averageIncomeCountryList = sortingDataByCountryAndGender(averageIncomeCountryList);
		
		return averageIncomeCountryList;
	}
	
	private List<AverageIncomeCity> convertAsPerRateInData (List<AverageIncomeCity> averageIncomeCityList, String currency){
		RateExchange rateExchange = rateExchangeFactory.getRateExchange(currency);
		
		List<AverageIncomeCity> averageIncomeCityListModified  = new ArrayList<AverageIncomeCity>();
		for (AverageIncomeCity averageIncomeCity : averageIncomeCityList) {
			Double avgIncomeUpdated = rateExchange.convertAsPerRate(averageIncomeCity.getCurrency(), averageIncomeCity.getAvgIncome());
			averageIncomeCity.setAvgIncome(avgIncomeUpdated);
			averageIncomeCityListModified.add(averageIncomeCity);
		}
		return averageIncomeCityListModified;
	}

	private List<AverageIncomeCountry> averagecalculationByGrouping(List<AverageIncomeCity> averageIncomeCityListModified){
		
		List<AverageIncomeCountry> averageIncomeCountryList = new ArrayList<AverageIncomeCountry>();
		
		Map<String, Map<String, Double>> averageIncomeCityMap = averageIncomeCityListModified.stream().
				collect(Collectors.groupingBy(AverageIncomeCity::getCountry, Collectors.groupingBy(AverageIncomeCity::getGender, Collectors.averagingDouble(AverageIncomeCity::getAvgIncome))));



		for (Map.Entry<String,Map<String, Double>> entry : averageIncomeCityMap.entrySet()) {


			for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet()) {
				AverageIncomeCountry averageIncomeCountry = new AverageIncomeCountry();
				String gender = entry2.getKey();
				Double avg = entry2.getValue();
				averageIncomeCountry.setCountry(entry.getKey());
				averageIncomeCountry.setGender(gender);
				averageIncomeCountry.setAvgIncome(avg);
				averageIncomeCountryList.add(averageIncomeCountry);
			}
		}
		return averageIncomeCountryList;
	}
	
	private List<AverageIncomeCountry> sortingDataByCountryAndGender(List<AverageIncomeCountry> averageIncomeCountryList){
		Comparator<AverageIncomeCountry> compareByCountry = Comparator.comparing( AverageIncomeCountry::getCountry );
		 
		Comparator<AverageIncomeCountry> compareByGender = Comparator.comparing( AverageIncomeCountry::getGender );
				 
		Comparator<AverageIncomeCountry> compareByBoth = compareByCountry.thenComparing(compareByGender);
				 
		Collections.sort(averageIncomeCountryList, compareByBoth);
		
		return averageIncomeCountryList;
	}

}
