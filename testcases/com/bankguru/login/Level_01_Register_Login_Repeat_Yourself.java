package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Login_Repeat_Yourself {
  WebDriver driver;
  String projectPath=System.getProperty("user.dir");
  String username, password, currentUrl;
  @BeforeClass
  public void beforeClass() {
	  	System.setProperty("webdriver.gecko.driver",projectPath+"\\browserDrivers\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		currentUrl="http://demo.guru99.com/v4/";
		
  }
  @Test
  public void Login_01_Register_To_System() {
	  driver.get(currentUrl);
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(randomEmail());
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  username=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  password=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  
	  
  }
  @Test
  public void Login_02_Login_To_System() {
	  driver.get(currentUrl);
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("marquee.heading3")).getText(),"Welcome To Manager's Page of Guru99 Bank");
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
