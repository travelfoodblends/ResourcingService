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


/**
 * The Class WorkLocation.
 */
@Entity
@Table(name = "worklocation")
public class WorkLocation {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worklocation_id")
	private int id;
	
	/** The worklocation city. */
	@Column(name = "worklocation_city", nullable = false)
	private String worklocationCity;
	
	/** The worklocation state. */
	@Column(name = "worklocation_state", nullable = false)
	private String worklocationState;
	
	/** The worklocation country. */
	@Column(name = "worklocation_country", nullable = false)
	private String worklocationCountry;
	
	/** The location. */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
	private Location location;

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
	 * Gets the worklocation city.
	 *
	 * @return the worklocation city
	 */
	public String getWorklocationCity() {
		return worklocationCity;
	}

	/**
	 * Sets the worklocation city.
	 *
	 * @param worklocationCity the new worklocation city
	 */
	public void setWorklocationCity(String worklocationCity) {
		this.worklocationCity = worklocationCity;
	}

	/**
	 * Gets the worklocation state.
	 *
	 * @return the worklocation state
	 */
	public String getWorklocationState() {
		return worklocationState;
	}

	/**
	 * Sets the worklocation state.
	 *
	 * @param worklocationState the new worklocation state
	 */
	public void setWorklocationState(String worklocationState) {
		this.worklocationState = worklocationState;
	}

	/**
	 * Gets the worklocation country.
	 *
	 * @return the worklocation country
	 */
	public String getWorklocationCountry() {
		return worklocationCountry;
	}

	/**
	 * Sets the worklocation country.
	 *
	 * @param worklocationCountry the new worklocation country
	 */
	public void setWorklocationCountry(String worklocationCountry) {
		this.worklocationCountry = worklocationCountry;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
