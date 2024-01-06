package Reuseablelibrary;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class stringutils {

	public String generateAssetid() {

		String intgerAssetId = RandomStringUtils.randomNumeric(8);
		String assetId = intgerAssetId.substring(0, 1) + "-" + intgerAssetId.substring(1, 2) + "-"
				+ intgerAssetId.substring(2, intgerAssetId.length());
		return assetId;
	}

	public String getRandomstring(int target) {

		int leftlimit = 97; //a
		int rightlimit = 122;//z
		//int target = 10;
		Random random = new Random();
		StringBuilder sb= new StringBuilder(target);
		for(int i=0;i<target;i++)
		{
			int randomlimit=leftlimit+ (int) (random.nextFloat()*(rightlimit -leftlimit+1));
			sb.append((char)randomlimit);
			
		}

		return sb.toString();
	}
	
	
	public static void main(String [] args)
	{
		
		stringutils su= new stringutils();
				
				System.out.println(su.getRandomstring(10));
		
	}
}
