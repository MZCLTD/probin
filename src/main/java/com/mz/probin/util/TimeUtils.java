package com.mz.probin.util;

import java.time.LocalDate;

public class TimeUtils {
	
	public static String getTodaysDate(){
		LocalDate localDate = LocalDate.now();
		
		System.out.println("Local Time :"+localDate);
		return localDate.toString();
		
	}

}
