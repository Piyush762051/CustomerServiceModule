package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.ATMDetails;
import com.ebs.main.serviceI.ATMDetailsServiceI;

@RequestMapping("/atm-details")
@RestController
public class ATMDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(ATMDetailsController.class);
	
	@Autowired private ATMDetailsServiceI atmDetailsServiceI;
	
	@PostMapping("/atmRequest")
	public ResponseEntity<ATMDetails> onatmRequest(@RequestBody ATMDetails atmDetails)
	{
		
	ATMDetails atm	=atmDetailsServiceI.saveATMDetails(atmDetails);
		return new ResponseEntity<ATMDetails>(atm,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/showATM/{atmNumber}")
	public ResponseEntity<ATMDetails> ongetAtmCard(@PathVariable("atmNumber") long id)
	{
ATMDetails atm	=	atmDetailsServiceI.getATMDetailsById(id);	
		return new ResponseEntity<ATMDetails>(atm,HttpStatus.FOUND);
		
	}

}
