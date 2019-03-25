package com.evryindia.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 
public class KeyGenerator
{
	public static String generateKey()
	{
		String key = null;
		
		try 
		{
			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
			byte[] randomBytes = new byte[128];
			secureRandomGenerator.nextBytes(randomBytes);

			int seedByteCount = 1;
			byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
			long randomValue = secureRandom.nextLong();
			if(randomValue < 0)	randomValue = randomValue * -1;
			//System.out.println("Random - te" + randomValue);
			key = "" + randomValue;
		}
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		
		return key;
	}
	
	public static void main(String[] args) {
		System.out.println(generateKey());
	}
}