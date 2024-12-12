package com.ebs.main.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutoKeyGenrationTransId 
{
	private static final Random TRANSCATION_Id_RANDOM=new Random();
	public static Long genratedTransactionId()
	{
		return TRANSCATION_Id_RANDOM.nextLong(100000000,999999999);
	}

}
