package com.sapient.percapitaincome.datasource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.sapient.percapitaincome.exception.DataSourceException;
import com.sapient.percapitaincome.model.AverageIncomeCity;

@Service
@Primary
public class CSVDataSource implements IDataSource {

	@Override
	public List<AverageIncomeCity> getData() {
		// TODO Auto-generated method stub
		List<AverageIncomeCity> data = new ArrayList<AverageIncomeCity>();
		
		try {
			Resource resource = new ClassPathResource("Sample_Input.csv");

			InputStream input = resource.getInputStream();

			File file = resource.getFile();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> lines = new ArrayList<>();
			String line = null;
			boolean firstline = true;
			while ((line = reader.readLine()) != null) {
				if(firstline) {
					firstline = false;
				}else {
					data.add(convertStringArrayToObj(line.split(",")));
				}
			}
		
		}catch (Exception e) {
			
			throw new DataSourceException(e.getMessage());
		}
		

		 
		return data;
	}
		
		private AverageIncomeCity convertStringArrayToObj(String[] array) {
			AverageIncomeCity averageIncomeCity = new AverageIncomeCity();
			
			if(array[0] != null && array[0] != "")
				averageIncomeCity.setCity(array[0]);
			if(array[1] != null && array[1] != "")
				averageIncomeCity.setCountry(array[1]);
			if(array[2] != null && array[2] != "")
				averageIncomeCity.setGender(array[2]);
			if(array[3] != null && array[3] != "")
				averageIncomeCity.setCurrency(array[3]);
			if(array[4] != null && array[4] != "")
				averageIncomeCity.setAvgIncome(Double.parseDouble(array[4]));
			
			if(averageIncomeCity.getCountry() == null || averageIncomeCity.getCountry().equalsIgnoreCase("")) {
				averageIncomeCity.setCountry(averageIncomeCity.getCity());
			}
			
			return averageIncomeCity;
		}

}
