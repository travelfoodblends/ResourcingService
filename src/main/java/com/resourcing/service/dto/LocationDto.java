package com.resourcing.service.dto;

import java.util.List;


/**
 * The Class LocationDto.
 */
public class LocationDto {

	/** The id. */
	private int id;
	
	/** The location name. */
	private String locationName;

	/** The work location. */
	private List <WorkLocationDto> workLocation;

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
	 * Gets the location name.
	 *
	 * @return the location name
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the location name.
	 *
	 * @param locationName the new location name
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * Gets the work location.
	 *
	 * @return the work location
	 */
	public List<WorkLocationDto> getWorkLocation() {
		return workLocation;
	}

	/**
	 * Sets the work location.
	 *
	 * @param workLocation the new work location
	 */
	public void setWorkLocation(List<WorkLocationDto> workLocation) {
		this.workLocation = workLocation;
	}
}
