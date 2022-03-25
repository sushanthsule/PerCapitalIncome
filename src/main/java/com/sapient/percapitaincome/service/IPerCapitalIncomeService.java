package com.sapient.percapitaincome.service;

import java.util.List;

import com.sapient.percapitaincome.model.AverageIncomeCity;
import com.sapient.percapitaincome.model.AverageIncomeCountry;

public interface IPerCapitalIncomeService {

	public List<AverageIncomeCountry> getAverageIncomeByCountryAndGender(List<AverageIncomeCity> averageIncomeCity, String currency);
}
