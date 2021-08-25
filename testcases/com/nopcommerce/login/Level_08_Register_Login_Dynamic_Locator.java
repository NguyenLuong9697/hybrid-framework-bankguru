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

public class Level_08_Register_Login_Dynamic_Locator extends BaseTest {
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
  public void TC_03_Dynamic_locator_Way_1() {
	  //HomePageObject -> MyAccountPageObject
	  myAccountPageObject =(MyAccountPageObject) homePageObject.openPageFooterByName(driver,"My account");
	  myAccountPageObject.sleepInSecond(2);
	  //MyAccountPageObject-> SearchPageObject
	  searchPageObject=(SearchPageObject) myAccountPageObject.openPageFooterByName(driver,"Search");
	  searchPageObject.sleepInSecond(2);
	  //SearchPageObject -> OrdersPageObject
	  ordersPageObject=(OrdersPageObject) searchPageObject.openPageFooterByName(driver, "Orders");
	  ordersPageObject.sleepInSecond(2);
	  
  }
  @Test
  public void TC_04_Dynamic_locator_Way_2() {
	  //OrdersPageObject -> MyAccountPageObject
	  homePageObject.getPageFooterByName(driver,"My account");
	  myAccountPageObject = PageGeneratorManager.getMyAccountPageObject(driver);
	  myAccountPageObject.sleepInSecond(2);
	  //MyAccountPageObject-> SearchPageObject
	  myAccountPageObject.openPageFooterByName(driver,"Search");
	  searchPageObject =PageGeneratorManager.getSearchPageObject(driver);
	  searchPageObject.sleepInSecond(2);
	  //SearchPageObject -> OrdersPageObject
	  searchPageObject.openPageFooterByName(driver, "Orders");
	  ordersPageObject = PageGeneratorManager.getOrdersPageObject(driver);
	  ordersPageObject.sleepInSecond(2);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
