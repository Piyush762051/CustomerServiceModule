package com.ebs.main.serviceI;

import java.util.List;

import com.ebs.main.model.EnquiryRequest;

public interface EnquiryRequestServiceI
{

	public EnquiryRequest sendRequest(long accNumber, EnquiryRequest enquiryRequest);

	public List<EnquiryRequest> displayRequest();

}
