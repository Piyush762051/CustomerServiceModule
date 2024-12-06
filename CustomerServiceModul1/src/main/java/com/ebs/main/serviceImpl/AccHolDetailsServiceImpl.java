package com.ebs.main.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.repository.AccountHolderRepository;
import com.ebs.main.serviceI.AccHolDetailsServiceI;

@Service
public class AccHolDetailsServiceImpl implements AccHolDetailsServiceI
{

	private static final Logger LOG=LoggerFactory.getLogger(AccHolDetailsServiceImpl.class);
	
	@Autowired AccountHolderRepository accountHolderRepository;
	
	
}
