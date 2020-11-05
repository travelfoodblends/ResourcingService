package com.resourcing.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.model.RateCard;


/**
 * The Interface RateCardRepository.
 */
@Repository
@XRayEnabled
public interface RateCardRepository extends JpaRepository<RateCard, Integer> {

	/**
	 * Find by account id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<RateCard> findByAccountId(Integer id);
	
	/**
	 * Find by location id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<RateCard> findByLocationId(Integer id);

}
