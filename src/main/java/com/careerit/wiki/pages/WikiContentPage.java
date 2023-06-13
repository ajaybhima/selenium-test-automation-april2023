package com.careerit.wiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.careerit.wiki.utils.SeleniumUtils;
import com.careerit.wiki.utils.TestNG_Utils;

public class WikiContentPage {
	
	public final String headerText="//h1[@id='firstHeading']";
	
	public WebDriver driver;
	
	public WikiContentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String readHeaderText() {
		SeleniumUtils.waitForWebElement(driver, By.xpath(headerText));
		String headerTextValue= SeleniumUtils.readText(driver, By.xpath(headerText));
		TestNG_Utils.reportLog("Header Text = "+ headerTextValue);
		return headerTextValue;
	}

}
