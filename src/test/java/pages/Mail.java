package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import InitDriver.GetDriver;
import Utility.ElementUtility;

public class Mail extends GetDriver {

	By stamps_logo = By.xpath("//img[(@class='sdcLogo')]");
	By print_on_inputBox = By.xpath("//input[@id='printmediadroplist-1038-inputEl']");
	By serial_inputBox = By.xpath("//input[@id='sdc-mainpanel-nsserialtextfield-inputEl']");
	By zip_inputBox = By.xpath("//input[@id='unauthMailFromZip-1048-inputEl']");
	By country_inputBox = By.xpath("//input[@id='combo-1063-inputEl']");
	By weight_inputBox = By.xpath("//input[@id='numberfield-1167-inputEl']");
	By lbs_inputBox = By.xpath("//input[@id='numberfield-1169-inputEl']");
	By letter_option = By.xpath("//td[contains(text(),'Letter')]");
	By service_option = By.xpath("//div[@id='sdc-mainpanel-servicedroplist-trigger-picker']");
	By service_inputbox = By.xpath("//input[@id='sdc-mainpanel-servicedroplist-inputEl']");
	By register_button = By.xpath("//span[contains(text(),'Register')]");

	public void launchUrl(String stampUrl) {

		driver.get(stampUrl);
		// wait for stamps logo
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(stamps_logo));
		// wait for register now button
		eu.waitForElement(driver.findElement(register_button));
	}

	public void fillPrintInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(print_on_inputBox));
		eu.enterText(st, driver.findElement(print_on_inputBox));
	}

	public void fillSerialInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(serial_inputBox));
		eu.enterText(st, driver.findElement(serial_inputBox));
	}

	public void fillZipInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(zip_inputBox));
		eu.enterText(st, driver.findElement(zip_inputBox));
	}

	public void countryInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(country_inputBox));

		eu.enterText(st, driver.findElement(country_inputBox));
	}

	public void weightInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(weight_inputBox));
		eu.enterText(st, driver.findElement(weight_inputBox));
	}

	public void lbsInputBox(String st) {
		ElementUtility eu = new ElementUtility();
		eu.waitForElement(driver.findElement(lbs_inputBox));
		eu.enterText(st, driver.findElement(lbs_inputBox));
	}

	public void serviceOption(String st) {
		ElementUtility eu = new ElementUtility();
		if (st.equals("Letter")) {
			// wait for service dropdown to be clickable
			eu.waitForElement(driver.findElement(service_option));
			eu.clickElement(driver.findElement(service_option));
			// waiting for "Letter" service is not loading completely
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// wait for "Letter"
			eu.waitForElement(driver.findElement(letter_option));
			eu.mouseAction(driver.findElement(letter_option));
			Assert.assertTrue(driver.findElement(service_inputbox).getAttribute("value").contains(st));
		}
	}

	public void verifyCurrentUrl(String st) {
		ElementUtility eu = new ElementUtility();
		Assert.assertTrue("Url contains expected text", eu.getCurrentUrlText().contains(st));

	}

}
