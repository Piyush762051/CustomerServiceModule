package com.ebs.main.serviceImpl;


import java.io.IOException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ebs.main.exception.IDNumberNotFound;
import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.repository.AccountHolderRepository;
import com.ebs.main.serviceI.AccHolDetailsServiceI;
import com.ebs.main.util.AutoGenerateUser_Pass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccHolDetailsServiceImpl implements AccHolDetailsServiceI
{

	private static final Logger LOG=LoggerFactory.getLogger(AccHolDetailsServiceImpl.class);
	
	@Autowired AccountHolderRepository accountHolderRepository;
    @Autowired ObjectMapper objectMapper;


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
			  e.printStackTrace();
	
		}catch (IOException e) 
		{
		    LOG.error("File was not uploaded correctly");
		}
		
		return account;
      }

	@Override
	public Iterable<AccountHolderDetails> getCustomerAccount() 
	{
		
		return accountHolderRepository.findAll();
	}
	
	@Override
	public AccountHolderDetails onUpdateCustomerAccount(Long accId, String textData, MultipartFile fileAdharcard,
			MultipartFile filePancard, MultipartFile filePhoto, MultipartFile fileJoinLetter,
			MultipartFile fileSalarySlip) {
		Optional<AccountHolderDetails> accHolderRef = accountHolderRepository.findById(accId);
		AccountHolderDetails account=null;
		if(accHolderRef.isPresent())
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
		}
		catch (JsonProcessingException e)
		{
			  LOG.error("Wrong JSON passed..!");
		
		}
		catch (IOException e) 
		{
		    LOG.error("File was not uploaded correctly");
		}
		
		return account;
		
	}

	@Override
	public AccountHolderDetails onsingleAccount(long id)
	{
		Optional<AccountHolderDetails> accReg = accountHolderRepository.findById(id);
	
	if (accReg.isPresent()) {
		return accReg.get();
	}
	
	else {
		throw new IDNumberNotFound("Id Invaild"+id);
	}
	
	}

	
}
