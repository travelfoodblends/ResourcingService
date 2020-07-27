package com.resourcing.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	private int id;
	private String name;
	private boolean enabled;
	
	
	/**
	 * @return the id
	 */
	@Id
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the enabled
	 */
	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
	}
	
}
