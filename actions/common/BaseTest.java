package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	String projectPath=System.getProperty("user.dir");
	String separator = System.getProperty("file.separator");
	private enum BROWSER{
		CHROME, FIREFOX, EDGE;
	}
	protected BaseTest() {
		log=LogFactory.getLog(getClass());
	}
	
	//bo tro cho cac class trong package test case
	public WebDriver getBrowserDriver(String browserName) {
		BROWSER browser= BROWSER.valueOf(browserName.toUpperCase());
//		if (browserName.equalsIgnoreCase("Fire fox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("Edge")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Please check brower name");
//		}
		if(browser==BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}else if (browser==BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver",projectPath+"\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		} else if (browser==BROWSER.EDGE) {
			System.setProperty("webdriver.edge.driver",projectPath+"\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}else {
			throw new RuntimeException("Please check brower name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//System.out.println(driver.toString());
		return driver;
		
	}
	
	public WebDriver getBrowserDriver(String browserName, String urlValue) {
		BROWSER browser= BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			//System.setProperty("webdriver.gecko.driver", projectPath + getDirectorySlash("browserDrivers")+"geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser==BROWSER.CHROME) {
			//System.setProperty("webdriver.chrome.driver",projectPath+ getDirectorySlash("browserDrivers") + "chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} else if (browser==BROWSER.EDGE) {
			//System.setProperty("webdriver.edge.driver",projectPath+ getDirectorySlash("browserDrivers") + "msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}else {
			throw new RuntimeException("Please check brower name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(urlValue);
		//System.out.println(driver.toString());
		return driver;
		
	}
	public String getDirectorySlash(String folderName) {
		String separator= System.getProperty("file.separator");
		return separator + folderName + separator;
		
	}
	public String randomEmail() {
			Random rd=new Random();
			return "automation_testing"+rd.nextInt(1000)+"@mail.vn";
			
		}
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
