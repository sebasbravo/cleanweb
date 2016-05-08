package com.cleansolution.general.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "organization", schema = "public")
@NamedQueries({
	@NamedQuery(name = "Organization.findAll", query = "SELECT c FROM Organization c"),
	@NamedQuery(name = "Organization.findByName", query = "SELECT c FROM Organization c WHERE c.name = :name"),
	@NamedQuery(name = "Organization.findByNis", query = "SELECT c FROM Organization c WHERE c.nis = :nis"),
	//@NamedQuery(name = "Organization.findByPartyId", query = "SELECT c FROM Organization c WHERE c.partyId = :partyId"),
})
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(name="generator", strategy="foreign", 
    		parameters=@Parameter(name="property", value="party"))
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "party_id")
	//@PrimaryKeyJoinColumn(name = "party_id")
	@JsonIgnore
	private Party party;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "nis", length = 15)
	private String nis;

	public Organization() {
	}

	public Organization( Party party, String name) {
		
		this.party = party;
		this.name = name;
	}

	public Organization( Party party, String name, String nis) {
		
		this.party = party;
		this.name = name;
		this.nis = nis;
	}

	

	
	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNis() {
		return this.nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}


	
	

}
