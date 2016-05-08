package com.cleansolution.general.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "party_relationship", schema = "public")
public class PartyRelationship implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "party_relationship_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer partyRelationshipId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "party_relationship_type_id")
	@JsonIgnore
	private PartyRelationshipType partyRelationshipType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_party_role_id")
	@JsonIgnore
	private PartyRole partyRoleByFromPartyRoleId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_party_role_id")
	@JsonIgnore
	private PartyRole partyRoleByToPartyRoleId;
	@Column(name = "description", length = 100)
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name = "from_date", nullable = false, length = 13)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "thru_date", length = 13)
	private Date thruDate;

	public PartyRelationship() {
	}

	public PartyRelationship(Integer partyRelationshipId, Date fromDate) {
		this.partyRelationshipId = partyRelationshipId;
		this.fromDate = fromDate;
	}

	public PartyRelationship(Integer partyRelationshipId, PartyRelationshipType partyRelationshipType,
			PartyRole partyRoleByFromPartyRoleId, PartyRole partyRoleByToPartyRoleId, String description, Date fromDate,
			Date thruDate) {
		this.partyRelationshipId = partyRelationshipId;
		this.partyRelationshipType = partyRelationshipType;
		this.partyRoleByFromPartyRoleId = partyRoleByFromPartyRoleId;
		this.partyRoleByToPartyRoleId = partyRoleByToPartyRoleId;
		this.description = description;
		this.fromDate = fromDate;
		this.thruDate = thruDate;
	}

	public Integer getPartyRelationshipId() {
		return this.partyRelationshipId;
	}

	public void setPartyRelationshipId(Integer partyRelationshipId) {
		this.partyRelationshipId = partyRelationshipId;
	}

	public PartyRelationshipType getPartyRelationshipType() {
		return this.partyRelationshipType;
	}

	public void setPartyRelationshipType(PartyRelationshipType partyRelationshipType) {
		this.partyRelationshipType = partyRelationshipType;
	}

	public PartyRole getPartyRoleByFromPartyRoleId() {
		return this.partyRoleByFromPartyRoleId;
	}

	public void setPartyRoleByFromPartyRoleId(PartyRole partyRoleByFromPartyRoleId) {
		this.partyRoleByFromPartyRoleId = partyRoleByFromPartyRoleId;
	}

	public PartyRole getPartyRoleByToPartyRoleId() {
		return this.partyRoleByToPartyRoleId;
	}

	public void setPartyRoleByToPartyRoleId(PartyRole partyRoleByToPartyRoleId) {
		this.partyRoleByToPartyRoleId = partyRoleByToPartyRoleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
