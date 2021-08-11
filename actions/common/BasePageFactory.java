package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private WebDriverWait explicit;
	private long timeOut=15;
	
	public void clickToElement(WebDriver driver,WebElement element) {
		element.click();
	}
	public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicit=new WebDriverWait(driver, timeOut);
		explicit.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicit=new WebDriverWait(driver, timeOut);
		explicit.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	public boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
}
