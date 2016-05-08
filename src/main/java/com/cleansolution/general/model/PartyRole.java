package com.cleansolution.general.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "party_role", schema = "public")
public class PartyRole implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "party_role_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer partyRoleId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "party_id")
	@JsonIgnore
	private Party party;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_type_id")
	private RoleType roleType;
	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", nullable = false, length = 13)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "thru_date", length = 13)
	private Date thruDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partyRoleByFromPartyRoleId")
	@JsonIgnore
	private List<PartyRelationship> partyRelationshipsForFromPartyRoleId ;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partyRoleByToPartyRoleId")
	@JsonIgnore
	private List<PartyRelationship> partyRelationshipsForToPartyRoleId ;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partyRole")
	@JsonIgnore
	private List<Employee> employees ;

	
	public PartyRole() {
	}

	
	public PartyRole(Integer partyRoleId, Date fromDate) {
		this.partyRoleId = partyRoleId;
		this.fromDate = fromDate;
	}

	
	public PartyRole(Integer partyRoleId, Party party, RoleType roleType, Date fromDate, Date thruDate,
			List<PartyRelationship> partyRelationshipsForFromPartyRoleId,
			List<PartyRelationship> partyRelationshipsForToPartyRoleId, List<Employee> employees) {
		this.partyRoleId = partyRoleId;
		this.party = party;
		this.roleType = roleType;
		this.fromDate = fromDate;
		this.thruDate = thruDate;
		this.partyRelationshipsForFromPartyRoleId = partyRelationshipsForFromPartyRoleId;
		this.partyRelationshipsForToPartyRoleId = partyRelationshipsForToPartyRoleId;
		this.employees = employees;
	}

	
		public Integer getPartyRoleId() {
		return this.partyRoleId;
	}

	public void setPartyRoleId(Integer partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

		public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
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

		public List<PartyRelationship> getPartyRelationshipsForFromPartyRoleId() {
		return this.partyRelationshipsForFromPartyRoleId;
	}

	public void setPartyRelationshipsForFromPartyRoleId(List<PartyRelationship> partyRelationshipsForFromPartyRoleId) {
		this.partyRelationshipsForFromPartyRoleId = partyRelationshipsForFromPartyRoleId;
	}

	public List<PartyRelationship> getPartyRelationshipsForToPartyRoleId() {
		return this.partyRelationshipsForToPartyRoleId;
	}

	public void setPartyRelationshipsForToPartyRoleId(List<PartyRelationship> partyRelationshipsForToPartyRoleId) {
		this.partyRelationshipsForToPartyRoleId = partyRelationshipsForToPartyRoleId;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result + ((partyRelationshipsForFromPartyRoleId == null) ? 0
				: partyRelationshipsForFromPartyRoleId.hashCode());
		result = prime * result
				+ ((partyRelationshipsForToPartyRoleId == null) ? 0 : partyRelationshipsForToPartyRoleId.hashCode());
		result = prime * result + ((partyRoleId == null) ? 0 : partyRoleId.hashCode());
		result = prime * result + ((roleType == null) ? 0 : roleType.hashCode());
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
		PartyRole other = (PartyRole) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (partyRelationshipsForFromPartyRoleId == null) {
			if (other.partyRelationshipsForFromPartyRoleId != null)
				return false;
		} else if (!partyRelationshipsForFromPartyRoleId.equals(other.partyRelationshipsForFromPartyRoleId))
			return false;
		if (partyRelationshipsForToPartyRoleId == null) {
			if (other.partyRelationshipsForToPartyRoleId != null)
				return false;
		} else if (!partyRelationshipsForToPartyRoleId.equals(other.partyRelationshipsForToPartyRoleId))
			return false;
		if (partyRoleId == null) {
			if (other.partyRoleId != null)
				return false;
		} else if (!partyRoleId.equals(other.partyRoleId))
			return false;
		if (roleType == null) {
			if (other.roleType != null)
				return false;
		} else if (!roleType.equals(other.roleType))
			return false;
		return true;
	}
	
	

}
