package com.cleansolution.general.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "states", schema = "public")
@NamedQueries({
	@NamedQuery(name = "States.findAll", query = "SELECT c FROM States c"),
	@NamedQuery(name = "States.findById", query = "SELECT c FROM States c WHERE c.stateId = :stateId"),
	@NamedQuery(name = "States.findByName", query = "SELECT c FROM States c WHERE c.name = :name"),
	@NamedQuery(name = "States.findByCountry", query = "SELECT c FROM States c JOIN  c.country p WHERE p.countryId = :countryId"),})

public class States implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="state_id", unique = true, nullable = false)
	private Integer stateId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false)
	@JsonIgnore
	private Country country;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "abbreviation", nullable = false, length = 5)
	private String abbreviation;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "states")
	private List<Cities> citieses;

	public States() {
	}

	public States(Integer stateId, Country country, String name, String abbreviation) {
		this.stateId = stateId;
		this.country = country;
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public States(Integer stateId, Country country, String name, String abbreviation, List<Cities> citieses) {
		this.stateId = stateId;
		this.country = country;
		this.name = name;
		this.abbreviation = abbreviation;
		this.citieses = citieses;
	}


	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
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


	public List<Cities> getCitieses() {
		return this.citieses;
	}

	public void setCitieses(List<Cities> citieses) {
		this.citieses = citieses;
	}


}