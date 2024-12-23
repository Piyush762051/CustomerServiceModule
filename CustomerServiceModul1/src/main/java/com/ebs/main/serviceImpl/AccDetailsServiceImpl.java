package com.ebs.main.serviceImpl;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebs.main.exception.AccountNotFound;
import com.ebs.main.model.AccountDetails;
import com.ebs.main.repository.AccountDetailsRepository;
import com.ebs.main.serviceI.AccDetailsServiceI;
import com.ebs.main.util.AutoKeyGenration;
import com.ebs.main.util.AutoKeyGenrationId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccDetailsServiceImpl implements AccDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(AccDetailsServiceImpl.class);

	@Autowired AccountDetailsRepository accDetailsrepository;
    @Autowired private ObjectMapper objectMapper; 
    
	
	@Override
	public AccountDetails saveAccount(String textData, MultipartFile fileAdharcard, MultipartFile filePancard,
			MultipartFile filePhoto, MultipartFile fileJoinLetter, MultipartFile fileSalarySlip)
	{
		AccountDetails account=null;
		try
		{
			account=objectMapper.readValue(textData, AccountDetails.class);
			account.setAccountNumber(AutoKeyGenration.genrateAccountNumber());
			account.getAccountHolderDetails().setAccountHolderId(AutoKeyGenrationId.genrateAccountHolderId());
			LOG.info(account.toString());
			
			if(account.getAccountHolderDetails() !=null) {
				
			if(!fileAdharcard.isEmpty()) account.getAccountHolderDetails().setAccountHolderAdharCard(fileAdharcard.getBytes());
			if(!filePancard.isEmpty()) account.getAccountHolderDetails().setAccountHolderPanCard(filePancard.getBytes());
			if(!filePhoto.isEmpty()) account.getAccountHolderDetails().setAccountHolderPhoto(filePhoto.getBytes());
			if(!fileJoinLetter.isEmpty()) account.getAccountHolderDetails().setAccountHolderJoiningLatter(fileJoinLetter.getBytes());
			if(!fileSalarySlip.isEmpty()) account.getAccountHolderDetails().setAccountHolderSalarySlip(fileSalarySlip.getBytes());
			
			accDetailsrepository.save(account);
			
			}
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
	public Iterable<AccountDetails> displayAccount()
	{
		return accDetailsrepository.findAll() ;
	}


	@Override
	public AccountDetails getAccountDetails(long accountNumber) {
		    Optional<AccountDetails> opAccuntDetails = accDetailsrepository.findById(accountNumber);
                 if(opAccuntDetails.isEmpty())
                 {
                	 throw new AccountNotFound("Account details not found on account nummmber "+accountNumber);
                	 
                 }
		    
		    return opAccuntDetails.get();
	}


	@Override
	public void addTransactionHistory(AccountDetails accountDetails) {
		
		accDetailsrepository.save(accountDetails);
		
	}
	public void addNewAccountHolderRequest(AccountDetails accountDetails)
	{
		accDetailsrepository.save(accountDetails);
	}
	
}
