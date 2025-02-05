package com.ebs.main.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutoKeyGenration 
{
private static final Random ACCOUNT_NUMBER_RANDOM=new Random();
public static Long genrateAccountNumber()
{
	return ACCOUNT_NUMBER_RANDOM.nextLong(100000,999999);
}

}
