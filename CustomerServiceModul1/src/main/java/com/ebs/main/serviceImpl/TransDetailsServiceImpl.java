package com.ebs.main.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.exception.AccountNotFound;
import com.ebs.main.model.TransactionDetails;
import com.ebs.main.repository.TransactionDetailsRepository;
import com.ebs.main.serviceI.TransDetailsServiceI;

@Service
public class TransDetailsServiceImpl implements TransDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(TransDetailsServiceImpl.class);
	
	@Autowired TransactionDetailsRepository transactionDetailsRepository;

	

	@Override
	public TransactionDetails saveTransaction(TransactionDetails transactionDetails) {
		if (transactionDetails.getTransactionAmmount() <= 0)
		{
            throw new IllegalArgumentException("Transaction amount must be greater than 0.");
            
		}
		else {
			return transactionDetailsRepository.save(transactionDetails);
			
		}
           
	}



	@Override
	public TransactionDetails getByTransactionId(long tranctioncId) {
		Optional<TransactionDetails> tDetailsRef = transactionDetailsRepository.findById(tranctioncId);
		if(tDetailsRef.isPresent())
		{
			return tDetailsRef.get();
		}
		else 
		{
			throw new AccountNotFound("Invalid Account or InvalidtranctioncId"+tranctioncId);
		}
		
	}



	@Override
	public Iterable<TransactionDetails> getAllTransactiionDetails() {
		
		return transactionDetailsRepository.findAll();
	}



	
	
}
