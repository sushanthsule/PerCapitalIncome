package com.sapient.percapitaincome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.percapitaincome.datasource.IDataSource;
import com.sapient.percapitaincome.exporters.Export;
import com.sapient.percapitaincome.exporters.Exporter;
import com.sapient.percapitaincome.model.AverageIncomeCountry;
import com.sapient.percapitaincome.service.IPerCapitalIncomeService;

@RestController
public class PerCapitalIncomeController {
	
	
	private final IPerCapitalIncomeService perCapitalIncomeService;
	
	private final IDataSource dataSource;
	
	private final Exporter exporterService;
	
	public PerCapitalIncomeController(IPerCapitalIncomeService perCapitalIncomeService, IDataSource dataSource,
			Exporter exporterService) {
		super();
		this.perCapitalIncomeService = perCapitalIncomeService;
		this.dataSource = dataSource;
		this.exporterService = exporterService;
	}




	@GetMapping("/percapitiaIncome")
	public ResponseEntity<?> exportSummary(@RequestParam(value="currency", required = false, defaultValue = "USD") String currency) {
		
		
		
		List<AverageIncomeCountry> averageIncomeCountryList = perCapitalIncomeService.getAverageIncomeByCountryAndGender(dataSource.getData(), currency);
		
		Export export = exporterService.export(averageIncomeCountryList);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", export.getContentType());
		responseHeaders.add("Content-Disposition", "attachment; filename="+export.getFileName());
		
		return new ResponseEntity<>(export.getContent().getBytes(), responseHeaders, HttpStatus.OK);
	}

}
