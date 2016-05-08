package com.cleansolution.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role_type", schema = "public")
public class RoleType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_type_id", unique = true, nullable = false)
	private Integer roleTypeId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_role_type_id")
	@JsonIgnore
	private RoleType roleType;
	@Column(name = "name", length = 40)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleType")
	@JsonIgnore
	private List<RoleType> roleTypes;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleType")
	@JsonIgnore
	private List<PartyRole> partyRoles;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleTypeByToRoleTypeId")
	@JsonIgnore
	private List<PartyRelationshipType> partyRelationshipTypesForToRoleTypeId;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleTypeByFromRoleTypeId")
	@JsonIgnore
	private List<PartyRelationshipType> partyRelationshipTypesForFromRoleTypeId;

	public RoleType() {
	}

	public RoleType(Integer roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public RoleType(Integer roleTypeId, RoleType roleType, String name, List<RoleType> roleTypes,
			List<PartyRole> partyRoles, List<PartyRelationshipType> partyRelationshipTypesForToRoleTypeId,
			List<PartyRelationshipType> partyRelationshipTypesForFromRoleTypeId) {
		this.roleTypeId = roleTypeId;
		this.roleType = roleType;
		this.name = name;
		this.roleTypes = roleTypes;
		this.partyRoles = partyRoles;
		this.partyRelationshipTypesForToRoleTypeId = partyRelationshipTypesForToRoleTypeId;
		this.partyRelationshipTypesForFromRoleTypeId = partyRelationshipTypesForFromRoleTypeId;
	}

	public Integer getRoleTypeId() {
		return this.roleTypeId;
	}

	public void setRoleTypeId(Integer roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleType> getRoleTypes() {
		return this.roleTypes;
	}

	public void setRoleTypes(List<RoleType> roleTypes) {
		this.roleTypes = roleTypes;
	}

	public List<PartyRole> getPartyRoles() {
		return this.partyRoles;
	}

	public void setPartyRoles(List<PartyRole> partyRoles) {
		this.partyRoles = partyRoles;
	}

	public List<PartyRelationshipType> getPartyRelationshipTypesForToRoleTypeId() {
		return this.partyRelationshipTypesForToRoleTypeId;
	}

	public void setPartyRelationshipTypesForToRoleTypeId(
			List<PartyRelationshipType> partyRelationshipTypesForToRoleTypeId) {
		this.partyRelationshipTypesForToRoleTypeId = partyRelationshipTypesForToRoleTypeId;
	}

	public List<PartyRelationshipType> getPartyRelationshipTypesForFromRoleTypeId() {
		return this.partyRelationshipTypesForFromRoleTypeId;
	}

	public void setPartyRelationshipTypesForFromRoleTypeId(
			List<PartyRelationshipType> partyRelationshipTypesForFromRoleTypeId) {
		this.partyRelationshipTypesForFromRoleTypeId = partyRelationshipTypesForFromRoleTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleTypeId == null) ? 0 : roleTypeId.hashCode());
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
		RoleType other = (RoleType) obj;
		if (roleTypeId == null) {
			if (other.roleTypeId != null)
				return false;
		} else if (!roleTypeId.equals(other.roleTypeId))
			return false;
		return true;
	}
	
	

}
