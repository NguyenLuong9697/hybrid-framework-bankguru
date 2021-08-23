package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.jquerydatatable.HomePageObject;
import payObjects.jquerydatatable.PageGeneratorManager;


public class Level_09_Data_Table extends BaseTest {
 WebDriver driver;
 
 HomePageObject homePageObject;

  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
		
		
  }
  //Demo in site:https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
  @Test
  public void TC_01_Load_Data() {
	  homePageObject = PageGeneratorManager.getHomePageObject(driver);
	  homePageObject.clickLoadDataButton();
	  Assert.assertEquals(homePageObject.getRowInDataTable(),8);
	  
	  
  }
  @Test
  public void TC_02_Actions_Append_Row_Remove_Last_Row_And_Input() {
	  homePageObject.clickToIconByName("Append Row");
	  homePageObject.clickToIconByName("Append Row");
	  homePageObject.clickToIconByName("Append Row");
	  //input vao textbox theo cột vào hàng
	  homePageObject.inputToTextboxByRowNumber("Contact Person","9","John Kim");
	  homePageObject.inputToTextboxByRowNumber("Company","9","Samsung");
	  homePageObject.inputToTextboxByRowNumber("Order Placed","9","123");
	  homePageObject.inputToTextboxByRowNumber("Member Since","9","21/03/2021");
	  homePageObject.sleepInSecond(2);
	  homePageObject.selectCountry("Country","9","Malaysia");
	  Assert.assertEquals(homePageObject.getCountrySelected("Country","9"),"Malaysia");
	  homePageObject.checkToCheckbox("NPO?","9");
	  Assert.assertTrue(homePageObject.isCheckboxSelected("NPO?","9"));
	  homePageObject.clickToIconByName("Remove Last Row");
  
  }
  @Test
  public void TC_03_Actions_In_Row() {
	  Assert.assertEquals(homePageObject.getRowInDataTable(),10);
	  homePageObject.clickToIconByRowNumber("1","Remove Current Row");
	  Assert.assertEquals(homePageObject.getRowInDataTable(),9);
	  homePageObject.clickToIconByRowNumber("1","Move Down");
  
  }
  //Demo site: https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
  //@Test
  public void TC_04_Pagging() {
	  homePageObject = PageGeneratorManager.getHomePageObject(driver);
	  homePageObject.clickToPageNumber("3");
	  Assert.assertTrue(homePageObject.isPageNumberActive("3"));
	  homePageObject.clickToPageNumber("10");
	  Assert.assertTrue(homePageObject.isPageNumberActive("10"));
	  homePageObject.clickToPageNumber("20");
	  Assert.assertTrue(homePageObject.isPageNumberActive("20"));
	  
  }
 //@Test
  public void TC_05_Search_In_Column_Name() {
	homePageObject.searchInColumnName("Females","123000");
	Assert.assertTrue(homePageObject.isRowValueDisplayed("123000","Somalia","123000","246000"));
	homePageObject.refreshCurrentPage(driver);
	Assert.assertTrue(homePageObject.isPageNumberActive("1"));
	homePageObject.searchInColumnName("Country","Argentina");
	Assert.assertTrue(homePageObject.isRowValueDisplayed("338282","Argentina","349238","687522"));
	homePageObject.refreshCurrentPage(driver);
	Assert.assertTrue(homePageObject.isPageNumberActive("1"));
	homePageObject.searchInColumnName("Males","802948");
	Assert.assertTrue(homePageObject.isRowValueDisplayed("764956","Arab Rep of Egypt","802948","1567904"));
	homePageObject.refreshCurrentPage(driver);
	Assert.assertTrue(homePageObject.isPageNumberActive("1"));
	homePageObject.searchInColumnName("Total","24853148");
	Assert.assertTrue(homePageObject.isRowValueDisplayed("12253515","AFRICA","12599691","24853148"));
	
	 
	  
  }
 //@Test
 public void TC_06_Actions_In_Row_By_Icon() {
	 homePageObject.refreshCurrentPage(driver);
	 Assert.assertTrue(homePageObject.isPageNumberActive("1"));
	 homePageObject.clickToIconByCountryName("AFRICA","remove");
	 homePageObject.sleepInSecond(2);
	 Assert.assertTrue(homePageObject.isDeleteSucceed("AFRICA"));
	 homePageObject.clickToIconByCountryName("Argentina","edit");	 
	 Assert.assertTrue(homePageObject.isPopupEditCountryDisplayed());
	 Assert.assertTrue(homePageObject.verifyValueInRow("338282","Argentina","349238","687522"));
	 homePageObject.closeEditPopup();
 }
  @AfterClass
  public void afterClass() {
	driver.quit();
  }

}
