package com.ebs.main.util;

import java.util.Random;

public class AutoKeyGenrationId
{
	private static final Random ACCOUNTHOLDER_Id_RANDOM=new Random();
	public static Long genrateAccountHolderId()
	{
		return ACCOUNTHOLDER_Id_RANDOM.nextLong(600050,700000);
	}
}
