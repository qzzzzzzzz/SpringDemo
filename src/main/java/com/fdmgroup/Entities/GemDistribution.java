package com.fdmgroup.Entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gem_distribution")
public class GemDistribution {
	
	@EmbeddedId
    private GemDistributionId gdId;
	
	@ManyToOne
    @JoinColumn(name = "countryName")
    private Country country;
	
	@ManyToOne
    @JoinColumn(name = "gemName")
    private Gem gem;
	
	@Column
	private String extraInfo;
	
	public GemDistribution(GemDistributionId gdId, String extraInfo) {
		this.gdId = gdId;
		this.extraInfo = extraInfo;
	}

	public GemDistribution() {
		
	}

	public GemDistributionId getGdId() {
		return gdId;
	}

	public void setGdId(GemDistributionId gdId) {
		this.gdId = gdId;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extraInfo == null) ? 0 : extraInfo.hashCode());
		result = prime * result + ((gdId == null) ? 0 : gdId.hashCode());
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
		GemDistribution other = (GemDistribution) obj;
		if (extraInfo == null) {
			if (other.extraInfo != null)
				return false;
		} else if (!extraInfo.equals(other.extraInfo))
			return false;
		if (gdId == null) {
			if (other.gdId != null)
				return false;
		} else if (!gdId.equals(other.gdId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GemDistribution [gdId=" + gdId + ", extraInfo=" + extraInfo + "]";
	}

	
}
