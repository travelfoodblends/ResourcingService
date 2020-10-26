package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.dto.WorkLocationDto;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.WorkLocation;
import com.resourcing.service.repository.LocationRepository;
import com.resourcing.service.repository.WorkLocationRepository;

@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceWorkLocationController {

	private WorkLocationRepository workLocationRepository;
	
	private LocationRepository locationRepository;
	
	ResourcingServiceWorkLocationController(WorkLocationRepository wlRepository, LocationRepository lcnRepository){
		this.workLocationRepository = wlRepository;
		this.locationRepository = lcnRepository;
	}
	
	
	@PostMapping("/workLocationService/{locationId}/workLocation")
    public WorkLocation createWorkLocation(@PathVariable(value = "locationId") Integer locationId,
        @Valid @RequestBody WorkLocationDto WworkLocationDto) throws ResourceNotFoundException {
		WorkLocation workLocation = new WorkLocation();
		workLocation.setWorklocationCity(WworkLocationDto.getWorklocationCity());
		workLocation.setWorklocationState(WworkLocationDto.getWorklocationState());
		workLocation.setWorklocationCountry(WworkLocationDto.getWorklocationCountry());
		
        return locationRepository.findById(locationId).map(location -> {
        	workLocation.setLocation(location);
        	return workLocationRepository.save(workLocation);
        }).orElseThrow(() -> new ResourceNotFoundException("work location not found"));
        
    }
	
	
	 /**
 	 * Gets the sub units by account.
 	 *
 	 * @param accountId the account id
 	 * @return the sub units by account
 	 */
 	@GetMapping("/workLocationService/{locationId}/workLocation")
	public List<WorkLocation> getWorkLocationByLocation(@PathVariable(value = "locationId") Integer locationId) {
	        return workLocationRepository.findByLocationId(locationId);
	}
	 
	 /**
 	 * Update sub unit.
 	 *
 	 * @param accountId the account id
 	 * @param subunitId the subunit id
 	 * @param subUnitRequest the sub unit request
 	 * @return the sub unit
 	 * @throws ResourceNotFoundException the resource not found exception
 	 */
 	@PutMapping("/workLocationService/{locationId}/workLocation/{workLocationId}")
	public WorkLocation updateWorkLocation(@PathVariable(value = "locationId") Integer locationId,
	        @PathVariable(value = "workLocationId") Integer workLocationId, @Valid @RequestBody WorkLocationDto workLocationDto)
	    throws ResourceNotFoundException {
 		WorkLocation workLocationRequest = new WorkLocation();
 		workLocationRequest.setId(workLocationDto.getId());
	        if (!locationRepository.existsById(locationId)) {
	            throw new ResourceNotFoundException("locationId not found");
	        }

	        return workLocationRepository.findById(workLocationId).map(workLocation -> {
	        	workLocation.setWorklocationCity(workLocationRequest.getWorklocationCity());
	        	workLocation.setWorklocationState(workLocationRequest.getWorklocationState());
	        	workLocation.setWorklocationCountry(workLocationRequest.getWorklocationCountry());
	        	
	            return workLocationRepository.save(workLocation);
	        }).orElseThrow(() -> new ResourceNotFoundException("worklocation id not found"));
	 }
	 
 	
 	/**
	  * Gets the sub unit by account.
	  *
	  * @param accountId the account id
	  * @param subunitId the subunit id
	  * @return the sub unit by account
	  * @throws ResourceNotFoundException the resource not found exception
	  */
	 @GetMapping("/workLocationService/{locationId}/workLocation/{workLocationId}")
	public ResponseEntity<WorkLocation> getWorkLocationByLocation(@PathVariable(value = "locationId") Integer locationId,
	        @PathVariable(value = "workLocationId") Integer workLocationId)
	    throws ResourceNotFoundException {
	        if (!locationRepository.existsById(locationId)) {
	            throw new ResourceNotFoundException("locationId not found");
	        }

	        WorkLocation workLocationVal = workLocationRepository.findById(workLocationId)
	        		.orElseThrow(() -> new ResourceNotFoundException("workLocation not found for this id :: " + workLocationId));
	        if(workLocationVal.getLocation() != null && workLocationVal.getLocation().getId() != locationId) {
	        	throw new ResourceNotFoundException("workLocation not found for this id :: " + workLocationId);
	        }else {
	        	return ResponseEntity.ok().body(workLocationVal);
	        }
	 }
	 
	  /**
  	 * Delete sub unit.
  	 *
  	 * @param accountId the account id
  	 * @param subunitId the subunit id
  	 * @return the response entity
  	 * @throws ResourceNotFoundException the resource not found exception
  	 */
  	@SuppressWarnings("rawtypes")
	@DeleteMapping("/workLocationService/{locationId}/workLocation/{workLocationId}")
	public ResponseEntity deleteWorkLocation(@PathVariable(value = "locationId") Integer locationId,
	        @PathVariable(value = "workLocationId") Integer workLocationId) throws ResourceNotFoundException {
	        return workLocationRepository.findByIdAndLocationId(workLocationId, locationId).map(workLocation -> {
	        	workLocationRepository.delete(workLocation);
	            return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new ResourceNotFoundException(
	            "worklocation not found with id " + workLocationId + " and locationId " + locationId));
	}
}
