package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.nopcommerce.HomePageObject;
import payObjects.nopcommerce.LoginPageObject;
import payObjects.nopcommerce.RegisterPageObject;

public class Level_04_Register_Login_Page_Multi_Browser extends BaseTest {
  WebDriver driver;
  String projectPath=System.getProperty("user.dir");
  String  password, currentUrl, emailAddress;
  HomePageObject homePageObject;
  LoginPageObject loginPageObject;
  RegisterPageObject registerPageObject;
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	/*System.setProperty("webdriver.gecko.driver",projectPath+"\\browserDrivers\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	  	driver= getBrowserDriver(browserName, urlValue);
		password="123123";
		
		emailAddress=randomEmail();
		
		
  }
  @Test
  public void Login_01_Register_To_System() {
	  driver.get("https://demo.nopcommerce.com/");
	 
	  homePageObject = new HomePageObject(driver);
	  //verify da den home
	  
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());
	  //click vao Register
	  homePageObject.clickToRegisterLink();
	  registerPageObject= new RegisterPageObject(driver);
	  //click vao Radio male
	  registerPageObject.clickToMaleRadioButton();
	  //enter FirstName
	  registerPageObject.enterToFirstName("Automation");
	  //enter last Name
	  registerPageObject.enterToLastName("Testing");
	  //enter email
	  registerPageObject.enterToEmail(emailAddress);
	  //enter password
	  registerPageObject.enterToPassWord(password);
	  //enter confirm pass
	  registerPageObject.enterToConfirmPassWord(password);
	  //click vao Register button
	  registerPageObject.clickToRegisterButton();
	  //verify message register success
	  Assert.assertTrue(registerPageObject.isRegisterMessageSuccessDisplay());
	  //logout
	  registerPageObject.clickToLogoutLink();
	  homePageObject=new HomePageObject(driver);
	  //verify da tro ve trang home
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());
  }
  @Test
  public void Login_02_Login_To_System() {
	 //click vao Login
	  homePageObject.clickToLoginLink();
	  //click login chuyen qua Login Page
	  loginPageObject= new LoginPageObject(driver);
	  //enter email
	  loginPageObject.enterToEmail(emailAddress);
	  loginPageObject.enterToPassword(password);
	  //click to login Button
	  loginPageObject.clickToLoginButton();
	  //tro ve trang hom
	  homePageObject=new HomePageObject(driver);
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
