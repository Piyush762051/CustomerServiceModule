package com.ebs.main.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebs.main.exception.InvailedAgeException;
import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.repository.AccountHolderRepository;
import com.ebs.main.serviceI.AccHolDetailsServiceI;

@Service
public class AccHolDetailsServiceImpl implements AccHolDetailsServiceI
{

	private static final Logger LOG=LoggerFactory.getLogger(AccHolDetailsServiceImpl.class);
	
	@Autowired AccountHolderRepository accountHolderRepository;

	@Override
	public AccountHolderDetails oncreatedAccountDetails(AccountHolderDetails accdetails) {
		
		if(accdetails.getAccountholderAge()>=18 && accdetails.getAccountholderAge()<=85)
		{
			AccountHolderDetails accRef= accountHolderRepository.save(accdetails);
			return accRef;
			
	}
	else {
		throw new InvailedAgeException("User is age must be in the rang of 18 to 85");
	}
	
	}
}
