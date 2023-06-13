package com.careerit.wiki.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileReadWriteUtils {
	
	public static String readPropertyFromFile(String propertyName){
		String propertyValue = null;
		try {
			FileInputStream propertyFile=new FileInputStream(new File("./test.properties"));
			Properties props=new Properties();
			props.load(propertyFile);
			propertyValue= props.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertyValue;
	}
	
	public static void writePropertyToFile(String propertyName,String propertyValue){
		
		try {
			FileOutputStream propertyFile=new FileOutputStream(new File("./test.properties"),true);
			Properties props=new Properties();
			//props.setProperty("","");
			props.setProperty(propertyName, propertyValue);
			props.store(propertyFile, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*public static void main(String[] args) {
		FileReadWriteUtils obj=new FileReadWriteUtils();
		System.out.println("Property Value = "+ obj.readPropertyFromFile("Test_URL"));
		
		obj.writePropertyToFile("OrderNumber", "AT324294234");
	}*/

}
