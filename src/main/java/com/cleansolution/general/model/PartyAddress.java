package com.cleansolution.general.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "party_address", schema = "public")
public class PartyAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "partyId", column = @Column(name = "party_id", nullable = false)),
			@AttributeOverride(name = "addressId", column = @Column(name = "address_id", nullable = false)) })
	private PartyAddressId id;
	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", length = 13)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "thru_date", length = 13)
	private Date thruDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "party_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Party party;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Address address;

	public PartyAddress() {
	}

	public PartyAddress(PartyAddressId id,  Party party, Address address) {
		this.id = id;
		this.party = party;
		this.address = address;
	}

	public PartyAddress(PartyAddressId id, Date fromDate, Date thruDate,Party party, Address address) {
		this.id = id;
		this.fromDate = fromDate;
		this.thruDate = thruDate;
		this.party = party;
		this.address = address;
	}

	public PartyAddressId getId() {
		return this.id;
	}

	public void setId(PartyAddressId id) {
		this.id = id;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getThruDate() {
		return this.thruDate;
	}

	public void setThruDate(Date thruDate) {
		this.thruDate = thruDate;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((party == null) ? 0 : party.hashCode());
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
		PartyAddress other = (PartyAddress) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		return true;
	}
	
	

}
