package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.multipart.MultipartFile;


import com.ebs.main.model.AccountHolderDetails;
import com.ebs.main.serviceI.AccHolDetailsServiceI;

@RequestMapping("/accountHolder")
@RestController
public class AccountHolderDetailsController 
{
	private static final Logger LOG=LoggerFactory.getLogger(AccountHolderDetailsController.class);
	
	@Autowired private AccHolDetailsServiceI accHolDetailsServiceI;
	
	
	@GetMapping("/allAccountHolder")
	public ResponseEntity<Iterable<AccountHolderDetails>> ongetAccountDetails()
	{
			Iterable<AccountHolderDetails> accRef=accHolDetailsServiceI.getCustomerAccount();
			return new ResponseEntity<Iterable<AccountHolderDetails>>(accRef,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/particularAccountHolder/{accountHolderId}")
	public ResponseEntity<AccountHolderDetails> onsingleAccount(@PathVariable ("accountHolderId") long id)
	{
			AccountHolderDetails accRef	=accHolDetailsServiceI.onsingleAccount(id);
			return new ResponseEntity<AccountHolderDetails>(accRef,HttpStatus.OK);
	}
}



