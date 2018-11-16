package com.fdmgroup.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "search_record")
public class Search {
	
	@Id 
	private int searchId;
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	@ManyToOne
	@JoinColumn(name="gemName")
	private Gem gem;
	@ManyToOne
	@JoinColumn(name="countryName")
	private Country country;
	@Column
	private int searchByGem; //1 = searchByGem, 0 = searchByCountry
	
	public Search(int searchId, User user, Gem gem, Country country, int searchByGem) {
		
		if (searchByGem == 1) {
			
			this.searchId = searchId;
			this.user = user;
			this.gem = gem;
			this.country = null;
			this.searchByGem = searchByGem;
		
		}else {
			
			this.searchId = searchId;
			this.user = user;
			this.country = country;
			this.gem = null;
			this.searchByGem = searchByGem;
		}
	}
	
	public Search() {
		
		
	}
	
	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gem getGem() {
		return gem;
	}

	public void setGem(Gem gem) {
		this.gem = gem;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getSearchByGem() {
		return searchByGem;
	}

	public void setSearchByGem(int searchByGem) {
		this.searchByGem = searchByGem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gem == null) ? 0 : gem.hashCode());
		result = prime * result + searchByGem;
		result = prime * result + searchId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Search other = (Search) obj;
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
		if (searchByGem != other.searchByGem)
			return false;
		if (searchId != other.searchId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		if (searchByGem == 1) {
			
			return "Search [search_id=" + searchId + ", user=" + user + ", gem=" + gem + ", searchByGem]";
		
		}else {
			
			return "Search [search_id=" + searchId + ", user=" + user + ", country=" + country + ", searchByCountry]";
		}
	}
	
	
	
	
}
