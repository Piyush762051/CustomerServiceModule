package com.ebs.main.serviceImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebs.main.model.AccountDetails;
import com.ebs.main.model.EnquiryRequest;
import com.ebs.main.repository.EnquiryRequestRepository;
import com.ebs.main.serviceI.AccDetailsServiceI;
import com.ebs.main.serviceI.EnquiryRequestServiceI;


@Service
public class EnquiryRequestServiceImpl implements EnquiryRequestServiceI
{
	@Autowired EnquiryRequestRepository enRequestRepository;
	@Autowired AccDetailsServiceI accService;

	@Override
	public EnquiryRequest sendRequest(long accNumber, EnquiryRequest enquiryRequest)
	{
		AccountDetails accDetails=accService.getAccountDetails(accNumber);

	    if(accDetails.getEnquiryRequest()==null)
	    {
	         accDetails.setEnquiryRequest(new HashSet<>());
	    	
	    }
	    
		accDetails.getEnquiryRequest().add(enquiryRequest);
		accService.addNewAccountHolderRequest(accDetails);
		return enquiryRequest;
		
	}

	@Override
	public List<EnquiryRequest> displayRequest() {
		// TODO Auto-generated method stub
		return enRequestRepository.findAll();
	}

	


}