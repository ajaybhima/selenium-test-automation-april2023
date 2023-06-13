package com.careerit.wiki.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test_Initializer {
	
	
	public WebDriver initiateWebDriver(){
		
		WebDriver driver = null;
		String browser;
		try {
			//browser = System.getenv("BrowserName");
			browser=FileReadWriteUtils.readPropertyFromFile("Test_Browser");
			System.out.println("Test Browser selected = "+browser);
			
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
			}else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./src/test/resources/Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
			}else if (browser.equalsIgnoreCase("edge")){
				System.setProperty("webdriver.ie.driver", "./src/test/resources/Drivers/msedgedriver.exe");
				driver= new EdgeDriver();
				driver.manage().window().maximize();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to initiate WebDriver");
		}
		
		return driver;
	}
	
	public void closeDriver(WebDriver driver){
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to close the browser");
		}
	}

}
