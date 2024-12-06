package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.serviceI.CheqBookDetailsServiceI;

@RestController
public class ChequeBookDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(ChequeBookDetailsController.class);
	
	@Autowired private CheqBookDetailsServiceI cheqBookDetailsServiceI;

}
