package common;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private Alert alert;
	private WebDriverWait explicit;
	private long timeOut=15;
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();;
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public Alert waitAlertPresence(WebDriver driver) {
		explicit=new WebDriverWait(driver, timeOut);
		return alert=explicit.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		alert=waitAlertPresence(driver);
		alert.accept();
	}
	public void dismissAlert(WebDriver driver) {
		alert=waitAlertPresence(driver);
		alert.dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		alert=waitAlertPresence(driver);
		return alert.getText();
	}
	public void sendKeysToAlert(WebDriver driver, String value) {
		alert=waitAlertPresence(driver);
		alert.sendKeys(value);
	}
	public void switchWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows=driver.getWindowHandles();
		for (String id : allWindows) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows=driver.getWindowHandles();
		for (String id : allWindows) {
			driver.switchTo().window(id);
			if(driver.getTitle().equals(title)) {
				break;
			}
		}
	}
	public void closeTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows=driver.getWindowHandles();
		for (String id : allWindows) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		
	}
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
