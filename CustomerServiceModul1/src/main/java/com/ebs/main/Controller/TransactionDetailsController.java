package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.serviceI.TransDetailsServiceI;

@RestController
public class TransactionDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(TransactionDetailsController.class);
	
	@Autowired private TransDetailsServiceI transDetailsServiceI;

}
