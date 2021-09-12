package com.nopcommerce.login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.BaseTest;
import payObjects.user.nopcommerce.HomePageObject;
import payObjects.user.nopcommerce.LoginPageObject;
import payObjects.user.nopcommerce.MyAccountPageObject;
import payObjects.user.nopcommerce.OrdersPageObject;
import payObjects.user.nopcommerce.PageGeneratorManager;
import payObjects.user.nopcommerce.RegisterPageObject;
import payObjects.user.nopcommerce.SearchPageObject;
import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_ExtentReport extends BaseTest {
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
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
		password="123123";
		
		emailAddress=randomEmail();
		
		
  }
  @Test
  public void User_01_Register_To_System(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
	  ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register_To_System- Step 01: Verify Home Page is displayed");

	  homePageObject=PageGeneratorManager.getHomePageObject(driver);
	  //Fail lan 1
	  verifyFalse(homePageObject.isHomeSliderDisplayed());
	
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 02:Click to Register Link");
	  registerPageObject= homePageObject.clickToRegisterLink();
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 03: Click to Male Radio Button");
	  registerPageObject.clickToMaleRadioButton();
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 04: Enter to First Name textbox: Automation");
	  registerPageObject.enterToFirstName("Automation");
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 05: Enter to Last Name textbox: Testing");	
	  registerPageObject.enterToLastName("Testing");
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 06: Enter to Email textbox:"+emailAddress);
	  registerPageObject.enterToEmail(emailAddress);
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 07: Enter to Password textbox:"+password);
	  registerPageObject.enterToPassWord(password);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 08:Enter to Confirm Password textbox: "+ password);
	  registerPageObject.enterToConfirmPassWord(password);
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 09: Click to Register button");
	  registerPageObject.clickToRegisterButton();
	 
	  //Fail lan 2
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 10: Verify register message success is displayed");
	 // verifyFalse(registerPageObject.isRegisterMessageSuccessDisplay());
	  verifyEquals(registerPageObject.getSuccessMessage(),"Your registration completed.");
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 11: Click to Logout Link");
	  homePageObject=registerPageObject.clickToLogoutLink();
	
	 ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 12: Verify Home Page is displayed");
	 verifyTrue(homePageObject.isHomeSliderDisplayed());
	 
	 ExtentTestManager.endTest();
  }
  @Test
  public void User_02_Login_To_System(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login_To_System- Step 01: Click to Login link");
	  loginPageObject=homePageObject.clickToLoginLink();
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login_To_System- Step 02: Enter to Email textbox with value:"+emailAddress);
	  loginPageObject.enterToEmail(emailAddress);
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login_To_System- Step 03: Enter to Password textbox:"+password);
	  loginPageObject.enterToPassword(password);
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 04: Click to Login Button");
	  homePageObject=loginPageObject.clickToLoginButton();
	 
	  ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register_To_System- Step 05: Verify Home Page is displayed");
	  verifyTrue(homePageObject.isHomeSliderDisplayed());

	  ExtentTestManager.endTest();
  }
 
  @AfterClass
  public void afterClass() {
	 // ExtentTestManager.getTest().log(LogStatus.INFO,"Postcondition: Close the browser");
	  driver.quit();
  }

}
