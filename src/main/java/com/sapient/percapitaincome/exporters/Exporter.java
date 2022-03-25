package com.sapient.percapitaincome.exporters;

import java.util.List;

import com.sapient.percapitaincome.model.AverageIncomeCountry;

public interface Exporter {
	
	Export export(List<AverageIncomeCountry> averageIncomeCountryList);
}
