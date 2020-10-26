package com.resourcing.service.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ratecard")
public class RateCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ratecard_id")
	private int id;
	
	@Column(name = "ratecard_category", nullable = false)
	private String category;
	
	@Column(name = "ratecard_rate", nullable = false)
	private float rate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
	private Location location;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
	private Account account;

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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(float rate) {
		BigDecimal bd = new BigDecimal(Float.toString(rate));
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.rate = rate;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
