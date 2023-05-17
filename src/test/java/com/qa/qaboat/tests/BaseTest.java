package com.qa.qaboat.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.qaboat.factory.DriverFactory;
import com.qa.qaboat.pages.AccountsPage;
import com.qa.qaboat.pages.HomePage;
import com.qa.qaboat.pages.LoginPage;
import com.qa.qaboat.pages.ProductDetailsPage;
import com.qa.qaboat.pages.SearchResultsPage;

public class BaseTest {
	
	DriverFactory df; 
	Properties prop;
	ChromeDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountsPage accountsPage;
	SearchResultsPage searchResultsPage;
	ProductDetailsPage productDetailsPage;
	
	@BeforeTest
	public void setup() {
//		df = new DriverFactory();
//		//driver assign the value to driver variable
//		driver= df.init_driver("chrome");
//		loginPage = new LoginPage(driver);
		
		System.out.println("Setup Method"); //config.properties
		prop = new Properties();
		try {
				FileReader reader =new FileReader("./src/test/resources/config/config.properties");
				prop.load(reader);		
		}	catch (FileNotFoundException e) {
				e.printStackTrace();
		}	catch (IOException e) {
				e.printStackTrace();
		}
		
		System.out.println("Setup Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);	
//		driver.get("https://webcodeboat.com/EpicDeal/login"); //hard coded value
		driver.get(prop.getProperty("url")); //this url is config.properties
		driver.manage().window().maximize();
		
//		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Teardown Method");
		driver.quit();
	}	

}
