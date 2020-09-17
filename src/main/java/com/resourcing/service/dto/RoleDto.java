package com.resourcing.service.dto;

/**
 * The Class Role.
 */
public class RoleDto {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The enabled. */
	private boolean enabled = true;
	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
	}
	
}
