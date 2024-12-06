package com.ebs.main.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.repository.TransactionDetailsRepository;
import com.ebs.main.serviceI.TransDetailsServiceI;

@Service
public class TransDetailsServiceImpl implements TransDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(TransDetailsServiceImpl.class);
	
	@Autowired TransactionDetailsRepository transactionDetailsRepository;
	
}
