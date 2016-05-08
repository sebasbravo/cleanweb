package com.cleansolution.general.dto;

import java.io.Serializable;

public class OrganizationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer partyId;
	private Integer organizationId;
	private String name;
	private String nis;
	
	private Integer addressId;
	private String phone;
	private String cel;
	private String email;
	private String website;
	private String taxFederal;
	private String taxProvincial;
	private Boolean status;
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getTaxFederal() {
		return taxFederal;
	}
	public void setTaxFederal(String taxFederal) {
		this.taxFederal = taxFederal;
	}
	public String getTaxProvincial() {
		return taxProvincial;
	}
	public void setTaxProvincial(String taxProvincial) {
		this.taxProvincial = taxProvincial;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	

}
