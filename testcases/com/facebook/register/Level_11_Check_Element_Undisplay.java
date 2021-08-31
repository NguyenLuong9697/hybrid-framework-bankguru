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


public class Level_11_Check_Element_Undisplay extends BaseTest {
 WebDriver driver;
 RegisterPageObject registerPage;
 
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
	  	registerPage= PageGeneratorManager.getRegisterPageObject(driver);
	  	
  }
  @Test
  public void Register_01_Check_Element_Displayed() {
	  Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
	
  }
  @Test
  public void Register_02_Check_Element_UnDisplayed_In_DOM() {
	  Assert.assertFalse(registerPage.isConfirmEmailUnDisplay());
	  registerPage.inputEmailTextbox("luong.ngthi@samsung.com");
	  Assert.assertTrue(registerPage.isConfirmEmailDisplay());
	  registerPage.inputEmailTextbox("");
	  //registerPage.sleepInSecond(2);
	  Assert.assertFalse(registerPage.isConfirmEmailUnDisplay());
	
  }
  @Test
  public void Register_03_Check_Element_UnDisplayed_Not_In_DOM() {
	  //Assert.assertFalse(registerPage.isLoginButtonDisplay());
	  Assert.assertTrue(registerPage.isLoginButtonUnDisplay());
	
  }
 
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
