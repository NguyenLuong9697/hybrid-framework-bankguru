package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payFactorys.nopcommerce.HomePageFactory;
import payFactorys.nopcommerce.LoginPageFactory;
import payFactorys.nopcommerce.RegisterPageFactory;

public class Level_05_Register_Page_Factory extends BaseTest {
  WebDriver driver;
  String projectPath=System.getProperty("user.dir");
  String  password, currentUrl, emailAddress;
  HomePageFactory homePageFactory;
  LoginPageFactory loginPageFactory;
  RegisterPageFactory registerPageFactory;
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
		password="123123";
		
		emailAddress=randomEmail();
		
		
  }
  @Test
  public void Login_01_Register_To_System() {
	  driver.get("https://demo.nopcommerce.com/");
	 
	  homePageFactory = new HomePageFactory(driver);
	  //verify da den home
	  
	  Assert.assertTrue(homePageFactory.isHomeSliderDisplayed());
	  //click vao Register
	  homePageFactory.clickToRegisterLink();
	  registerPageFactory= new RegisterPageFactory(driver);
	  //click vao Radio male
	  registerPageFactory.clickToMaleRadioButton();
	  //enter FirstName
	  registerPageFactory.enterToFirstName("Automation");
	  //enter last Name
	  registerPageFactory.enterToLastName("Testing");
	  //enter email
	  registerPageFactory.enterToEmail(emailAddress);
	  //enter password
	  registerPageFactory.enterToPassWord(password);
	  //enter confirm pass
	  registerPageFactory.enterToConfirmPassWord(password);
	  //click vao Register button
	  registerPageFactory.clickToRegisterButton();
	  //verify message register success
	  Assert.assertTrue(registerPageFactory.isRegisterMessageSuccessDisplay());
	  //logout
	  registerPageFactory.clickToLogoutLink();
	  homePageFactory=new HomePageFactory(driver);
	  //verify da tro ve trang home
	  Assert.assertTrue(homePageFactory.isHomeSliderDisplayed());
  }
  @Test
  public void Login_02_Login_To_System() {
	 //click vao Login
	  homePageFactory.clickToLoginLink();
	  //click login chuyen qua Login Page
	  loginPageFactory= new LoginPageFactory(driver);
	  //enter email
	  loginPageFactory.enterToEmail(emailAddress);
	  loginPageFactory.enterToPassword(password);
	  //click to login Button
	  loginPageFactory.clickToLoginButton();
	  //tro ve trang hom
	  homePageFactory=new HomePageFactory(driver);
	  Assert.assertTrue(homePageFactory.isHomeSliderDisplayed());

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
