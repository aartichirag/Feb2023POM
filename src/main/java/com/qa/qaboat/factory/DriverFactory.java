package com.qa.qaboat.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver;
	
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser name is: " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}else {
			System.out.println("Please pass correct browser name: " +browserName);		
		}
		
		driver.manage().window().maximize();
		driver.get("https://webcodeboat.com/EpicDeal/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
	
	
}
