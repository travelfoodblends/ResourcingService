package com.resourcing.service.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class VersionDetails {

	private String versionNumber;
	
	private String versionDate;

	/**
	 * @return the versionNumber
	 */
	public String getVersionNumber() {
		return versionNumber;
	}

	/**
	 * @param versionNumber the versionNumber to set
	 */
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	/**
	 * @return the versionDate
	 */
	public String getVersionDate() {
		return versionDate;
	}

	/**
	 * @param versionDate the versionDate to set
	 */
	public void setVersionDate(String versionDate) {
		this.versionDate = versionDate;
	}
}
