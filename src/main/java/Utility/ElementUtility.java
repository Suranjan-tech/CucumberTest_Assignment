package Utility;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import InitDriver.GetDriver;

public class ElementUtility extends GetDriver {
	

	public void waitForElement(WebElement we) {
		//waiting for webElement
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(we)));
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public void enterText(String val, WebElement wb) {
		wb.clear();
		wb.sendKeys(val);

	}

	public void mouseAction(WebElement selectElement) {
		Actions act = new Actions(driver);
		try {
			act.moveToElement(selectElement).click().build().perform();
		} catch (StaleElementReferenceException e) {
			waitForElement(selectElement);
			mouseAction(selectElement);
		}
	}

	public String getCurrentUrlText() {
		return driver.getCurrentUrl();
	}

	public void clickElement(WebElement clickElement) {
		clickElement.click();
	}

}
