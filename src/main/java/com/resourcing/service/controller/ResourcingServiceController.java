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
	
	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Gets the all roles.
	 *
	 * @return the all roles
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
	
	/**
	 * Update role by id.
	 *
	 * @param role the role
	 * @return the role
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/role")
	public Role updateRoleById(@Valid @RequestBody Role role)
			throws ResourceNotFoundException {
		Role roleToFind = roleRepository.findById(role.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + role.getId()));
		roleToFind.setEnabled(role.isEnabled());
		
		return roleRepository.save(role);
	}
	
	/**
	 * Creates the account.
	 *
	 * @param account the account
	 * @return the account
	 */
	@PostMapping("/account")
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	
	/**
	 * Gets the all account.
	 *
	 * @return the all account
	 */
	@GetMapping("/account")
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
	
	/**
	 * Gets the account by id.
	 *
	 * @param accountId the account id
	 * @return the account by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") String accountId)
			throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
		return ResponseEntity.ok().body(account);
	}
	
	
	/**
	 * Update account by id.
	 *
	 * @param account the account
	 * @return the account
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/account")
	public Account updateAccountById(@Valid @RequestBody Account account)
			throws ResourceNotFoundException {
		Account accountToFind = accountRepository.findById(account.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account.getId()));
		accountToFind.setAccountName(account.getAccountName());
		
		return accountRepository.save(accountToFind);
	}
	
}
