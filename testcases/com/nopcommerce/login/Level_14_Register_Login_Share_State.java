package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_Login;

import common.BaseTest;
import payObjects.user.nopcommerce.HomePageObject;
import payObjects.user.nopcommerce.LoginPageObject;
import payObjects.user.nopcommerce.MyAccountPageObject;
import payObjects.user.nopcommerce.OrdersPageObject;
import payObjects.user.nopcommerce.PageGeneratorManager;
import payObjects.user.nopcommerce.RegisterPageObject;
import payObjects.user.nopcommerce.SearchPageObject;

public class Level_14_Register_Login_Share_State extends BaseTest {
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
	  	
	  	log.info("Preconditon-Step 01: Open browser "+browserName+ " and navigate to "+urlValue);
	  	driver= getBrowserDriver(browserName, urlValue);
	  	log.info("Precondition- Step 02: Verify Home Page is displayed");
		homePageObject = PageGeneratorManager.getHomePageObject(driver);
		verifyTrue(homePageObject.isHomeSliderDisplayed());
		
  }

  @Test
  public void User_01_Login_To_System() {
	  log.info("User_01_Login_To_System - Step 01: Click to Login link");
	  loginPageObject=homePageObject.clickToLoginLink();
	 
	  log.info("User_01_Login_To_System - Step 02: Set login page cookie");
	  loginPageObject.setAllCookies(driver, Common_01_Login.loginPageCookies);
	  loginPageObject.sleepInSecond(5);
	  loginPageObject.refreshCurrentPage(driver);
	  
	  log.info("User_01_Login_To_System - Step 03: Open home page");
	  homePageObject=loginPageObject.openHomePage();
	 
	  log.info("User_01_Register_To_System- Step 04: Verify Home Page is displayed");
	  verifyTrue(homePageObject.isHomeSliderDisplayed());

  }
  @Parameters({ "browser"})
  @AfterClass(alwaysRun = true)
  public void afterClass(String browserName) {
	  log.info("Postcondition: Close the browser:"+browserName);
	
	  cleanBrowserAndDriver();
  }

}
