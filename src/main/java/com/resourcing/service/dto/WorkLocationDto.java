package com.resourcing.service.dto;

/**
 * The Class WorkLocationDto.
 */
public class WorkLocationDto {

	/** The id. */
	private int id;

	/** The worklocation city. */
	private String worklocationCity;

	/** The worklocation state. */
	private String worklocationState;

	/** The worklocation country. */
	private String worklocationCountry;

	/** The location. */
	private LocationDto location;

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
	public LocationDto getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(LocationDto location) {
		this.location = location;
	}
}
