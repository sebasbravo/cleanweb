package com.cleansolution.general.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee", schema = "public")
public class Employee implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "employee_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer employeeId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "party_role_id", nullable = false)
	@JsonIgnore
	private PartyRole partyRole;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supervisor_id")
	@JsonIgnore
	private Employee employee;
	@Column(name = "code_employee", length = 15)
	private String codeEmployee;
	@Column(name = "salary", precision = 131089, scale = 0)
	private BigDecimal salary;
	@Column(name = "commision_pct", precision = 131089, scale = 0)
	private BigDecimal commisionPct;
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	@JsonIgnore
	private List<Employee> employees ;
	/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	 * @JsonIgnore
	private List<Users> userses ;*/

	
	public Employee() {
	}

		public Employee(Integer employeeId, PartyRole partyRole) {
		this.employeeId = employeeId;
		this.partyRole = partyRole;
	}

	public Employee(Integer employeeId, PartyRole partyRole, Employee employee, String codeEmployee, BigDecimal salary,
			BigDecimal commisionPct, byte[] photo, List<Employee> employees
			//, List<Users> userses
			) {
		this.employeeId = employeeId;
		this.partyRole = partyRole;
		this.employee = employee;
		this.codeEmployee = codeEmployee;
		this.salary = salary;
		this.commisionPct = commisionPct;
		this.photo = photo;
		this.employees = employees;
		//this.userses = userses;
	}

		public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

		public PartyRole getPartyRole() {
		return this.partyRole;
	}

	public void setPartyRole(PartyRole partyRole) {
		this.partyRole = partyRole;
	}

		public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

		public String getCodeEmployee() {
		return this.codeEmployee;
	}

	public void setCodeEmployee(String codeEmployee) {
		this.codeEmployee = codeEmployee;
	}

		public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

		public BigDecimal getCommisionPct() {
		return this.commisionPct;
	}

	public void setCommisionPct(BigDecimal commisionPct) {
		this.commisionPct = commisionPct;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

/*	public List<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(LIst<Users> userses) {
		this.userses = userses;*/

}
