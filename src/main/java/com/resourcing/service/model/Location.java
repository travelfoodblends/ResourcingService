/**
 * 
 */
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


@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private int id;
	
	@Column(name = "location_name", nullable = false)
	private String locationName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	@JsonIgnore
	private List <WorkLocation> workLocation;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	@JsonIgnore
	private List <RateCard> rateCard;

	/**
	 * @return the id
	 */
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
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the workLocation
	 */
	public List<WorkLocation> getWorkLocation() {
		return workLocation;
	}

	/**
	 * @param workLocation the workLocation to set
	 */
	public void setWorkLocation(List<WorkLocation> workLocation) {
		this.workLocation = workLocation;
	}

	/**
	 * @return the rateCard
	 */
	public List<RateCard> getRateCard() {
		return rateCard;
	}

	/**
	 * @param rateCard the rateCard to set
	 */
	public void setRateCard(List<RateCard> rateCard) {
		this.rateCard = rateCard;
	}
	
	
}
