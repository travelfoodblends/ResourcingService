package com.resourcing.service.dto;

import java.util.List;


public class AccountDto {
	
	private int id;
	
	private String accountName;

	private List <SubUnitDto> subUnit;

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
	public List<SubUnitDto> getSubUnit() {
		return subUnit;
	}

	/**
	 * @param subUnit the subUnit to set
	 */
	public void setSubUnit(List<SubUnitDto> subUnit) {
		this.subUnit = subUnit;
	}
	
	
	
	
	
}
