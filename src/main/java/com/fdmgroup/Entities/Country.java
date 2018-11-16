package com.fdmgroup.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id //use countryName as pk
	private String countryName;
	@Column
	private String continent;
	private String countryMap;
	
	public Country(String countryName, String continent, String countryMap) {

		this.countryName = countryName;
		this.continent = continent;
		this.countryMap = countryMap;
	}
	
	public Country() {
		
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountryMap() {
		return countryMap;
	}

	public void setCountryMap(String countryMap) {
		this.countryMap = countryMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((countryMap == null) ? 0 : countryMap.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
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
		Country other = (Country) obj;
		if (continent == null) {
			if (other.continent != null)
				return false;
		} else if (!continent.equals(other.continent))
			return false;
		if (countryMap == null) {
			if (other.countryMap != null)
				return false;
		} else if (!countryMap.equals(other.countryMap))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", continent=" + continent + ", countryMap=" + countryMap + "]";
	}
	
	
}
