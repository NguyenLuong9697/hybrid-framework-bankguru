package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.nopcommerce.HomePageObject;
import payObjects.nopcommerce.LoginPageObject;
import payObjects.nopcommerce.MyAccountPageObject;
import payObjects.nopcommerce.OrdersPageObject;
import payObjects.nopcommerce.PageGeneratorManager;
import payObjects.nopcommerce.RegisterPageObject;
import payObjects.nopcommerce.SearchPageObject;

public class Level_07_Switch_Page_Object extends BaseTest {
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
  public void Login_01_Register_To_System() {
	 
	  homePageObject=PageGeneratorManager.getHomePageObject(driver);
	 
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());
	
	  registerPageObject= homePageObject.clickToRegisterLink();
	
	  registerPageObject.clickToMaleRadioButton();
	 
	  registerPageObject.enterToFirstName("Automation");
	
	  registerPageObject.enterToLastName("Testing");
	  
	  registerPageObject.enterToEmail(emailAddress);
	 
	  registerPageObject.enterToPassWord(password);
	  
	  registerPageObject.enterToConfirmPassWord(password);
	 
	  registerPageObject.clickToRegisterButton();
	 
	  Assert.assertTrue(registerPageObject.isRegisterMessageSuccessDisplay());
	 
	  homePageObject=registerPageObject.clickToLogoutLink();
	
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());
  }
  @Test
  public void Login_02_Login_To_System() {
	
	  loginPageObject=homePageObject.clickToLoginLink();
	 
	  loginPageObject.enterToEmail(emailAddress);
	  loginPageObject.enterToPassword(password);
	 
	  homePageObject=loginPageObject.clickToLoginButton();
	 
	  Assert.assertTrue(homePageObject.isHomeSliderDisplayed());

  }
  @Test
  public void TC_03_Switch_Page() {
	  //HomePageObject -> MyAccountPageObject
	  myAccountPageObject =homePageObject.openMyAccountPage(driver);
	  myAccountPageObject.sleepInSecond(2);
	  //MyAccountPageObject-> SearchPageObject
	  searchPageObject=myAccountPageObject.openSearchPage(driver);
	  searchPageObject.sleepInSecond(2);
	  //SearchPageObject -> OrdersPageObject
	  ordersPageObject=searchPageObject.openOrdersPage(driver);
	  ordersPageObject.sleepInSecond(2);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
