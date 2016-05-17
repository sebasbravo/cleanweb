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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "party", schema = "public")
@NamedQueries({
	@NamedQuery(name = "Party.findByPartyId", query = "SELECT c FROM Party c WHERE c.partyId = :partyId")
})
public class Party implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "party_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer partyId;
	@Column(name = "phone", length = 15)
	private String phone;
	@Column(name = "cel", length = 15)
	private String cel;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "website", length = 100)
	private String website;
	@Column(name = "tax_federal", length = 15)
	private String taxFederal;
	@Column(name = "tax_provincial", length = 15)
	private String taxProvincial;
	@Column(name = "status")
	private Boolean status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
	@JsonIgnore
	private List<Person> persons;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
	@JsonIgnore
	private List<PartyRole> partyRoles;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
	@JsonIgnore
	private List<Organization> organizations;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
	@JsonIgnore
	private List<PartyAddress> partyAddresses;
	

	public Party() {
	}

	public Party(Integer partyId) {
		this.partyId = partyId;
	}

	public Party(Integer partyId, String phone, String cel, String email, String website,
			String taxFederal, String taxProvincial, Boolean status, List<Person> persons, List<PartyRole> partyRoles,
			List<Organization> organizations, List<PartyAddress> partyAddresses) {
		this.partyId = partyId;
		this.partyAddresses = partyAddresses;
		this.phone = phone;
		this.cel = cel;
		this.email = email;
		this.website = website;
		this.taxFederal = taxFederal;
		this.taxProvincial = taxProvincial;
		this.status = status;
		this.persons = persons;
		this.partyRoles = partyRoles;
		this.organizations = organizations;
	}

	public Integer getPartyId() {
		return this.partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCel() {
		return this.cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTaxFederal() {
		return this.taxFederal;
	}

	public void setTaxFederal(String taxFederal) {
		this.taxFederal = taxFederal;
	}

	public String getTaxProvincial() {
		return this.taxProvincial;
	}

	public void setTaxProvincial(String taxProvincial) {
		this.taxProvincial = taxProvincial;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<PartyRole> getPartyRoles() {
		return this.partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

		public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
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
		result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
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
		Party other = (Party) obj;
		if (partyId == null) {
			if (other.partyId != null)
				return false;
		} else if (!partyId.equals(other.partyId))
			return false;
		return true;
	}

	
	
	
}
