package com.resourcing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="subunit")
public class SubUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subunit_id")
	private int id;
	
	@Column(name = "subunit_name", nullable = false)
	private String subunitName;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
	private Account account;

	/**
	 * @return the subunitId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param subunitId the subunitId to set
	 */
	public void setId(int subunitId) {
		this.id = subunitId;
	}

	/**
	 * @return the subunitName
	 */
	public String getSubunitName() {
		return subunitName;
	}

	/**
	 * @param subunitName the subunitName to set
	 */
	public void setSubunitName(String subunitName) {
		this.subunitName = subunitName;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
