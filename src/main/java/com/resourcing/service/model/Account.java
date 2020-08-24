package com.resourcing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account")
public class Account {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@GeneratedValue(generator = "sequence_account_id")
	@GenericGenerator(name = "sequence_account_id", strategy = "com.resourcing.service.utility.CustomSeqIdGenerator")
//	@GenericGenerator(
//        name = "account_seq", 
//        strategy = "com.resourcing.service.utility.CustomSeqIdGenerator", 
//        parameters = {
//            @Parameter(name = CustomSeqIdGenerator.INCREMENT_PARAM, value = "50"),
//            @Parameter(name = CustomSeqIdGenerator.VALUE_PREFIX_PARAMETER, value = "ACNT_"),
//            @Parameter(name = CustomSeqIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	
	/** The account name. */
	@Column(name = "account_name", nullable = false)
	private String accountName;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	
	
}
