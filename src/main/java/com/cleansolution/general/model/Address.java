package com.cleansolution.general.model;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "address", schema = "public")
public class Address implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "address_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer addressId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", nullable = false)
	@JsonIgnore
	private Cities cities;
	@Column(name = "civic_address", nullable = false, length = 100)
	private String civicAddress;
	@Column(name = "apartment", length = 10)
	private String apartment;
	@Column(name = "postal_code", length = 10)
	private String postalCode;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	@JsonIgnore
	private List<PartyAddress> partyAddresses;

	
	public Address() {
	}

		public Address(Integer addressId, Cities cities, String civicAddress) {
		this.addressId = addressId;
		this.cities = cities;
		this.civicAddress = civicAddress;
	}

	
	public Address(Integer addressId, Cities cities, String civicAddress, String apartment, String postalCode,List<PartyAddress> partyAddresses) {
		this.addressId = addressId;
		this.cities = cities;
		this.civicAddress = civicAddress;
		this.apartment = apartment;
		this.postalCode = postalCode;
		this.partyAddresses = partyAddresses;
	}

	
		public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

		public Cities getCities() {
		return this.cities;
	}

	public void setCities(Cities cities) {
		this.cities = cities;
	}

		public String getCivicAddress() {
		return this.civicAddress;
	}

	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}


	public String getApartment() {
		return this.apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

		public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public List<PartyAddress> getPartyAddresses() {
		return partyAddresses;
	}

	public void setPartyAddresses(List<PartyAddress> partyAddresses) {
		this.partyAddresses = partyAddresses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		return true;
	}
	
	

}
