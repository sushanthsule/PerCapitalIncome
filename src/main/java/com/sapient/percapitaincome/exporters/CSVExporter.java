package com.sapient.percapitaincome.exporters;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sapient.percapitaincome.model.AverageIncomeCountry;
import com.sapient.percapitaincome.util.IPerCapitiaIncomeConstants;

@Service
@Primary
public class CSVExporter implements Exporter{

	@Override
	public Export export(List<AverageIncomeCountry> averageIncomeCountryList) {
		Export export = new Export();
		export.setContentType("text/csv");
		export.setFileName(IPerCapitiaIncomeConstants.OUTPUT_FILE_NAME+".csv");
		
		
		String header = "City/Country,Gender,Average Income\n";
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		
		for (AverageIncomeCountry averageIncomeCountry : averageIncomeCountryList) {
			sb.append(averageIncomeCountry.toString()+"\n");
		}
		
		export.setContent(sb.toString());
		
		return export;
	}

}
