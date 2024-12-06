package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.serviceI.AccHolDetailsServiceI;

@RestController
public class AccountHolderDetailsController 
{
	private static final Logger LOG=LoggerFactory.getLogger(AccountHolderDetailsController.class);
	
	@Autowired private AccHolDetailsServiceI accHolDetailsServiceI;

}
