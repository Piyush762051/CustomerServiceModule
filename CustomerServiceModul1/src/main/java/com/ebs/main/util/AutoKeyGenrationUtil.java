package com.ebs.main.util;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoKeyGenrationUtil {
    private final Random ACCOUNT_NUMBER_RANDOM=new Random(); 
	public Long genrateAccountNumber()
	{
		return ACCOUNT_NUMBER_RANDOM.nextLong(100000, 999999);
	}

}
