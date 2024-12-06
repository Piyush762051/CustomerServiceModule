package com.ebs.main.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.repository.ChequeBookDetailsRepository;
import com.ebs.main.serviceI.CheqBookDetailsServiceI;

@Service
public class CheqBookDetailsServiceImpl implements CheqBookDetailsServiceI
{
	private static final Logger LOG=LoggerFactory.getLogger(CheqBookDetailsServiceImpl.class);
	
	@Autowired ChequeBookDetailsRepository chequeBookDetailsRepository;
}
