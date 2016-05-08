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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "person", schema = "public")
public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	//@PrimaryKeyJoinColumn
	@JoinColumn(name = "party_id")
	@JsonIgnore
	private Party party;
	@Column(name = "first_name_1", nullable = false, length = 40)
	private String firstName1;
	@Column(name = "first_name_2", length = 40)
	private String firstName2;
	@Column(name = "last_name_1", nullable = false, length = 15)
	private String lastName1;
	@Column(name = "last_name_2", length = 15)
	private String lastName2;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 13)
	private Date birthdate;
	@Column(name = "nas", length = 15)
	private String nas;
	@Column(name = "num_driving_licence", length = 20)
	private String numDrivingLicence;
	@Column(name = "num_medical_insurance", length = 20)
	private String numMedicalInsurance;
	@Column(name = "actif")
	private Boolean actif;
	@Column(name = "gender", length = 2)
	private String gender;

	public Person() {
	}

	public Person( Party party, String firstName1, String lastName1) {
		
		this.party = party;
		this.firstName1 = firstName1;
		this.lastName1 = lastName1;
	}

	public Person(Integer partyId, Party party, String firstName1, String firstName2, String lastName1, String lastName2,
			Date birthdate, String nas, String numDrivingLicence, String numMedicalInsurance, Boolean actif,
			String gender) {
		
		this.party = party;
		this.firstName1 = firstName1;
		this.firstName2 = firstName2;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.birthdate = birthdate;
		this.nas = nas;
		this.numDrivingLicence = numDrivingLicence;
		this.numMedicalInsurance = numMedicalInsurance;
		this.actif = actif;
		this.gender = gender;
	}


	
	public Party getParty() {
		return this.party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getFirstName1() {
		return this.firstName1;
	}

	public void setFirstName1(String firstName1) {
		this.firstName1 = firstName1;
	}

	public String getFirstName2() {
		return this.firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	public String getLastName1() {
		return this.lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return this.lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNas() {
		return this.nas;
	}

	public void setNas(String nas) {
		this.nas = nas;
	}

	public String getNumDrivingLicence() {
		return this.numDrivingLicence;
	}

	public void setNumDrivingLicence(String numDrivingLicence) {
		this.numDrivingLicence = numDrivingLicence;
	}

	public String getNumMedicalInsurance() {
		return this.numMedicalInsurance;
	}

	public void setNumMedicalInsurance(String numMedicalInsurance) {
		this.numMedicalInsurance = numMedicalInsurance;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	

}
