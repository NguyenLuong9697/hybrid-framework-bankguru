package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


public class Level_12_Assert_Verify extends BaseTest {
 WebDriver driver;
 RegisterPageObject registerPage;
 
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
	  	registerPage= PageGeneratorManager.getRegisterPageObject(driver);
	  	
  }
  @Test
  public void Register_01_Verify() {
	  //Fail lan 1
	  verifyFalse(registerPage.isEmailTextboxDisplayed());
	  verifyFalse(registerPage.isConfirmEmailUnDisplay());
	  registerPage.inputEmailTextbox("luong.ngthi@samsung.com");
	  //Fail lan 2
	  verifyFalse(registerPage.isConfirmEmailDisplay());
	  registerPage.inputEmailTextbox("");
	  //registerPage.sleepInSecond(2);
	  //Fail lan 3
	  verifyTrue(registerPage.isConfirmEmailUnDisplay());
	  verifyTrue(registerPage.isLoginButtonUnDisplay());
	
	
  }

 
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
