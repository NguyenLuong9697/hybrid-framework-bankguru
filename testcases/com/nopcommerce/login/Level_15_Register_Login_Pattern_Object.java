package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.user.nopcommerce.HomePageObject;
import payObjects.user.nopcommerce.LoginPageObject;
import payObjects.user.nopcommerce.MyAccountPageObject;
import payObjects.user.nopcommerce.OrdersPageObject;
import payObjects.user.nopcommerce.PageGeneratorManager;
import payObjects.user.nopcommerce.RegisterPageObject;
import payObjects.user.nopcommerce.SearchPageObject;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
 WebDriver driver;
 String projectPath=System.getProperty("user.dir");
 String  password, currentUrl, emailAddress;
 HomePageObject homePageObject;
 LoginPageObject loginPageObject;
 RegisterPageObject registerPageObject;
 MyAccountPageObject myAccountPageObject;
 SearchPageObject searchPageObject;
 OrdersPageObject ordersPageObject;
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	log.info("Preconditon: Open browser "+browserName+ " and navigate to "+urlValue);
	  	driver= getBrowserDriver(browserName, urlValue);
		password="123123";
		
		emailAddress=randomEmail();
		
  }
  @Test
  public void User_01_Register_To_System() {
	  log.info("User_01_Register_To_System- Step 01: Verify Home Page is displayed");
	  homePageObject=PageGeneratorManager.getHomePageObject(driver);
	  
	  verifyTrue(homePageObject.isHomeSliderDisplayed());
	
	  log.info("User_01_Register_To_System- Step 02:Click to Register Link");
	  homePageObject.clickToHeaderLinkByLabelName(driver, "Register");
	  registerPageObject= PageGeneratorManager.getRegisterPageObject(driver);
		
	  log.info("User_01_Register_To_System- Step 03: Click to Male Radio Button");
	//  registerPageObject.clickToMaleRadioButton();
	  registerPageObject.clickToRadioButtonByLabelName(driver, "Male");
	 
	  log.info("User_01_Register_To_System- Step 04: Enter to First Name textbox: Automation");
	 registerPageObject.enterToTextboxByID(driver,"FirstName","Automation");
	  
	  log.info("User_01_Register_To_System- Step 05: Enter to Last Name textbox: Testing");	
	  registerPageObject.enterToTextboxByID(driver,"LastName","Testing");
	  
	  log.info("User_01_Register_To_System- Step 06: Enter to Email textbox:"+emailAddress);
	  registerPageObject.enterToTextboxByID(driver,"Email",emailAddress);
	  
	  log.info("User_01_Register_To_System- Step 07: Enter to Password textbox:"+password);
	  registerPageObject.enterToTextboxByID(driver,"Password",password);
	  
	  log.info("User_01_Register_To_System- Step 08:Enter to Confirm Password textbox: "+ password);
	  registerPageObject.enterToTextboxByID(driver,"ConfirmPassword",password);
	  
	  log.info("User_01_Register_To_System- Step 09: Click to Register button");
	  registerPageObject.clickToButtonByLabelName(driver,"Register");
	 
	  log.info("User_01_Register_To_System- Step 10: Verify register message success is displayed");
	  verifyEquals(registerPageObject.getSuccessMessage(),"Your registration completed");
	 
	  log.info("User_01_Register_To_System- Step 11: Click to Logout Link");
	  registerPageObject.clickToHeaderLinkByLabelName(driver, "Log out");
	  homePageObject=PageGeneratorManager.getHomePageObject(driver);
	
	 log.info("User_01_Register_To_System- Step 12: Verify Home Page is displayed");
	  verifyTrue(homePageObject.isHomeSliderDisplayed());
  }
  @Test
  public void User_02_Login_To_System() {
	  log.info("User_02_Login_To_System- Step 01: Click to Login link");
	  homePageObject.clickToHeaderLinkByLabelName(driver, "Log in");
	  loginPageObject=PageGeneratorManager.getLoginPageObject(driver);
	 
	  log.info("User_02_Login_To_System- Step 02: Enter to Email textbox with value:"+emailAddress);
	  loginPageObject.enterToTextboxByID(driver, "Email", emailAddress);
	  
	  log.info("User_02_Login_To_System- Step 03: Enter to Password textbox:"+password);
	  loginPageObject.enterToTextboxByID(driver, "Password", password);
	  
	  log.info("User_02_Login_To_System- Step 04: Click to Login Button");
	  loginPageObject.clickToButtonByLabelName(driver,"Log in");
	 
	  log.info("User_02_Login_To_System- Step 05: Verify Home Page is displayed");
	  verifyTrue(homePageObject.isHomeSliderDisplayed());

  }
  @Parameters({ "browser"})
  @AfterClass(alwaysRun = true)
  public void afterClass(String browserName) {
	  log.info("Postcondition: Close the browser:"+browserName);
	
	  cleanBrowserAndDriver();
  }

}
