package com.resourcing.service.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The Class Role.
 */
@Entity
@Table(name = "role")
public class Role {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id;
	
	/** The name. */
	@Column(name = "role_name", nullable = false)
	private String name;
	
	/** The enabled. */
	@Column(name = "role_enabled")
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
