package com.careerit.wiki.utils;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	
	public static void launchApplication(WebDriver driver){
		try {
			String applicationURL=FileReadWriteUtils.readPropertyFromFile("Test_URL");
			driver.get(applicationURL);
			TestNG_Utils.reportLog("Launching application - "+applicationURL);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to launch application");
		}
	}
	
	public static void waitForWebElement(WebDriver driver,By element){
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Locate Web Element");
		}
		
	}
	
	public static void clickOnElement(WebDriver driver,By element){
		try {
			WebElement button=driver.findElement(element);
			button.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Click on a button");
		}
	}
	
	public static void enterTextIntoTexBox(WebDriver driver,By element,String text){
		try {
			WebElement textBox=driver.findElement(element);
			textBox.clear();
			textBox.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Enter Text into TextBox");
		}
	}
	
	public static void selectDropdownByValue(WebDriver driver,By element,String value){
		try {
			Select selectBox=new Select(driver.findElement(element));
			selectBox.selectByValue(value);	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Enter Text into TextBox");
		}
	}
	
	public static String readText(WebDriver driver,By element){
		try {
			WebElement component = driver.findElement(element);
			String text=component.getText();
			return text;		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to Enter Text into TextBox");
		}
	}
	
	
	
	public static void mouserHoverOnElement(WebDriver driver, By element){
		
	}
	
	public static void takeScreenshotOnTestFailure(WebDriver driver,String testCaseName){
		try {
			File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(sourceFile, new File("./target/screenshots/"+testCaseName+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
