package common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import reportConfig.ExtentTestManager;
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
	
	public WebDriver getDriver() {
		return this.driver;
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
				ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- PASSED -------------------------- ");
			} else {
				//log4j
				log.info(" -------------------------- FAILED -------------------------- ");
				attachScreenShotToReportNG();
				//extent
				ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- FAILED -------------------------- ");
				//tu them
				attchScreenShotToExtentReport();
				
				//
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			//tu them
			//attachScreenShotToReport();
			//
		}
		return pass;
	}
	
	private void attchScreenShotToExtentReport() {
		// TODO Auto-generated method stub
		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
				ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
				attachScreenShotToReportNG();
				ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- FAILED -------------------------- ");
				//tu them
				attchScreenShotToExtentReport();
				//tu them
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			//tu them
			//attachScreenShotToReport();
			//
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
			ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			//attachScreenShotToReport();
			ExtentTestManager.getTest().log(LogStatus.INFO, "-------------------------- FAILED -------------------------- ");
			//tu them
			attchScreenShotToExtentReport();
			
			//
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			//tu them
			//attachScreenShotToReport();
			//
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	public void attachScreenShotToReportNG() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		String screenshotPath = captureScreenshot(driver,"FAIL");
		//Reporter.getCurrentTestResult();
		Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		//Reporter.setCurrentTestResult(null);
	}
	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenPath = System.getProperty("user.dir") + "\\screenshotReportNG\\" + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}
	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		log.info("---------- START delete file in folder ----------");
		deleteAllFileInFolder();
		log.info("---------- END delete file in folder ----------");
	}

	public void deleteAllFileInFolder() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\screenshotReportNG";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					log.info(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}


}
