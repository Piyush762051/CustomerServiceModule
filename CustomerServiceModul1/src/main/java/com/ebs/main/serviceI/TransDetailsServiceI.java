package com.ebs.main.serviceI;

import com.ebs.main.model.TransactionDetails;

public interface TransDetailsServiceI
{

	public TransactionDetails onsaveTransactionEntry(Long accNo, TransactionDetails transactionDetails);

}
