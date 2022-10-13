package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractsPage extends BaseClass{
	@FindBy(xpath = "//div[text()='New']")
	private WebElement newBtn;

	public ContractsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnNew() {
		newBtn.click();
	}
}
