package com.resourcing.service.dto;

public class SubUnitDto {

	private int id;
	
	private String subunitName;

	private AccountDto account;

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
	public AccountDto getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
	
}
