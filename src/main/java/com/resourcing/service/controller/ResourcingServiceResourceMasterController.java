package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import com.resourcing.service.dto.ResourceMasterDto;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.ResourceMaster;
import com.resourcing.service.repository.ResourceMasterRepository;

@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceResourceMasterController {

	private ResourceMasterRepository resourceMasterRepository;
	
	ResourcingServiceResourceMasterController(ResourceMasterRepository resourceRepo){
		this.resourceMasterRepository = resourceRepo;
	}
	
	@GetMapping("/rgsMaster")
	public List<ResourceMaster> getAllLocations() {
		return resourceMasterRepository.findAll();
	}
	
	@GetMapping("/rgsMaster/{id}")
	public ResponseEntity<ResourceMaster> getRgsById(@PathVariable(value = "id") Integer rgsMasterId)
			throws ResourceNotFoundException {
		ResourceMaster resourceMaster = resourceMasterRepository.findById(rgsMasterId)
				.orElseThrow(() -> new ResourceNotFoundException("RGS not found for this id :: " + rgsMasterId));
		return ResponseEntity.ok().body(resourceMaster);
	}
	
	@PostMapping("/rgsMaster")
	public ResourceMaster createRgs(@Valid @RequestBody ResourceMasterDto resourceMasterDto) {
		//avoid using @Entity object directly into @RequestMapping; vulnerable to malicious attack
		ResourceMaster resouceMaster = new ResourceMaster();
		BeanUtils.copyProperties(resourceMasterDto, resouceMaster);
		return resourceMasterRepository.save(resouceMaster);
	}
	
	@PutMapping("/rgsMaster")
	public ResourceMaster updateRgsById(@Valid @RequestBody ResourceMasterDto resourceMasterDto)
			throws ResourceNotFoundException {
		ResourceMaster resourceMasterItemToFind = resourceMasterRepository.findById(resourceMasterDto.getResourceId())
				.orElseThrow(() -> new ResourceNotFoundException("Resouce not found for this id :: " + resourceMasterDto.getResourceId()));
		BeanUtils.copyProperties(resourceMasterDto, resourceMasterItemToFind);
		return resourceMasterRepository.save(resourceMasterItemToFind);
	}
}
