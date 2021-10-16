package com.saucedemo.sortdata;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.saucedemo.LoginPageObject;
import payObjects.saucedemo.PageGeneratorManager;
import payObjects.saucedemo.ProductPageObject;

public class Level_16_Saucedemo_Sortdata extends BaseTest {
 WebDriver driver;
 LoginPageObject loginPage;
 ProductPageObject productPage;
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	log.info("Preconditon 01: Open browser "+browserName+ " and navigate to "+urlValue);
	  	driver= getBrowserDriver(browserName, urlValue);
	  	loginPage =PageGeneratorManager.getLoginPageObject(driver);
	  	
	  	log.info("Precondition 02: Login to system");
	  	productPage=loginPage.loginToSystem("standard_user","secret_sauce");
	  	
		
  }
  @Test
  public void Sort_01_Name() {
	 log.info("Sort_01_Name: Step 01: select value 'Name (A to Z)' in drop down ");
	 productPage.selectItemInSortDropdown("Name (A to Z)");
	 
	 log.info("Sort_01_Name: Step 02: verify selected value  in drop down is 'Name (A to Z)' ");
	 verifyEquals(productPage.getSeletedValueInSortDropdown(),"Name (A to Z)");
	 
	 log.info("Sort_01_Name: Step 03: verify list produts are sorted with name ascensding");
	 verifyTrue(productPage.isProductNameSortAscending());
	 productPage.sleepInSecond(3);
	 
	 log.info("Sort_01_Name: Step 04: verify selected value  in drop down is 'Name (Z to A)' ");
	 productPage.selectItemInSortDropdown("Name (Z to A)");
	 
	 log.info("Sort_01_Name: Step 05: verify selected value  in drop down is 'Name (Z to A)' ");
	 verifyEquals(productPage.getSeletedValueInSortDropdown(),"Name (Z to A)");
	 
	 log.info("Sort_01_Name: Step 05: verify list products are sorted with name descending");
	 verifyTrue(productPage.isProductNameSortDescending());
	 productPage.sleepInSecond(3);
  }
  @Test
  public void Sort_02_Price() {
	log.info("Sort_02_Price: Step 01: select value 'Price (low to high)' in drop down ");
	productPage.selectItemInSortDropdown("Price (low to high)");

	log.info("Sort_02_Price: Step 02: verify selected value  in drop down is 'Price (low to high)' ");
	verifyEquals(productPage.getSeletedValueInSortDropdown(), "Price (low to high)");

	log.info("Sort_02_Price: Step 03: verify list products are sorted with price ascensding");
	verifyTrue(productPage.isProductPriceSortAscending());
	productPage.sleepInSecond(3);
	
	log.info("Sort_02_Price: Step 04: verify selected value  in drop down is 'Price (high to low)' ");
	productPage.selectItemInSortDropdown("Price (high to low)");

	log.info("Sort_02_Price: Step 05: verify selected value  in drop down is 'Price (high to low)' ");
	verifyEquals(productPage.getSeletedValueInSortDropdown(), "Price (high to low)");

	log.info("Sort_02_Price: Step 05: verify list products are sorted with price descending");
	verifyTrue(productPage.isProductPriceSortDescending());
	productPage.sleepInSecond(3);
  }
  @Parameters({ "browser"})
  @AfterClass(alwaysRun = true)
  public void afterClass(String browserName) {
	  log.info("Postcondition: Close the browser:"+browserName);
	
	  cleanBrowserAndDriver();
  }

}
