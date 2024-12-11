package com.ebs.main.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.TransactionDetails;
import com.ebs.main.serviceI.TransDetailsServiceI;
@RequestMapping("/transaction")
@RestController
public class TransactionDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(TransactionDetailsController.class);
	
	@Autowired private TransDetailsServiceI transDetailsServiceI;
	
	
	@PostMapping("/transcationEntry/{accountNumber}")
	public ResponseEntity<?> ontransactionEntry(@PathVariable ("accountNumber") Long accNo,@RequestBody TransactionDetails transactionDetails)
	{
		try 
		{
	        TransactionDetails transDetails = transDetailsServiceI.onsaveTransactionEntry(accNo, transactionDetails);
	        return new ResponseEntity<>(transDetails, HttpStatus.CREATED);
	    }
		catch (Exception e)
		{
	        LOG.error("Error saving transaction: {}", e.getMessage());
	        return new ResponseEntity<>("Transaction failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

}
