package com.resourcing.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import com.resourcing.service.dto.UserAccountMappingDto;
import com.resourcing.service.dto.UserDto;
import com.resourcing.service.dto.UserRoleAccountMappingDto;
import com.resourcing.service.dto.UserRoleMappingInfo;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Account;
import com.resourcing.service.model.Role;
import com.resourcing.service.model.User;
import com.resourcing.service.model.UserAccountMapping;
import com.resourcing.service.model.UserRoleMapping;
import com.resourcing.service.repository.AccountRepository;
import com.resourcing.service.repository.RoleRepository;
import com.resourcing.service.repository.UserAccountMappingRepository;
import com.resourcing.service.repository.UserRepository;
import com.resourcing.service.repository.UserRoleMappingRepository;

/**
 * The Class ResourcingServiceUserController.
 */
@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceUserController {

	/** The user repository. */
	private UserRepository userRepository;
	
	/** The user role mapping repository. */
	private UserRoleMappingRepository userRoleMappingRepository;
	
	/** The user account mapping repository. */
	private UserAccountMappingRepository userAccountMappingRepository;
	
	/** The role repository. */
	private RoleRepository roleRepository;
	
	/** The account repository. */
	private AccountRepository accountRepository;
	
	/**
	 * Instantiates a new resourcing service user controller.
	 *
	 * @param userRepo the user repo
	 * @param userRoleMapRepo the user role map repo
	 * @param roleRepo the role repo
	 * @param accountRepository the account repository
	 * @param userAccountMappingRepository the user account mapping repository
	 */
	ResourcingServiceUserController(UserRepository userRepo, UserRoleMappingRepository userRoleMapRepo, 
			RoleRepository roleRepo, AccountRepository accountRepository, 
			UserAccountMappingRepository userAccountMappingRepository){
		this.userRepository = userRepo;
		this.userRoleMappingRepository = userRoleMapRepo;
		this.roleRepository = roleRepo;
		this.accountRepository = accountRepository;
		this.userAccountMappingRepository = userAccountMappingRepository;
	}
	
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	
	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}


	/**
	 * Creates the user.
	 *
	 * @param userDto the user dto
	 * @return the user
	 */
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody UserDto userDto) {
		//avoid using @Entity object directly into @RequestMapping; vulnerable to malicious attack
		User user = new User();
		user.setUserName(userDto.getUserName());
		return userRepository.save(user);
	}
	

	/**
	 * Update user by id.
	 *
	 * @param userDto the user dto
	 * @return the user
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/user")
	public User updateUserById(@Valid @RequestBody UserDto userDto)
			throws ResourceNotFoundException {
		User userToFind = userRepository.findById(userDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userDto.getId()));
		userToFind.setUserName(userDto.getUserName());
		return userRepository.save(userToFind);
	}
	
	/**
	 * Creates the user role mapping.
	 *
	 * @param userRoleAccountMappingDto the user role account mapping dto
	 * @return the user role mapping
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PostMapping("/user/roleMapping")
    public UserRoleMapping createUserRoleMapping(@Valid @RequestBody UserRoleAccountMappingDto userRoleAccountMappingDto) throws ResourceNotFoundException {
		UserRoleMapping userRoleMapping = new UserRoleMapping();
		Role role = null;
		try {
			Optional<Role> roleOptional = roleRepository.findById(userRoleAccountMappingDto.getRoleId());
			role = roleOptional.get();
			userRoleMapping.setRoleId(role != null ? role.getId() : null);
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("role not found");
		}
		
        return userRepository.findById(userRoleAccountMappingDto.getUserId()).map(user -> {
        	userRoleMapping.setUserId(user != null ? user.getId() : null);
        	return userRoleMappingRepository.save(userRoleMapping);
        }).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        
    }
	
	/**
	 * Gets the role mappings by user.
	 *
	 * @param userId the user id
	 * @return the role mappings by user
	 */
	@GetMapping("/user/{userId}/roles")
	public List <UserRoleMappingInfo> getRoleMappingsByUser(@PathVariable(value = "userId") Integer userId) {
		List <UserRoleMapping> userRoleMappingList =  userRoleMappingRepository.findByUserId(userId);
		List<UserRoleMappingInfo> userRoleInfoList = new ArrayList<>();
		for(UserRoleMapping userRoleMapping : userRoleMappingList) {
			UserRoleMappingInfo userRoleMappingInfo = new UserRoleMappingInfo();
			Role role = null;
			try {
				Optional<Role> roleOptional = roleRepository.findById(userRoleMapping.getRoleId());
				role = roleOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("role not found");
			}
			userRoleMappingInfo.setRoleId(role.getId());
			userRoleMappingInfo.setRoleName(role.getName());
			userRoleMappingInfo.setRoleEnabled(role.isEnabled());
			
			User user = null;
			try {
				Optional<User> userOptional = userRepository.findById(userRoleMapping.getUserId());
				user = userOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("user not found");
			}
			
			userRoleMappingInfo.setUserId(user.getId());
			userRoleMappingInfo.setUserName(user.getUserName());
			
			userRoleInfoList.add(userRoleMappingInfo);
		}
		
		return userRoleInfoList;
	}
	
	
	
	/**
	 * Creates the user account mapping.
	 *
	 * @param userRoleAccountMappingDto the user role account mapping dto
	 * @return the user account mapping
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PostMapping("/user/accountMapping")
    public UserAccountMapping createUserAccountMapping(@Valid @RequestBody UserRoleAccountMappingDto userRoleAccountMappingDto) throws ResourceNotFoundException {
		UserAccountMapping userAccountMapping = new UserAccountMapping();
		Account account = null;
		try {
			Optional<Account> accountOptional = accountRepository.findById(userRoleAccountMappingDto.getAccountId());
			account = accountOptional.get();
			userAccountMapping.setAccountId(account != null ? account.getId() : null);
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("account not found");
		}
		
        return userRepository.findById(userRoleAccountMappingDto.getUserId()).map(user -> {
        	userAccountMapping.setUserId(user != null ? user.getId() : null);
        	return userAccountMappingRepository.save(userAccountMapping);
        }).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        
    }
	
	/**
	 * Gets the account mappings by user.
	 *
	 * @param userId the user id
	 * @return the account mappings by user
	 */
	@GetMapping("/user/{userId}/accounts")
	public List <UserAccountMappingDto> getAccountMappingsByUser(@PathVariable(value = "userId") Integer userId) {
		List <UserAccountMapping> userAccountMappingList =  userAccountMappingRepository.findByUserId(userId);
		List<UserAccountMappingDto> userAccountInfoList = new ArrayList<>();
		for(UserAccountMapping userAccountMapping : userAccountMappingList) {
			UserAccountMappingDto userAccountMappingDto = new UserAccountMappingDto();
			Account account = null;
			try {
				Optional<Account> accountOptional = accountRepository.findById(userAccountMapping.getAccountId());
				account = accountOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("account not found");
			}
			userAccountMappingDto.setAccountId(account.getId());
			userAccountMappingDto.setAccountName(account.getAccountName());
			
			User user = null;
			try {
				Optional<User> userOptional = userRepository.findById(userAccountMapping.getUserId());
				user = userOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("user not found");
			}
			
			userAccountMappingDto.setUserId(user.getId());
			userAccountMappingDto.setUserName(user.getUserName());
			
			userAccountInfoList.add(userAccountMappingDto);
		}
		
		return userAccountInfoList;
	}
	
	
	@GetMapping("/user/getAllUserAccountMappings")
	public List <UserAccountMappingDto> getAllUserAccountMappings() {
		List <UserAccountMapping> userAccountMappingList =  userAccountMappingRepository.findAll();
		List<UserAccountMappingDto> userAccountInfoList = new ArrayList<>();
		for(UserAccountMapping userAccountMapping : userAccountMappingList) {
			UserAccountMappingDto userAccountMappingDto = new UserAccountMappingDto();
			userAccountMappingDto.setUserAccountMappingId(userAccountMapping.getId());
			Account account = null;
			try {
				Optional<Account> accountOptional = accountRepository.findById(userAccountMapping.getAccountId());
				account = accountOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("account not found");
			}
			userAccountMappingDto.setAccountId(account.getId());
			userAccountMappingDto.setAccountName(account.getAccountName());
			
			User user = null;
			try {
				Optional<User> userOptional = userRepository.findById(userAccountMapping.getUserId());
				user = userOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("user not found");
			}
			
			userAccountMappingDto.setUserId(user.getId());
			userAccountMappingDto.setUserName(user.getUserName());
			
			userAccountInfoList.add(userAccountMappingDto);
		}
		
		return userAccountInfoList;
	}
	
	@GetMapping("/user/getAllUserRoleMappings")
	public List <UserRoleMappingInfo> getAllUserRoleMappings() {
		List <UserRoleMapping> userRoleMappingList =  userRoleMappingRepository.findAll();
		List<UserRoleMappingInfo> userRoleInfoList = new ArrayList<>();
		for(UserRoleMapping userRoleMapping : userRoleMappingList) {
			UserRoleMappingInfo userRoleMappingInfo = new UserRoleMappingInfo();
			userRoleMappingInfo.setUserRoleMappingId(userRoleMapping.getId());
			Role role = null;
			try {
				Optional<Role> roleOptional = roleRepository.findById(userRoleMapping.getRoleId());
				role = roleOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("role not found");
			}
			userRoleMappingInfo.setRoleId(role.getId());
			userRoleMappingInfo.setRoleName(role.getName());
			userRoleMappingInfo.setRoleEnabled(role.isEnabled());
			
			User user = null;
			try {
				Optional<User> userOptional = userRepository.findById(userRoleMapping.getUserId());
				user = userOptional.get();
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("user not found");
			}
			
			userRoleMappingInfo.setUserId(user.getId());
			userRoleMappingInfo.setUserName(user.getUserName());
			
			userRoleInfoList.add(userRoleMappingInfo);
		}
		
		return userRoleInfoList;
	}
	
}
