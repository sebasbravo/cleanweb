package com.cleansolution.general.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cities", schema = "public")
@NamedQueries({
				@NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
				@NamedQuery(name = "Cities.findById", query = "SELECT c FROM Cities c WHERE c.cityId = :cityId"),
				@NamedQuery(name = "Cities.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")})
public class Cities implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "city_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer cityId;
	@JoinColumn(name = "state_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private States states;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "abbreviation", length = 5)
	private String abbreviation;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cities")
	@JsonIgnore
	private List<Address> addresses;

	public Cities() {
	}

	public Cities(Integer cityId, States states, String name) {
		this.cityId = cityId;
		this.states = states;
		this.name = name;
	}

	public Cities(Integer cityId, States states, String name, String abbreviation, List<Address> addresses) {
		this.cityId = cityId;
		this.states = states;
		this.name = name;
		this.abbreviation = abbreviation;
		this.addresses = addresses;
	}

	
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public States getStates() {
		return this.states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		Cities other = (Cities) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}
			

}