package StepDefinition;

import InitDriver.GetDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Mail;

public class CucumberTest {

	@Given("I launch {string} browser")
	public void i_launch_browser(String string) {
		// Write code here that turns the phrase above into concrete actions
		GetDriver driverObject = new GetDriver();
		driverObject.initChromeDriver();
	}

	@When("I go to {string}")
	public void i_go_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.launchUrl(string);
	}

	@Then("I expect url to contain {string}")
	public void i_expect_url_to_contain(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.verifyCurrentUrl(string);

	}

	@When("I set Print On to {string}")
	public void i_set_print_on_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.fillPrintInputBox(string);
	}

	@When("I set Serial Number to {string}")
	public void i_set_serial_number_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.fillSerialInputBox(string);
	}

	@When("I set Mail From ZIP to {string}")
	public void i_set_mail_from_zip_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.fillZipInputBox(string);
	}

	@When("I set Mail To Country to {string}")
	public void i_set_mail_to_country_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.countryInputBox(string);
	}

	@When("I set Weight lbs to {string} and oz to {string}")
	public void i_set_weight_lbs_to_and_oz_to(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.weightInputBox(string);
		mail.lbsInputBox(string2);
	}

	@Then("I set service to {string}")
	public void i_set_service_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		Mail mail = new Mail();
		mail.serviceOption(string);
	}

	@After
	public void tearDown() {
		GetDriver.driver.quit();
	}

}
