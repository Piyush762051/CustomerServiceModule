package com.ebs.main.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.TransactionDetails;
import com.ebs.main.serviceI.TransDetailsServiceI;
@RequestMapping("/transaction")
@RestController
public class TransactionDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(TransactionDetailsController.class);
	
	@Autowired private TransDetailsServiceI transDetailsServiceI;
	
	
	
	

}
