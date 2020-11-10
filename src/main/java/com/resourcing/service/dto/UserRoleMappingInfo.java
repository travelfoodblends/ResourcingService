package com.resourcing.service.dto;


/**
 * The Class UserRoleMappingInfo.
 */
public class UserRoleMappingInfo {
	
	/** The user role mapping id. */
	private Integer userRoleMappingId;

	/** The user id. */
	private Integer userId;
	
	/** The user name. */
	private String userName;
	
	/** The role id. */
	private Integer roleId;
	
	/** The role name. */
	private String roleName;
	
	/** The role enabled. */
	private boolean roleEnabled;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Checks if is role enabled.
	 *
	 * @return true, if is role enabled
	 */
	public boolean isRoleEnabled() {
		return roleEnabled;
	}

	/**
	 * Sets the role enabled.
	 *
	 * @param roleEnabled the new role enabled
	 */
	public void setRoleEnabled(boolean roleEnabled) {
		this.roleEnabled = roleEnabled;
	}

	/**
	 * Gets the user role mapping id.
	 *
	 * @return the user role mapping id
	 */
	public Integer getUserRoleMappingId() {
		return userRoleMappingId;
	}

	/**
	 * Sets the user role mapping id.
	 *
	 * @param userRoleMappingId the new user role mapping id
	 */
	public void setUserRoleMappingId(Integer userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	
}
