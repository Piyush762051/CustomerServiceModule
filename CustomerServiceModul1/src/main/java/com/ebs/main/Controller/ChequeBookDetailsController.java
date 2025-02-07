package com.ebs.main.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.ChequeBookDetails;
import com.ebs.main.serviceI.CheqBookDetailsServiceI;

@RequestMapping("/chequebook")
@RestController
public class ChequeBookDetailsController
{
	private static final Logger LOG=LoggerFactory.getLogger(ChequeBookDetailsController.class);
	
	@Autowired private CheqBookDetailsServiceI cheqBookDetailsServiceI;

	@PostMapping("/chequeBookRequest")
	public ResponseEntity<ChequeBookDetails> onRequestChequeBook(@RequestBody ChequeBookDetails chBookDetails)
	{
		ChequeBookDetails  chDetailsRef	  =cheqBookDetailsServiceI.onRequestChequeBook(chBookDetails);
		return new ResponseEntity<ChequeBookDetails>(chDetailsRef, HttpStatus.CREATED);
	}
}
