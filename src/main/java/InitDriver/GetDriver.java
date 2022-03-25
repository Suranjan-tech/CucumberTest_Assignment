package InitDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ConstantApp;

public class GetDriver {

	public static WebDriver driver;

	public void initChromeDriver() {

		System.setProperty("webdriver.chrome.driver", ConstantApp.chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

}
