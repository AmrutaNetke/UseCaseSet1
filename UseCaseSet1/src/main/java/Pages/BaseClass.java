package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	public WebDriver driver;

	public void openBrowserTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "Drivers\\Chrome105\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(" https://resourceful-unicorn-16trfw-dev-ed.my.salesforce.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void tearDown() {
		driver.close();
	}
}
