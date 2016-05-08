package com.cleansolution.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PartyAddressId implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "party_id", nullable = false)
	private Integer partyId;
	@Column(name = "address_id", nullable = false)
	private Integer addressId;

	
	public PartyAddressId() {
	}

	
	public PartyAddressId(Integer partyId, Integer addressId) {
		this.partyId = partyId;
		this.addressId = addressId;
	}


	public Integer getPartyId() {
		return this.partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

		public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PartyAddressId))
			return false;
		PartyAddressId castOther = (PartyAddressId) other;

		return ((this.getPartyId() == castOther.getPartyId()) || (this.getPartyId() != null
				&& castOther.getPartyId() != null && this.getPartyId().equals(castOther.getPartyId())))
				&& ((this.getAddressId() == castOther.getAddressId()) || (this.getAddressId() != null
						&& castOther.getAddressId() != null && this.getAddressId().equals(castOther.getAddressId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPartyId() == null ? 0 : this.getPartyId().hashCode());
		result = 37 * result + (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		return result;
	}
	
	

}
