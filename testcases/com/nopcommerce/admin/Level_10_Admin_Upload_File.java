package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import payObjects.admin.nopcommerce.DashboardPageObject;
import payObjects.admin.nopcommerce.LoginPageObject;
import payObjects.admin.nopcommerce.PageGeneratorManager;
import payObjects.admin.nopcommerce.ProductDetailPageObject;
import payObjects.admin.nopcommerce.ProductPageObject;


public class Level_10_Admin_Upload_File extends BaseTest {
 WebDriver driver;
 LoginPageObject loginPage;
 DashboardPageObject dashboardPage;
 ProductPageObject productPage;
 ProductDetailPageObject productDetailPage;
 String productName, imageAlt, imageTitle, imageDisplayOrder;
 String imageName;
  @BeforeClass
  @Parameters({ "browser", "url" })
  public void beforeClass(String browserName,String urlValue) {
	  	
	  	driver= getBrowserDriver(browserName, urlValue);
	  	productName="Windows 8 Pro";
	  	imageAlt="Img Alt";
	  	imageTitle="Img Title";
	  	
	  	imageName="Avatar.jpg";
	  	loginPage = PageGeneratorManager.getLoginPageObject(driver);
	  	loginPage.inputToEmailTextbox("admin@yourstore.com");
	  	loginPage.inputToPasswordTextbox("admin");
	  	dashboardPage=loginPage.clickLoginButton();
	  	Assert.assertTrue(dashboardPage.isJQueryLoadSuccess(driver));
	  	dashboardPage.openSubMenuByName(driver,"Catalog","Products");
	  	productPage=PageGeneratorManager.getProductPageObject(driver);
	  	productPage.clickToExpandSearchPanel();
	  	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
	  	productPage.inputToProductNameTextbox(productName);
	  	productPage.clickSearchButton();
	  	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
	  	productDetailPage= productPage.clickEditIconByProductName(productName);
	  	Assert.assertTrue(productDetailPage.isJQueryLoadSuccess(driver));
	  	
  }
  @Test
  public void Login_01_Upload() {
	productDetailPage.clickToExpandPanelByCardName("Pictures");
	productDetailPage.clickDeleteImageInTableByCardName("productpictures");
	Assert.assertTrue(productDetailPage.isMessageDisplayedInEmptyTable("productpictures","No data available in table"));
	productPage=productDetailPage.clickSaveButton();
	Assert.assertTrue(productPage.isSuccessMessageDisplayed("The product has been updated successfully."));
	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
	productPage.inputToProductNameTextbox(productName);
  	productPage.clickSearchButton();
  	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
  	Assert.assertTrue(productPage.isImageUpdatedSuccessByProductName(productName,"default-image"));
  	productDetailPage= productPage.clickEditIconByProductName(productName);
  	Assert.assertTrue(productDetailPage.isJQueryLoadSuccess(driver));
  	productDetailPage.clickToExpandPanelByCardName("Pictures");
	productDetailPage.uploadFictureByFileName(imageName);
	Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFileName(imageName));
	productDetailPage.inputAltTextbox(imageAlt);
	productDetailPage.inputTitleTextbox(imageTitle);
	imageDisplayOrder=productDetailPage.clickToUpDownInDisplayOrder("product-pictures","Increase value");
	productDetailPage.clickAddProductPictureButton();
	Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName,imageDisplayOrder,imageAlt,imageTitle));
	productPage=productDetailPage.clickSaveButton();	
	Assert.assertTrue(productPage.isSuccessMessageDisplayed("The product has been updated successfully."));
	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
	productPage.inputToProductNameTextbox(productName);
  	productPage.clickSearchButton();
  	Assert.assertTrue(productPage.isJQueryLoadSuccess(driver));
  	Assert.assertTrue(productPage.isImageUpdatedSuccessByProductName(productName,productName));
  	
  }
 
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
