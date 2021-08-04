package com.bankguru.login;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Login_BasePage_01 {
  WebDriver driver;
  String projectPath=System.getProperty("user.dir");
  String username, password, currentUrl;
  BasePage basePage;
  @BeforeClass
  public void beforeClass() {
	  	System.setProperty("webdriver.gecko.driver",projectPath+"\\browserDrivers\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		basePage=new BasePage();
		currentUrl="http://demo.guru99.com/v4/";
		
  }
  @Test
  public void Login_01_Register_To_System() {
	  basePage.openUrl(driver, currentUrl);
	  basePage.clickToElement(driver, "//a[text()='here']");
	  basePage.sendKeyToElement(driver, "//input[@name='emailid']", randomEmail());
	  basePage.clickToElement(driver, "//input[@name='btnLogin']");
	  username= basePage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	  password= basePage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
  
  }
  @Test
  public void Login_02_Login_To_System() {
	  basePage.openUrl(driver, currentUrl);
	  basePage.sendKeyToElement(driver, "//input[@name='uid']", username);
	  basePage.sendKeyToElement(driver, "//input[@name='password']", password);
	  basePage.clickToElement(driver, "//input[@name='btnLogin']");
	  Assert.assertEquals(basePage.getTextElement(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");

  }
  public String randomEmail() {
		Random rd=new Random();
		return "automation_testing"+rd.nextInt(1000)+"@mail.vn";
		
	}
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
