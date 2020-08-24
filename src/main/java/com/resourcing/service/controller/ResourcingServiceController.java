package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Account;
import com.resourcing.service.model.Role;
import com.resourcing.service.repository.AccountRepository;
import com.resourcing.service.repository.RoleRepository;


/**
 * The Class ResourcingServiceController.
 */
@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
public class ResourcingServiceController {

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Gets the all role.
	 *
	 * @return the all role
	 */
	@GetMapping("/role")
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	/**
	 * Gets the role by id.
	 *
	 * @param roleId the role id
	 * @return the role by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Integer roleId)
			throws ResourceNotFoundException {
		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleId));
		return ResponseEntity.ok().body(role);
	}

	/**
	 * Creates the role.
	 *
	 * @param role the role
	 * @return the role
	 */
	@PostMapping("/role")
	public Role createRole(@Valid @RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@PutMapping("/role")
	public Role updateRoleById(@Valid @RequestBody Role role)
			throws ResourceNotFoundException {
		Role roleToFind = roleRepository.findById(role.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + role.getId()));
		roleToFind.setEnabled(role.isEnabled());
		
		return roleRepository.save(role);
	}
	
	@PostMapping("/account")
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountRepository.save(account);
	}
	
}
