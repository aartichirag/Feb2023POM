package com.qa.qaboat.factory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	WebDriver driver;
	/* 
	 * This method is used to initialize the weddriver
	 * @param browserName
	 * @return driver
	 */
	
//	public WebDriver init_driver(String browserName) {
//		System.out.println("Browser name is: " + browserName);
//		
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}else if(browserName.equalsIgnoreCase("safari")) {
//			driver = new SafariDriver();
//		}else {
//			System.out.println("Please pass correct browser name: " +browserName);		
//		}
//		
//		driver.manage().window().maximize();
////		driver.manage().deleteAllCookies();
////		driver.get("https://webcodeboat.com/EpicDeal/login");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return driver;
//	}
//	
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
