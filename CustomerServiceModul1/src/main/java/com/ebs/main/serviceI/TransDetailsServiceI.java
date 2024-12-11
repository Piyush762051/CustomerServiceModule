package com.ebs.main.serviceI;

import com.ebs.main.model.TransactionDetails;

public interface TransDetailsServiceI {

	

	public TransactionDetails saveTransaction(TransactionDetails transactionDetails);

	public TransactionDetails getByTransactionId(long tranctioncId);

	public Iterable<TransactionDetails> getAllTransactiionDetails();

}
