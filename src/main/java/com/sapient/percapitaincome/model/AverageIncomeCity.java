package com.sapient.percapitaincome.model;

public class AverageIncomeCity {

	private String city;
	private String country;
	private String gender;
	private String currency;
	private Double avgIncome;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(Double avgIncome) {
		this.avgIncome = avgIncome;
	}
	
	public AverageIncomeCity() {
		
	}
	public AverageIncomeCity(String city, String country, String gender, String currency, Double avgIncome) {
		super();
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.avgIncome = avgIncome;
	}
	@Override
	public String toString() {
		return "AverageIncomeCity [city=" + city + ", country=" + country + ", gender=" + gender + ", currency="
				+ currency + ", avgIncome=" + avgIncome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgIncome == null) ? 0 : avgIncome.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
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
		AverageIncomeCity other = (AverageIncomeCity) obj;
		if (avgIncome == null) {
			if (other.avgIncome != null)
				return false;
		} else if (!avgIncome.equals(other.avgIncome))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}
	
}
