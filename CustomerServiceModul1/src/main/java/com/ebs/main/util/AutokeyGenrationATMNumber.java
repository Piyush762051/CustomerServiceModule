package com.ebs.main.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutokeyGenrationATMNumber
{
	private static final Random ATM_NUMBER_RANDOM=new Random();
	public static Long genrateATMNumber()
	{
		return ATM_NUMBER_RANDOM.nextLong(100,999);
	}
}
