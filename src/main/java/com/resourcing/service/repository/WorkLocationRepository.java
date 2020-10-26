package com.resourcing.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resourcing.service.model.WorkLocation;

/**
 * The Interface WorkLocationRepository.
 */
public interface WorkLocationRepository extends JpaRepository<WorkLocation, Integer> {


	/**
	 * Find by location id.
	 *
	 * @param id the id
	 * @return the list
	 */
	List<WorkLocation> findByLocationId(Integer id);
	
	/**
	 * Find by id and location id.
	 *
	 * @param workLocationId the work location id
	 * @param locationId the location id
	 * @return the optional
	 */
	Optional<WorkLocation> findByIdAndLocationId(Integer workLocationId, Integer locationId);
}
