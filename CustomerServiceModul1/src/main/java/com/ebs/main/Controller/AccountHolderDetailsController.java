package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.serviceI.AccHolDetailsServiceI;

@RequestMapping("/account")
@RestController
public class AccountHolderDetailsController 
{
	private static final Logger LOG=LoggerFactory.getLogger(AccountHolderDetailsController.class);
	
	@Autowired private AccHolDetailsServiceI accHolDetailsServiceI;

	@PostMapping("/createAccount")
	public ResponseEntity<AccountHolderDetails> oncreatedAccount(@RequestBody AccountHolderDetails accdetails )
	{
					AccountHolderDetails accDetailsRef = accHolDetailsServiceI.oncreatedAccountDetails(accdetails);
					return new ResponseEntity<AccountHolderDetails>(accDetailsRef,HttpStatus.CREATED);
	}
	
	@PutMapping("/update-Account/{accountHolderId}")
	public ResponseEntity<AccountHolderDetails> onUpdateCustomerAccount(@RequestBody AccountHolderDetails acc_Details,
			                                                                 @PathVariable ("accountHolderId")int accId)
	{  
		AccountHolderDetails accRef=accHolDetailsServiceI.onUpdateCustomerAccount(acc_Details,accId);
		
		return new ResponseEntity<AccountHolderDetails>(accRef,HttpStatus.CREATED);
		
	}
}
