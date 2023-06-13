package com.careerit.wiki.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Reporter;


public class TestNG_Utils {
	
	public static void reportLog(String logMessage){
		DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		Calendar calInstance= Calendar.getInstance();
		String currentTimeStamp= dateFormat.format(calInstance.getTime());
		Reporter.log(currentTimeStamp +" : "+logMessage);
	}

}
