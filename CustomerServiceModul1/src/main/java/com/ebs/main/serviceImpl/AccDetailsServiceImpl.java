package com.ebs.main.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.repository.AccountDetailsRepository;
import com.ebs.main.serviceI.AccDetailsServiceI;

@Service
public class AccDetailsServiceImpl implements AccDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(AccDetailsServiceImpl.class);

	@Autowired AccountDetailsRepository accDetailsrepository;
	
}
