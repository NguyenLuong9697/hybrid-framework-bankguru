package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	String projectPath=System.getProperty("user.dir");
	String separator = System.getProperty("file.separator");
	private enum BROWSER{
		CHROME, FIREFOX, EDGE;
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
		if(browserName.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", projectPath + getDirectorySlash("browserDrivers")+"geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver",projectPath+ getDirectorySlash("browserDrivers") + "chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} else if (browserName.equalsIgnoreCase("Edge")) {
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
}
