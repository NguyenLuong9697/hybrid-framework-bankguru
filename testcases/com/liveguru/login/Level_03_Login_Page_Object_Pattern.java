package com.liveguru.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import payObjects.liveguru.HomePageObject;
import payObjects.liveguru.LoginPageObject;
import payObjects.liveguru.MyDashboardPageObject;

public class Level_03_Login_Page_Object_Pattern {
	WebDriver driver;
	String projectPath=System.getProperty("user.dir");
	String currentUrl;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	MyDashboardPageObject myDashboardPageObject;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		currentUrl = "http://live.demoguru99.com";
		driver.get(currentUrl);

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
