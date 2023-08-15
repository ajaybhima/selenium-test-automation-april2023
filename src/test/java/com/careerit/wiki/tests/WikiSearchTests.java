package com.careerit.wiki.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.careerit.wiki.pages.WikiContentPage;
import com.careerit.wiki.pages.WikiHomePage;
import com.careerit.wiki.utils.SeleniumUtils;
import com.careerit.wiki.utils.Test_Initializer;

public class WikiSearchTests {
	
	@Test (groups = {"WikiSmokeTest"})
	public void wikiSearchTest_01() {
		
		String testCaseName=new Exception().getStackTrace()[0].getMethodName();
		
		WebDriver driver=null;
		Test_Initializer testInitiator=null;
		try {
			testInitiator=new Test_Initializer();
			driver= testInitiator.initiateWebDriver();
			
			SeleniumUtils.launchApplication(driver);
			
			WikiHomePage homePage=new WikiHomePage(driver);
			
			homePage.enterSearchKey("India");
			homePage.selectLanguage("en");
			homePage.clickOnSearchIcon();


			
			WikiContentPage contentPage=new WikiContentPage(driver);
			contentPage.readHeaderText();
			
		} catch (Exception e) {
			e.printStackTrace();
			SeleniumUtils.takeScreenshotOnTestFailure(driver, testCaseName);
			throw new RuntimeException(testCaseName +" Failed");
		}
		finally {
			testInitiator.closeDriver(driver);
		}
		
	}
	
	@Test (groups = {"WikiSmokeTest"})
	public void wikiSearchTest_02() {
		
		String testCaseName=new Exception().getStackTrace()[0].getMethodName();
		WebDriver driver=null;
		Test_Initializer testInitiator=null;
		try {
			testInitiator=new Test_Initializer();
			driver= testInitiator.initiateWebDriver();
			
			SeleniumUtils.launchApplication(driver);
			
			WikiHomePage homePage=new WikiHomePage(driver);
			homePage.enterSearchKey("Hyderabad");
			homePage.selectLanguage("en");
			homePage.clickOnSearchIcon();
			
			WikiContentPage contentPage=new WikiContentPage(driver);
			String actualHeaderText = contentPage.readHeaderText();
			
			Assert.assertEquals(actualHeaderText, "Telangana","Header Text is mismatch");
			
			
		} catch (Exception e) {
			SeleniumUtils.takeScreenshotOnTestFailure(driver, testCaseName);
			throw new RuntimeException(testCaseName +" Failed");
		}
		finally {
			testInitiator.closeDriver(driver);
		}
		
	}
	
	@Test (groups = {"WikiSmokeTest"})
	public void wikiSearchTest_03() {
		
		String testCaseName=new Exception().getStackTrace()[0].getMethodName();
		WebDriver driver=null;
		Test_Initializer testInitiator=null;
		try {
			testInitiator=new Test_Initializer();
			driver= testInitiator.initiateWebDriver();
			
			SeleniumUtils.launchApplication(driver);
			
			WikiHomePage homePage=new WikiHomePage(driver);
			homePage.enterSearchKey("United States");
			homePage.selectLanguage("en");
			homePage.clickOnSearchIcon();
			
			WikiContentPage contentPage=new WikiContentPage(driver);
			contentPage.readHeaderText();
			
		} catch (Exception e) {
			SeleniumUtils.takeScreenshotOnTestFailure(driver, testCaseName);
			throw new RuntimeException(testCaseName +" Failed");
		}
		finally {
			testInitiator.closeDriver(driver);
		}
		
	}

}
