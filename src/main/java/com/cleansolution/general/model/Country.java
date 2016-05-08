package com.cleansolution.general.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "country", schema = "public")
@NamedQueries({
	@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
	@NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.countryId = :countryId"),
	@NamedQuery(name = "Country.findByNameEn", query = "SELECT c FROM Country c WHERE c.nameEn = :nameEn"),
	@NamedQuery(name = "Country.findByNameFr", query = "SELECT c FROM Country c WHERE c.nameFr = :nameFr"),})

public class Country implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "country_id", unique = true, nullable = false)
	private Integer countryId;
	@Column(name = "code")
	private Integer code;
	@Column(name = "alpha2", nullable = false, length = 2)
	private String alpha2;
	@Column(name = "alpha3", nullable = false, length = 3)
	private String alpha3;
	@Column(name = "name_en", nullable = false, length = 50)
	private String nameEn;
	@Column(name = "name_fr", length = 50)
	private String nameFr;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	@JsonIgnore
	private List<States> stateses;

	public Country() {
	}

	public Country(Integer countryId, String alpha2, String alpha3, String nameEn) {
		this.countryId = countryId;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.nameEn = nameEn;
	}

	public Country(Integer countryId, Integer code, String alpha2, String alpha3, String nameEn, String nameFr,
			List<States> stateses) {
		this.countryId = countryId;
		this.code = code;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
		this.nameEn = nameEn;
		this.nameFr = nameFr;
		this.stateses = stateses;
	}


	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getAlpha2() {
		return this.alpha2;
	}

	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}


	public String getAlpha3() {
		return this.alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}


	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}


	public String getNameFr() {
		return this.nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}


	public List<States> getStateses() {
		return this.stateses;
	}

	public void setStateses(List<States> stateses) {
		this.stateses = stateses;
	}


}