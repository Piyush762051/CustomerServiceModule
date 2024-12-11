package com.ebs.main.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.exception.IDNumberNotFound;
import com.ebs.main.model.ATMDetails;
import com.ebs.main.repository.ATMDetailsRepository;
import com.ebs.main.serviceI.ATMDetailsServiceI;

@Service
public class ATMDetailsServiceImpl implements ATMDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(ATMDetailsServiceImpl.class);
	
	@Autowired ATMDetailsRepository atmDetailsRepository;

	@Override
	public ATMDetails saveATMDetails(ATMDetails atmDetails) 
	{
	
		return atmDetailsRepository.save(atmDetails);
		
	}

	@Override
	public ATMDetails getATMDetailsById(long id)
	{
		Optional<ATMDetails> idRef = atmDetailsRepository.findById(id);
					if (idRef.isPresent())
					{
						return idRef.get();
					}
					else {
					throw new IDNumberNotFound("Invaild ATM_Id "+id);
					}
		}
	
	
}
