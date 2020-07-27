package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Role;
import com.resourcing.service.repository.RoleRepository;


/**
 * The Class ResourcingServiceController.
 */
@RestController
@RequestMapping("/resourcingService")
public class ResourcingServiceController {

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@GetMapping("/role")
	public List<Role> getAllEmployees() {
		return roleRepository.findAll();
	}

	/**
	 * Gets the employee by id.
	 *
	 * @param roleId the role id
	 * @return the employee by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getEmployeeById(@PathVariable(value = "id") Integer roleId)
			throws ResourceNotFoundException {
		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));
		return ResponseEntity.ok().body(role);
	}

	/**
	 * Creates the employee.
	 *
	 * @param role the role
	 * @return the role
	 */
	@PostMapping("/role")
	public Role createEmployee(@Valid @RequestBody Role role) {
		return roleRepository.save(role);
	}
}
