package com.resourcing.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.resourcing.service.dto.AccountDto;
import com.resourcing.service.dto.RoleDto;
import com.resourcing.service.dto.SubUnitDto;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Account;
import com.resourcing.service.model.Role;
import com.resourcing.service.model.SubUnit;
import com.resourcing.service.model.VersionDetails;
import com.resourcing.service.repository.AccountRepository;
import com.resourcing.service.repository.LocationRepository;
import com.resourcing.service.repository.RoleRepository;
import com.resourcing.service.repository.SubUnitRepository;


/**
 * The Class ResourcingServiceController.
 */
@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceController {

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;
	
	/** The account repository. */
	@Autowired
	private AccountRepository accountRepository;
	
	/** The sub unit repository. */
	@Autowired
	private SubUnitRepository subUnitRepository;
	

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
	public Role createRole(@Valid @RequestBody RoleDto roleDto) {
		//avoid using @Entity object directly into @RequestMapping; vulnerable to malicious attack
		Role role = new Role();
		role.setName(roleDto.getName());
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
	public Role updateRoleById(@Valid @RequestBody RoleDto roleDto)
			throws ResourceNotFoundException {
		Role roleToFind = roleRepository.findById(roleDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + roleDto.getId()));
		roleToFind.setEnabled(roleDto.isEnabled());
		roleToFind.setName(roleDto.getName());
		return roleRepository.save(roleToFind);
	}
	
	/**
	 * Creates the account.
	 *
	 * @param account the account
	 * @return the account
	 */
	@PostMapping("/account")
	public Account createAccount(@Valid @RequestBody AccountDto accountDto) {
		Account account = new Account();
		account.setAccountName(accountDto.getAccountName());
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
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Integer accountId)
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
	public Account updateAccountById(@Valid @RequestBody AccountDto accountDto)
			throws ResourceNotFoundException {
		Account accountToFind = accountRepository.findById(accountDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountDto.getId()));
		accountToFind.setAccountName(accountDto.getAccountName());
		
		return accountRepository.save(accountToFind);
	}
	
	/**
	 * Creates the sub unit.
	 *
	 * @param accountId the account id
	 * @param subUnit the sub unit
	 * @return the sub unit
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PostMapping("/account/{accountId}/subunit")
    public SubUnit createSubUnit(@PathVariable(value = "accountId") Integer accountId,
        @Valid @RequestBody SubUnitDto subUnitDto) throws ResourceNotFoundException {
		SubUnit subUnit = new SubUnit();
		subUnit.setSubunitName(subUnitDto.getSubunitName());
        return accountRepository.findById(accountId).map(account -> {
        	subUnit.setAccount(account);
        	return subUnitRepository.save(subUnit);
        }).orElseThrow(() -> new ResourceNotFoundException("account not found"));
        
    }
	
	
	 /**
 	 * Gets the sub units by account.
 	 *
 	 * @param accountId the account id
 	 * @return the sub units by account
 	 */
 	@GetMapping("/account/{accountId}/subunit")
	public List <SubUnit> getSubUnitsByAccount(@PathVariable(value = "accountId") Integer accountId) {
	        return subUnitRepository.findByAccountId(accountId);
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
 	@PutMapping("/account/{accountId}/subunit/{subunitId}")
	public SubUnit updateSubUnit(@PathVariable(value = "accountId") Integer accountId,
	        @PathVariable(value = "subunitId") Integer subunitId, @Valid @RequestBody SubUnitDto subUnitDto)
	    throws ResourceNotFoundException {
 		SubUnit subUnitRequest = new SubUnit();
 		subUnitRequest.setId(subUnitDto.getId());
 		subUnitRequest.setSubunitName(subUnitDto.getSubunitName());
	        if (!accountRepository.existsById(accountId)) {
	            throw new ResourceNotFoundException("accountId not found");
	        }

	        return subUnitRepository.findById(subunitId).map(subUnit -> {
	        	subUnit.setSubunitName(subUnitRequest.getSubunitName());
	            return subUnitRepository.save(subUnit);
	        }).orElseThrow(() -> new ResourceNotFoundException("subUnit id not found"));
	 }
	 
 	
 	/**
	  * Gets the sub unit by account.
	  *
	  * @param accountId the account id
	  * @param subunitId the subunit id
	  * @return the sub unit by account
	  * @throws ResourceNotFoundException the resource not found exception
	  */
	 @GetMapping("/account/{accountId}/subunit/{subunitId}")
	public ResponseEntity<SubUnit> getSubUnitByAccount(@PathVariable(value = "accountId") Integer accountId,
	        @PathVariable(value = "subunitId") Integer subunitId)
	    throws ResourceNotFoundException {
	        if (!accountRepository.existsById(accountId)) {
	            throw new ResourceNotFoundException("accountId not found");
	        }

	        SubUnit subUnitVal = subUnitRepository.findById(subunitId)
	        		.orElseThrow(() -> new ResourceNotFoundException("SubUnit not found for this id :: " + subunitId));
			return ResponseEntity.ok().body(subUnitVal);
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
	@DeleteMapping("/account/{accountId}/subunit/{subunitId}")
	public ResponseEntity deleteSubUnit(@PathVariable(value = "accountId") Integer accountId,
	        @PathVariable(value = "subunitId") Integer subunitId) throws ResourceNotFoundException {
	        return subUnitRepository.findByIdAndAccountId(subunitId, accountId).map(subUnit -> {
	        	subUnitRepository.delete(subUnit);
	            return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new ResourceNotFoundException(
	            "subunit not found with id " + subunitId + " and accountId " + accountId));
	}
  	
  	/**
	   * Gets the version details.
	   *
	   * @return the version details
	   */
	  @GetMapping("/version")
  	public VersionDetails getVersionDetails(){
  		VersionDetails details = new VersionDetails();
  		details.setVersionNumber("20.08.01");
  		details.setVersionDate("08/24/2020");
  		
  		return details;
  	}
}
