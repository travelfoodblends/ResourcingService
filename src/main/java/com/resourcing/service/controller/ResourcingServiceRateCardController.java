package com.resourcing.service.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.dto.RateCardDto;
import com.resourcing.service.exception.ResourceNotFoundException;
import com.resourcing.service.model.Account;
import com.resourcing.service.model.Location;
import com.resourcing.service.model.RateCard;
import com.resourcing.service.repository.AccountRepository;
import com.resourcing.service.repository.LocationRepository;
import com.resourcing.service.repository.RateCardRepository;


/**
 * The Class ResourcingServiceRateCardController.
 */
@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceRateCardController {

	
	/** The rate card repository. */
	private RateCardRepository rateCardRepository;
	
	/** The location repository. */
	private LocationRepository locationRepository;
	
	/** The account repository. */
	private AccountRepository accountRepository;
	
	/**
	 * Instantiates a new resourcing service rate card controller.
	 *
	 * @param rcRepo the rc repo
	 * @param lcnRepo the lcn repo
	 * @param acntRepo the acnt repo
	 */
	ResourcingServiceRateCardController(RateCardRepository rcRepo, LocationRepository lcnRepo, AccountRepository acntRepo){
		this.rateCardRepository = rcRepo;
		this.locationRepository = lcnRepo;
		this.accountRepository = acntRepo;
	}
	
	/**
	 * Creates the rate card.
	 *
	 * @param rateCardDto the rate card dto
	 * @return the rate card
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PostMapping("/rateCard")
    public RateCard createRateCard(@Valid @RequestBody RateCardDto rateCardDto) throws ResourceNotFoundException {
		RateCard rateCard = new RateCard();
		rateCard.setCategory(rateCardDto.getCategory());
		rateCard.setRate(rateCardDto.getRate());

		//check if a valid account is present for the id
		Optional<Account> optionalAccount = accountRepository.findById(rateCardDto.getAccountId());
		if(optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			rateCard.setAccount(account);
		}else {
			throw new ResourceNotFoundException("Account not found with id :: " + rateCardDto.getAccountId());
		}
		
		//check if a valid location is present for the id
		Optional<Location> optionalLocation = locationRepository.findById(rateCardDto.getLocationId());
		if(optionalLocation.isPresent()) {
			Location location = optionalLocation.get();
			rateCard.setLocation(location);
		}else {
			throw new ResourceNotFoundException("Location not found with id :: " + rateCardDto.getLocationId());
		}
				
		try {
			rateCardRepository.save(rateCard);
		}catch(Exception ex) {
			throw new ResourceNotFoundException("Location not found with id :: " + rateCardDto.getLocationId());
		}
		
		return rateCard;
    }
	
	/**
	 * Gets the all rate cards.
	 *
	 * @return the all rate cards
	 */
	@GetMapping("/rateCard")
	public List<RateCard> getAllRateCards() {
		return rateCardRepository.findAll();
	}
	
	/**
	 * Update rate card.
	 *
	 * @param rateCardDto the rate card dto
	 * @return the rate card
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/rateCard")
	public RateCard updateRateCard(@Valid @RequestBody RateCardDto rateCardDto) throws ResourceNotFoundException {
		//check if a valid account is present for the id
		RateCard rateCard = rateCardRepository.findById(rateCardDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Rate card not found for this id :: " + rateCardDto.getId()));
		rateCard.setCategory(rateCardDto.getCategory());
		rateCard.setRate(rateCardDto.getRate());
		return rateCardRepository.save(rateCard);
	}
}
