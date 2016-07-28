package com.mz.probin.util;

import java.time.LocalTime;

public class TimeUtils {
	
	public static String getTodaysDate(){
		LocalTime localTime = LocalTime.now();
		System.out.println("Local Time :"+localTime);
		return localTime.toString();
		
	}

}
