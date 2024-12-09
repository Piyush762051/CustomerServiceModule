package com.ebs.main.serviceImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.main.exception.InvailedAgeException;
import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.repository.AccountHolderRepository;
import com.ebs.main.serviceI.AccHolDetailsServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccHolDetailsServiceImpl implements AccHolDetailsServiceI
{

	private static final Logger LOG=LoggerFactory.getLogger(AccHolDetailsServiceImpl.class);
	
	@Autowired AccountHolderRepository accountHolderRepository;
    @Autowired ObjectMapper objectMapper;
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

	@Override
	public AccountHolderDetails saveAccount(String textData, MultipartFile fileAdharcard, MultipartFile filePancard,
			MultipartFile filePhoto, MultipartFile fileJoinLetter, MultipartFile fileSalarySlip)
	{
		AccountHolderDetails account=null;
		try 
		{
			account=objectMapper.readValue(textData, AccountHolderDetails.class);
			LOG.info(account.toString());
			if(!fileAdharcard.isEmpty())account.setAccountHolderAdharCard(fileAdharcard.getBytes());
			if(!filePancard.isEmpty())account.setAccountHolderPanCard(filePancard.getBytes());
			if(!filePhoto.isEmpty())account.setAccountHolderPhoto(filePhoto.getBytes());
			if(!fileJoinLetter.isEmpty())account.setAccountHolderJoiningLatter(fileJoinLetter.getBytes());
			if(!fileSalarySlip.isEmpty())account.setAccountHolderSalarySlip(fileSalarySlip.getBytes());
			
			accountHolderRepository.save(account);
		} catch (JsonProcessingException e)
		{
			  LOG.error("Wrong JSON passed..!");
			// TODO: handle exception
		}catch (IOException e) 
		{
		    LOG.error("File was not uploaded correctly");
		}
		
		return account;
	}
}
