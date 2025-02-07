package com.ebs.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebs.main.model.EnquiryRequest;
import com.ebs.main.serviceI.EnquiryRequestServiceI;

@RequestMapping("/enquiry")
@RestController
public class EnquiryRequestController 
{
	@Autowired EnquiryRequestServiceI enRequestServiceI;

	
	@PostMapping("/enquiryRequest/{accountNumber}")
	public ResponseEntity<EnquiryRequest> onsendRequest(@PathVariable ("accountNumber")long accNumber,@RequestBody EnquiryRequest enquiryRequest)
	{
		EnquiryRequest enRequestRef=enRequestServiceI.sendRequest(accNumber,enquiryRequest);
		return new ResponseEntity<EnquiryRequest>(enRequestRef, HttpStatus.CREATED);
	}
	
	@GetMapping("/displayAllRequest")
	public ResponseEntity<List<EnquiryRequest>> ondisplayAllRequest()
	{
		List<EnquiryRequest> enRef=enRequestServiceI.displayRequest();
		return new ResponseEntity(enRef, HttpStatus.OK); 	
	}

}
