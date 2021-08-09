package com.liveguru.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.liveguru.HomePageObject;
import payObjects.liveguru.LoginPageObject;
import payObjects.liveguru.MyDashboardPageObject;

public class Level_04_Login_Multi_Browser extends BaseTest {
	WebDriver driver;
	String projectPath=System.getProperty("user.dir");
	String currentUrl;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	MyDashboardPageObject myDashboardPageObject;
	
	//@Parameters("browser")
	
	//@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
//		if(browserName.equalsIgnoreCase("Fire fox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//
//			driver = new FirefoxDriver();
//		}else if (browserName.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver",projectPath+"\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();	
//		} else if (browserName.equalsIgnoreCase("Edge")) {
//			System.setProperty("webdriver.edge.driver",projectPath+"\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();	
//		}else {
//			throw new RuntimeException("Please check brower name");
//		}
//		
		
		
		currentUrl = "http://live.demoguru99.com";
		driver.get(currentUrl);

	}
	@BeforeClass
	@Parameters({ "browser", "url" })
	public void beforeClass(String browserName,String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
	}
	
	@Test
	public void TC_01_Login_with_Empty_Email_Password() {
		homePageObject =new HomePageObject(driver);
		//click vao My Account ở footer
		homePageObject.clickMyAccountOnFooter();
		//khoi tao Login Page Object
		loginPageObject=new LoginPageObject(driver);
		//nhap email
		loginPageObject.enterEmailAdress("");
		//nhap pass
		loginPageObject.enterPassword("");
		//click vao button Login
		loginPageObject.clickLoginButton();
		//verify
		Assert.assertEquals(loginPageObject.getEmptyEmailErrorMessage(),"This is a required field.");
		Assert.assertEquals(loginPageObject.getEmptyPasswordErrorMessage(),"This is a required field.");
		
		
	}
	@Test
	public void TC_02_Login_with_Invalid_Email() {
		//refresh trang
		loginPageObject.refreshCurrentPage(driver);
		// nhap email
		loginPageObject.enterEmailAdress("123456@123");
		// nhap pass
		loginPageObject.enterPassword("123456");
		// click vao button Login
		loginPageObject.clickLoginButton();
		// verify
		Assert.assertEquals(loginPageObject.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	}
	@Test
	public void TC_03_Login_with_Password_Less_6_Character() {
		//refresh trang
		loginPageObject.refreshCurrentPage(driver);
		// nhap email
		loginPageObject.enterEmailAdress("automation@gmail.com");
		// nhap pass
		loginPageObject.enterPassword("123");
		// click vao button Login
		loginPageObject.clickLoginButton();
		// verify
		Assert.assertEquals(loginPageObject.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	@Test
	public void TC_04_Login_with_Incorrect_Password() {
		//refresh trang
		loginPageObject.refreshCurrentPage(driver);
		// nhap email
		loginPageObject.enterEmailAdress("automation_testing123@gmail.com");
		// nhap pass
		loginPageObject.enterPassword("12356784");
		// click vao button Login
		loginPageObject.clickLoginButton();
		// verify
		Assert.assertEquals(loginPageObject.getIncorrectPasswordErrorMessage(), "Invalid login or password.");
		
	}
	@Test
	public void TC_05_Login_with_Incorrect_Email() {
		//refresh trang
		loginPageObject.refreshCurrentPage(driver);
		// nhap email
		loginPageObject.enterEmailAdress("automation_testing12@gmail.com");
		// nhap pass
		loginPageObject.enterPassword("123456");
		// click vao button Login
		loginPageObject.clickLoginButton();
		// verify
		Assert.assertEquals(loginPageObject.getIncorrectEmailErrorMessage(), "Invalid login or password.");
		
	}
	@Test
	public void TC_06_Login_with_Correct_Email_And_Password() {
		//refresh trang
		loginPageObject.refreshCurrentPage(driver);
		// nhap email
		loginPageObject.enterEmailAdress("automation_testing123@gmail.com");
		// nhap pass
		loginPageObject.enterPassword("123456");
		// click vao button Login
		loginPageObject.clickLoginButton();
		//khoi tao  MyDashboardPageObject
		myDashboardPageObject =new MyDashboardPageObject(driver);
		
		Assert.assertTrue(myDashboardPageObject.isTitleMyDashboardDisplay());
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
