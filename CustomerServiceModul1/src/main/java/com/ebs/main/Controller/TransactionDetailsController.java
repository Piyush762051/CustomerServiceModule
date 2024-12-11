package com.ebs.main.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.TransactionDetails;
import com.ebs.main.serviceI.TransDetailsServiceI;

import jakarta.validation.constraints.AssertFalse.List;
@RequestMapping("/transaction")
@RestController
public class TransactionDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(TransactionDetailsController.class);
	
	@Autowired private TransDetailsServiceI transDetailsServiceI;
	
	
	@PostMapping("/createTransaction")
	public ResponseEntity<TransactionDetails> createTransaction(@RequestBody TransactionDetails transactionDetails)
	{      
		
//		if (transactionDetails.getTransactionAmmount() == 0)
//		{
//		
//		return new ResponseEntity<TransactionDetails>(HttpStatus.BAD_REQUEST);
//	}
		
		  TransactionDetails createdTransaction=transDetailsServiceI.saveTransaction(transactionDetails);
		  
		  
		  return new ResponseEntity<TransactionDetails>(createdTransaction,HttpStatus.CREATED);
	

}
	@GetMapping("/getByTransactionId/{tranctioncId}")
	public ResponseEntity<TransactionDetails> getBySingleTransaction(@PathVariable long tranctioncId)
			                                                     
	{
	TransactionDetails transDetailsRef = transDetailsServiceI.getByTransactionId(tranctioncId);
	
	return new ResponseEntity<TransactionDetails>(transDetailsRef,HttpStatus.OK);
	
	}
	
	@GetMapping("/getAllTransaction")
	public ResponseEntity<Iterable<TransactionDetails>> getAllTransactionDe()
	{
		 Iterable<TransactionDetails> transactionAll = transDetailsServiceI.getAllTransactiionDetails();
		 return new ResponseEntity<Iterable<TransactionDetails>>(transactionAll,HttpStatus.OK);
	}
	
}
