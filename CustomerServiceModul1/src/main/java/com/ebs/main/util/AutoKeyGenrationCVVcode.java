package com.ebs.main.util;

import java.util.Random;

public class AutoKeyGenrationCVVcode
{
	private static final Random CVV_CODE=new Random();
public static int genrateCVv()
{
	return CVV_CODE.nextInt(100,999);
}
}
