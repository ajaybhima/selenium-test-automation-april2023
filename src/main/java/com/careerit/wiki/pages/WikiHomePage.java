package com.careerit.wiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.careerit.wiki.utils.SeleniumUtils;
import com.careerit.wiki.utils.TestNG_Utils;

public class WikiHomePage {
	
	//Web Elements of Page
	
	public final String searchBox="//input[@name='search']";
	public final String langDropdown="//select[@name='language']";
	public final String searchIcon="//button[@class='pure-button pure-button-primary-progressive']";
	
	public WebDriver driver;
	
	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterSearchKey(String searchKey) {
		SeleniumUtils.waitForWebElement(driver, By.xpath(searchBox));
		SeleniumUtils.enterTextIntoTexBox(driver, By.xpath(searchBox), searchKey);
		TestNG_Utils.reportLog("Enter Search Key into Searchbox = "+searchKey);
		System.out.println("New code change");
	}
	
	public void selectLanguage(String language) {
		SeleniumUtils.waitForWebElement(driver, By.xpath(langDropdown));
		SeleniumUtils.selectDropdownByValue(driver, By.xpath(langDropdown),language);
		TestNG_Utils.reportLog("Select Language = "+language);
	}
	
	public void clickOnSearchIcon() {
		SeleniumUtils.waitForWebElement(driver, By.xpath(searchIcon));
		SeleniumUtils.clickOnElement(driver, By.xpath(searchIcon));
		TestNG_Utils.reportLog("Click on Search Icon");
	}

}
