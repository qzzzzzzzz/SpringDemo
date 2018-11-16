package com.fdmgroup.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gem")
public class Gem {
	
	@Id //use gemName as pk
	private String gemName;
	@Column
	private String pictureLink;
	
	public Gem(String gemName, String pictureLink) {

		this.gemName = gemName;
		this.pictureLink = pictureLink;
	}

	public Gem() {
		//for JPA
	}
	
	public String getGemName() {
		return gemName;
	}

	public void setGemName(String gemName) {
		this.gemName = gemName;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemName == null) ? 0 : gemName.hashCode());
		result = prime * result + ((pictureLink == null) ? 0 : pictureLink.hashCode());
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
		Gem other = (Gem) obj;
		if (gemName == null) {
			if (other.gemName != null)
				return false;
		} else if (!gemName.equals(other.gemName))
			return false;
		if (pictureLink == null) {
			if (other.pictureLink != null)
				return false;
		} else if (!pictureLink.equals(other.pictureLink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gem [gemName=" + gemName + ", picture_link=" + pictureLink + "]";
	}
}
