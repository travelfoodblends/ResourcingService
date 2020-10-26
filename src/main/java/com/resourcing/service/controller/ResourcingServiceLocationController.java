package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.dto.LocationDto;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Location;
import com.resourcing.service.repository.LocationRepository;

@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceLocationController {

	
	private LocationRepository locationRepository;
	
	ResourcingServiceLocationController(LocationRepository lcnRepo){
		this.locationRepository = lcnRepo;
	}
	
	
	/**
	 * Gets the all roles.
	 *
	 * @return the all roles
	 */
	@GetMapping("/location")
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	/**
	 * Gets the role by id.
	 *
	 * @param roleId the role id
	 * @return the role by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/location/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable(value = "id") Integer locationId)
			throws ResourceNotFoundException {
		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + locationId));
		return ResponseEntity.ok().body(location);
	}

	/**
	 * Creates the role.
	 *
	 * @param role the role
	 * @return the role
	 */
	@PostMapping("/location")
	public Location createLocation(@Valid @RequestBody LocationDto locationDto) {
		//avoid using @Entity object directly into @RequestMapping; vulnerable to malicious attack
		Location location = new Location();
		location.setLocationName(locationDto.getLocationName());
		return locationRepository.save(location);
	}
	
	/**
	 * Update role by id.
	 *
	 * @param role the role
	 * @return the role
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/location")
	public Location updateLocationById(@Valid @RequestBody LocationDto locationDto)
			throws ResourceNotFoundException {
		Location locationToFind = locationRepository.findById(locationDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + locationDto.getId()));
		locationToFind.setLocationName(locationDto.getLocationName());
		return locationRepository.save(locationToFind);
	}
}
