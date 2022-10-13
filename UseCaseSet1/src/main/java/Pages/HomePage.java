package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	@FindBy(xpath = "//button[@aria-haspopup='dialog']")
	private WebElement options;
	@FindBy(xpath = "//input[contains(@placeholder,'Search apps')]")
	private WebElement searchBar;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTab(String searchItem) {
		options.click();
		searchBar.sendKeys(searchItem);
		driver.findElement(By.xpath("//b[text()='"+searchItem+"']")).click();
	}
}
