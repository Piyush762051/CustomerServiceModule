package com.ebs.main.util;

import java.util.Random;

public class AutoGenerateUser_Pass {
	public static final Random USERNAME_RANDOM=new Random(1000);
	
	public static final Random PASSWORD_RANDOM =new Random(1000);
	
	public static String getUsername(String accountHolderName)
	{
		String name[]=accountHolderName.split(" ");
		return name[0]+USERNAME_RANDOM.nextInt(9999);
		
	}
	
	public static String getPassword(String accountHolderName)
	{
		String name[]=accountHolderName.split(" ");
		return name[0] +'@'+PASSWORD_RANDOM.nextInt(9999);
		
	}

}
