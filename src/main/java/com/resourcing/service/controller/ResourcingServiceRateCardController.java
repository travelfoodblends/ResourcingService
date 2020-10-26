package com.resourcing.service.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

@RestController
@RequestMapping("/resourcingService")
@CrossOrigin
@XRayEnabled
public class ResourcingServiceRateCardController {

	
	private RateCardRepository rateCardRepository;
	
	private LocationRepository locationRepository;
	
	private AccountRepository accountRepository;
	
	ResourcingServiceRateCardController(RateCardRepository rcRepo, LocationRepository lcnRepo, AccountRepository acntRepo){
		this.rateCardRepository = rcRepo;
		this.locationRepository = lcnRepo;
		this.accountRepository = acntRepo;
	}
	
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
}
