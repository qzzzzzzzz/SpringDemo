package com.fdmgroup.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GemDistributionId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1727589127518837667L;
	@Column(nullable = false)
    private String gem;

    @Column(nullable = false)
    private String country;
	
	public GemDistributionId(String gemName, String countryName) {
		this.gem = gemName;
		this.country = countryName;
	}
	
	public GemDistributionId() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gem == null) ? 0 : gem.hashCode());
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
		GemDistributionId other = (GemDistributionId) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gem == null) {
			if (other.gem != null)
				return false;
		} else if (!gem.equals(other.gem))
			return false;
		return true;
	}

	public String getGem() {
		return gem;
	}

	public void setGem(String gem) {
		this.gem = gem;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GemDistributionId [gem=" + gem + ", country=" + country + "]";
	}

	
}
