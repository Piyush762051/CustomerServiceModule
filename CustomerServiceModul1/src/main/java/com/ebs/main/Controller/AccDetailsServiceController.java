package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.serviceI.AccDetailsServiceI;


@RestController
public class AccDetailsServiceController 
{

	private static final Logger LOG=LoggerFactory.getLogger(AccDetailsServiceController.class);

	@Autowired AccDetailsServiceI serviceI;
	
}
