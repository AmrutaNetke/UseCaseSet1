package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCasePage extends BaseClass {
	@FindBy(xpath = "//input[@placeholder='Search Accounts...']")
	private WebElement accountNameField;
	@FindBy(xpath = "//input[@placeholder='Search Contacts...']")
	private WebElement contactNameField;
	@FindBy(xpath = "(//a[text()='--None--'])[3]")
	private WebElement productField;
	@FindBy(xpath = "(//a[text()='--None--'])[4]")
	private WebElement typeField;
	@FindBy(xpath = "(//a[text()='New'])[1]")
	private WebElement statusField;
	@FindBy(xpath = "(//a[text()='Medium'])[1]")
	private WebElement priorityField;
	@FindBy(xpath = "(//a[text()='--None--'])[1]")
	private WebElement caseOriginField;
	@FindBy(xpath = "(//a[text()='--None--'])[2]")
	private WebElement caseReasonField;
	
	@FindBy(xpath = "//span[text()='Engineering Req Number']//parent::label//following-sibling::input")
	private WebElement ReqNoField;
	@FindBy(xpath = "(//a[text()='--None--'])[6]")
	private WebElement SLAviolationField;
	@FindBy(xpath = "(//a[text()='--None--'])[5]")
	private WebElement potentialLiabilityField;
	
	@FindBy(xpath = "//span[text()='Subject']//parent::label//following-sibling::input")
	private WebElement subjectField;
	@FindBy(xpath = "//span[text()='Description']//parent::label//following-sibling::textarea")
	private WebElement descriptionField;
	@FindBy(xpath = "//span[text()='Internal Comments']//parent::label//following-sibling::textarea")
	private WebElement internalCommentsField;

	public NewCasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectNewCaseType(String type) {
		driver.findElement(By.xpath("(//span[text()='" + type + "']//parent::div//parent::label//child::span)[1]"))
				.click();
	}

	public void clickOnBtn(String btn) {
		if (btn.equalsIgnoreCase("Next"))
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		else
			driver.findElement(By.xpath("(//span[text()='Cancel'])[2]")).click();
	}

	public void searchField(WebElement element, String option) {
		element.sendKeys(option);
		driver.findElement(By.xpath("//div[@title='" + option + "']")).click();
	}

	public void searchAccountField(String option) {
		accountNameField.sendKeys(option);
		driver.findElement(By.xpath("//mark[text()='" + option + "']")).click();
	}

	public void selectCombobox(WebElement element, int interest, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		Actions act = new Actions(driver);
		for (int i = 0; i < interest; i++) {
			act.sendKeys(element, Keys.ARROW_DOWN).build().perform();
		}
		act.sendKeys(element,Keys.ENTER).build().perform();
	}

	public void enterCaseInformation(String contact, String account, int product, int type, int status, int priority,
			int origin, int reason) {
		searchField(contactNameField, contact);
		searchAccountField(account);
		selectCombobox(productField, product, driver);
		selectCombobox(typeField, type, driver);
		selectCombobox(statusField, status, driver);
//		selectCombobox(priorityField, priority, driver);
//		selectCombobox(caseOriginField, origin, driver);
//		selectCombobox(caseReasonField, reason, driver);
	}
	public void enterAdditionalInformation(String number,int slaViolation,int liability) {
		ReqNoField.sendKeys(number);
		selectSLAViolation();
//		selectCombobox(SLAviolationField,slaViolation,driver);
//		selectCombobox(potentialLiabilityField, liability, driver);
	}
	public void selectSLAViolation() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", SLAviolationField);
		SLAviolationField.sendKeys(Keys.ARROW_DOWN);
		SLAviolationField.sendKeys(Keys.ARROW_DOWN);
		SLAviolationField.sendKeys(Keys.ENTER);
		
	}
	public void enterDescriptionInformation(String subject,String description,String comment) {
		subjectField.sendKeys(subject);
		descriptionField.sendKeys(description);
		internalCommentsField.sendKeys(comment);
	}
	public void clickBtn(String btn) {
		if(btn.equalsIgnoreCase("save")|| btn.equalsIgnoreCase("Cancel"))
			driver.findElement(By.xpath("(//span[text()='"+btn+"'])[2]")).click();
		else
			driver.findElement(By.xpath("//span[text()='Save & New']")).click();
	}
}
