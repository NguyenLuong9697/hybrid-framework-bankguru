package com.nopcomerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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

public class Common_01_Login extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String password, currentUrl, emailAddress;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	RegisterPageObject registerPageObject;
	MyAccountPageObject myAccountPageObject;
	SearchPageObject searchPageObject;
	OrdersPageObject ordersPageObject;
	public static Set<Cookie> loginPageCookies;

	@BeforeTest
	@Parameters({ "browser", "url" })
	public void beforeClass(String browserName, String urlValue) {

		log.info("Preconditon: Open browser " + browserName + " and navigate to " + urlValue);
		driver = getBrowserDriver(browserName, urlValue);
		password = "123123";
		emailAddress = randomEmail();

		log.info("Common_01- Step 01: Verify Home Page is displayed");
		homePageObject = PageGeneratorManager.getHomePageObject(driver);

		verifyTrue(homePageObject.isHomeSliderDisplayed());

		log.info("Common_01- Step 02:Click to Register Link");
		registerPageObject = homePageObject.clickToRegisterLink();

		log.info("Common_01- Step 03: Click to Male Radio Button");
		registerPageObject.clickToMaleRadioButton();

		log.info("Common_01- Step 04: Enter to First Name textbox: Automation");
		registerPageObject.enterToFirstName("Automation");

		log.info("Common_01- Step 05: Enter to Last Name textbox: Testing");
		registerPageObject.enterToLastName("Testing");

		log.info("Common_01- Step 06: Enter to Email textbox:" + emailAddress);
		registerPageObject.enterToEmail(emailAddress);

		log.info("Common_01- Step 07: Enter to Password textbox:" + password);
		registerPageObject.enterToPassWord(password);

		log.info("Common_01- Step 08:Enter to Confirm Password textbox: " + password);
		registerPageObject.enterToConfirmPassWord(password);

		log.info("Common_01- Step 09: Click to Register button");
		registerPageObject.clickToRegisterButton();

		log.info("Common_01- Step 10: Verify register message success is displayed");
		verifyEquals(registerPageObject.getSuccessMessage(), "Your registration completed");
		
		log.info("Common_01- Step 11: Click to Logout Link");
		homePageObject = registerPageObject.clickToLogoutLink();

		log.info("Common_01- Step 12: Verify Home Page is displayed");
		verifyTrue(homePageObject.isHomeSliderDisplayed());

		log.info("Common_01- Step 13: Click to Login link");
		loginPageObject = homePageObject.clickToLoginLink();

		log.info("Common_01- Step 14: Enter to Email textbox with value:" + emailAddress);
		loginPageObject.enterToEmail(emailAddress);

		log.info("Common_01- Step 15: Enter to Password textbox:" + password);
		loginPageObject.enterToPassword(password);

		log.info("Common_01- Step 15: Click to Login Button");
		homePageObject = loginPageObject.clickToLoginButton();

		log.info("Common_01- Step 17: Verify Home Page is displayed");
		verifyTrue(homePageObject.isHomeSliderDisplayed());

		log.info("Common_01- Step 18: Get all login page cookies");
		loginPageCookies = homePageObject.getAllCookies(driver);
		
		System.out.println("COOKIES:"+loginPageCookies);
		log.info("Postcondition: Close the browser:" + browserName);
		cleanBrowserAndDriver();
	}

}
