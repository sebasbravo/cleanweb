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
@Table(name = "party_relationship_type", schema = "public")
public class PartyRelationshipType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "party_relationship_type_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer partyRelationshipTypeId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_role_type_id")
	@JsonIgnore
	private RoleType roleTypeByFromRoleTypeId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_role_type_id")
	@JsonIgnore
	private RoleType roleTypeByToRoleTypeId;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "description", length = 100)
	private String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "partyRelationshipType")
	@JsonIgnore
	private List<PartyRelationship> partyRelationships;

	public PartyRelationshipType() {
	}

	public PartyRelationshipType(Integer partyRelationshipTypeId, String name) {
		this.partyRelationshipTypeId = partyRelationshipTypeId;
		this.name = name;
	}

	public PartyRelationshipType(Integer partyRelationshipTypeId, RoleType roleTypeByFromRoleTypeId,
			RoleType roleTypeByToRoleTypeId, String name, String description,
			List<PartyRelationship> partyRelationships) {
		this.partyRelationshipTypeId = partyRelationshipTypeId;
		this.roleTypeByFromRoleTypeId = roleTypeByFromRoleTypeId;
		this.roleTypeByToRoleTypeId = roleTypeByToRoleTypeId;
		this.name = name;
		this.description = description;
		this.partyRelationships = partyRelationships;
	}

	public Integer getPartyRelationshipTypeId() {
		return this.partyRelationshipTypeId;
	}

	public void setPartyRelationshipTypeId(Integer partyRelationshipTypeId) {
		this.partyRelationshipTypeId = partyRelationshipTypeId;
	}

	public RoleType getRoleTypeByFromRoleTypeId() {
		return this.roleTypeByFromRoleTypeId;
	}

	public void setRoleTypeByFromRoleTypeId(RoleType roleTypeByFromRoleTypeId) {
		this.roleTypeByFromRoleTypeId = roleTypeByFromRoleTypeId;
	}

	public RoleType getRoleTypeByToRoleTypeId() {
		return this.roleTypeByToRoleTypeId;
	}

	public void setRoleTypeByToRoleTypeId(RoleType roleTypeByToRoleTypeId) {
		this.roleTypeByToRoleTypeId = roleTypeByToRoleTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PartyRelationship> getPartyRelationships() {
		return this.partyRelationships;
	}

	public void setPartyRelationships(List<PartyRelationship> partyRelationships) {
		this.partyRelationships = partyRelationships;
	}

}
