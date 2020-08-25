package com.resourcing.service.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "account")
public class Account {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int id;
	
	@Column(name = "account_name", nullable = false)
	private String accountName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@JsonIgnore
	private List <SubUnit> subUnit;

	/**
	 * @return the accountId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the subUnit
	 */
	public List<SubUnit> getSubUnit() {
		return subUnit;
	}

	/**
	 * @param subUnit the subUnit to set
	 */
	public void setSubUnit(List<SubUnit> subUnit) {
		this.subUnit = subUnit;
	}
	
	
	
	
	
}
