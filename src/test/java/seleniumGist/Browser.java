package seleniumGist;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	WebDriver driver;

	public void clickOn(By by) {
		WebElement element = waitForClickable(by);
		element.click();
	}

	public WebElement waitForClickable(By by) {
		return waitFor(by, 200);
	}
	
	public WebElement waitFor(By by, long waitTime) {
		WebDriverWait wait = getWaitDriver(waitTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public WebDriverWait getWaitDriver(long waitTime) {
		return new WebDriverWait(driver, waitTime);
	}
	
	public void clickOn(WebElement webElement){
		WebElement element=waitForClickable(webElement);
	}

	private WebElement waitForClickable(WebElement webElement) {
		
		return waitFor(webElement,200);
	}

	private WebElement waitFor(WebElement webElement, int waitTime) {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(waitTime, TimeUnit.SECONDS)
			.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class, 
					StaleElementReferenceException.class);
	return	wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
	}

	

	
}
