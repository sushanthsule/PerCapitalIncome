package com.sapient.percapitaincome.datasource;

import java.util.List;

import com.sapient.percapitaincome.model.AverageIncomeCity;

public interface IDataSource {

	List<AverageIncomeCity> getData();
}
