package com.sapient.percapitaincome.model;

public class AverageIncomeCountry {
	
	private String country;
	private String gender;
	private Double avgIncome;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Double getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(Double avgIncome) {
		this.avgIncome = avgIncome;
	}

	@Override
	public String toString() {
		return country +","+ gender +","+ avgIncome ;
	}
	
	public AverageIncomeCountry() {
		
	}
	public AverageIncomeCountry(String country, String gender, Double avgIncome) {
		super();
		this.country = country;
		this.gender = gender;
		this.avgIncome = avgIncome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgIncome == null) ? 0 : avgIncome.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AverageIncomeCountry other = (AverageIncomeCountry) obj;
		if (avgIncome == null) {
			if (other.avgIncome != null)
				return false;
		} else if (!avgIncome.equals(other.avgIncome))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}
}
