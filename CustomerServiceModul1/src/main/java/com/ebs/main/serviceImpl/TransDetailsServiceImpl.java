package com.ebs.main.serviceImpl;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebs.main.enm.TransactionStatus;
import com.ebs.main.enm.TransactionType;
import com.ebs.main.exception.InsuficientAccountBalanceexception;
import com.ebs.main.exception.TransanctionFailureException;
import com.ebs.main.model.AccountDetails;
import com.ebs.main.model.TransactionDetails;
import com.ebs.main.repository.TransactionDetailsRepository;
import com.ebs.main.serviceI.AccDetailsServiceI;
import com.ebs.main.serviceI.TransDetailsServiceI;
import com.ebs.main.util.AutoKeyGenrationTransId;

@Service
public class TransDetailsServiceImpl implements TransDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(TransDetailsServiceImpl.class);
	
	@Autowired TransactionDetailsRepository transactionDetailsRepository;
	@Autowired AccDetailsServiceI accDetailsService;

	@Override
	public TransactionDetails onsaveTransactionEntry(Long accNo, TransactionDetails transactionDetails)
	{
		  AccountDetails accountDetails = accDetailsService.getAccountDetails(accNo);
		  if (accountDetails.getAccountTransactionHistory()==null)
		  {
			  accountDetails.setAccountTransactionHistory(new HashSet<>());
		  }
		  else {
			  transactionDetails.setTranctioncId(AutoKeyGenrationTransId.genratedTransactionId());
			  if(transactionDetails.getTransactionType().equals(TransactionType.WITHDRAWAL))
			  {
				  if(accountDetails.getCurrentBalance()-transactionDetails.getTransactionAmmount()>=100)
				  {
					  accountDetails.setCurrentBalance(accountDetails.getCurrentBalance()-transactionDetails.getTransactionAmmount());
					  transactionDetails.setTransactionStatus(TransactionStatus.SUCCESS);
					  transactionDetails.setTransactionRemark("Transaction successfully done.");
					  accountDetails.getAccountTransactionHistory().add(transactionDetails);
				  }
				  else {
					  
					  transactionDetails.setTransactionStatus(TransactionStatus.FAILURE);
					  transactionDetails.setTransactionRemark("Maintain minimum account balance upto 100RS.");
					  accountDetails.getAccountTransactionHistory().add(transactionDetails);
					  throw new InsuficientAccountBalanceexception("Maintain minimum account balance upto 100RS.");
					  
				  }
				  
			  }
			  else if(transactionDetails.getTransactionType().equals(TransactionType.DEPOSIT))
			  { 
				  accountDetails.setCurrentBalance(accountDetails.getCurrentBalance()+transactionDetails.getTransactionAmmount());
				  transactionDetails.setTransactionStatus(TransactionStatus.SUCCESS);
				  transactionDetails.setTransactionRemark("Transaction successfully done.");
				  accountDetails.getAccountTransactionHistory().add(transactionDetails);
				  
				  
			  }
		  }
		  if(accountDetails.getAccountTransactionHistory().size()>0)
		  {
			 accDetailsService.addTransactionHistory(accountDetails);
			 return transactionDetails;
		  }
		
		  throw new TransanctionFailureException("Transaction Failure ");
		  
	}

	
	
}
