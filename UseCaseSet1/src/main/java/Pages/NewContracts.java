package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewContracts extends BaseClass {
	@FindBy(xpath = "//input[@placeholder='Search Accounts...']")
	private WebElement accountNameField;
	@FindBy(xpath = "//input[@placeholder='Search Contacts...']")
	private WebElement customerSignedByField;
	@FindBy(xpath = "//span[text()='Customer Signed Title']//parent::label//following-sibling::input")
	private WebElement customerSignedTitleField;
	@FindBy(xpath = "(//span[text()='Date Picker']//parent::a//preceding-sibling::input)[2]")
	private WebElement customerSignedDateField;
	@FindBy(xpath = "//input[@placeholder='Search Price Books...']")
	private WebElement priceBookField;
	@FindBy(xpath = "//a[text()='Draft']")
	private WebElement statusField;
	@FindBy(xpath = "(//span[text()='Date Picker']//parent::a//preceding-sibling::input)[1]")
	private WebElement contractStartDateField;
	@FindBy(xpath = "//span[text()='Contract Term (months)']//parent::label//following-sibling::input")
	private WebElement contractTermField;
	@FindBy(xpath = "//a[text()='--None--']")
	private WebElement ownerExpirationNoticeField;
	@FindBy(xpath = "//input[@placeholder='Search People...']")
	private WebElement companySignedByField;
	@FindBy(xpath = "(//span[text()='Date Picker']//parent::a//preceding-sibling::input)[3]")
	private WebElement companySignedDateField;
//	Address Information
	@FindBy(xpath = "//textarea[@placeholder='Billing Street']")
	private WebElement billingStreetField;
	@FindBy(xpath = "//input[@placeholder='Billing City']")
	private WebElement billingCityField;
	@FindBy(xpath = "//input[@placeholder='Billing Zip/Postal Code']")
	private WebElement billingCodeField;
	@FindBy(xpath = "//input[@placeholder='Billing State/Province']")
	private WebElement billingStateField;
	@FindBy(xpath = "//input[@placeholder='Billing Country']")
	private WebElement billingCountryField;

	@FindBy(xpath = "//span[text()='Special Terms']//parent::label//following-sibling::textarea")
	private WebElement specialTermField;
	@FindBy(xpath = "//span[text()='Description']//parent::label//following-sibling::textarea")
	private WebElement descriptionField;

	@FindBy(xpath = "//select[@class='slds-select picklist__label']")
	private WebElement yearField;
	@FindBy(xpath = "//a[@title='Go to previous month']")
	private WebElement previousMonthArrow;
	@FindBy(xpath = "//a[@title='Go to next month']")
	private WebElement nextMonthArrow;
	@FindBy(xpath = "//h2[@class='monthYear']")
	private WebElement actualMonth;

	public NewContracts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchField(WebElement element, String contact) {
		element.sendKeys(contact);
		driver.findElement(By.xpath("//mark[text()='" + contact + "']")).click();
	}

	public void selectYear(String year) {
		Select sel = new Select(yearField);
		sel.selectByVisibleText(year);
	}

	public int getMonth(String monthNumber) {
		switch (monthNumber) {
		case "JANUARY":
		case "January":
			return 1;
		case "FEBRUARY":
		case "February":
			return 2;
		case "MARCH":
		case "March":
			return 3;
		case "APRIL":
		case "April":
			return 4;
		case "MAY":
		case "May":
			return 5;
		case "JUNE":
		case "June":
			return 6;
		case "JULY":
		case "July":
			return 7;
		case "AUGUST":
		case "August":
			return 8;
		case "SEPTEMBER":
		case "September":
			return 9;
		case "OCTOBER":
		case "October":
			return 10;
		case "NOVEMBER":
		case "November":
			return 11;
		case "DECEMBER":
		case "December":
			return 12;
		}
		return 0;
	}

	public void enterDate(WebElement element, String date) { // date/month/year
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		String[] stArray = date.split("/");
		String expDate = stArray[0];
		String expMonth = stArray[1];
		selectYear(stArray[2]);
		int actMonthInt = getMonth(actualMonth.getText());
		int expMonthInt = getMonth(expMonth);
		while (!(actMonthInt == expMonthInt)) {
			if (actMonthInt < expMonthInt) {
				nextMonthArrow.click();
				expMonthInt--;
			} else {
				previousMonthArrow.click();
				expMonthInt++;
			}
		}
		WebElement ele = driver.findElement(By.xpath(
				"//span[not(contains(@class,'slds-day weekday nextMonth DESKTOP uiDayInMonthCell--default')) and text()='"
						+ expDate + "']"));
		ele.click();
	}

	public void selectCombobox(WebElement element, int interest, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		Actions act = new Actions(driver);
		for (int i = 0; i < interest; i++) {
			act.sendKeys(Keys.DOWN).build().perform();
		}
		act.sendKeys(Keys.ENTER).build().perform();
	}

	public void enterContractInformation(String account, String customer, String title, String date, int statusNum,
			String startDate, String months, int num, String signedBy, String companyDate) {
		searchField(accountNameField, account);
		searchField(customerSignedByField, customer);
		customerSignedTitleField.sendKeys(title);
		enterDate(customerSignedDateField, date);
		selectCombobox(statusField, statusNum, driver);
		enterDate(contractStartDateField, date);
		contractTermField.sendKeys(months);
		selectCombobox(ownerExpirationNoticeField, num, driver);
		searchField(companySignedByField, signedBy);
		enterDate(companySignedDateField, date);
	}

	public void enterAddressInformation(String street, String city, String code, String state, String country) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].value='"+street+"'", billingStreetField);  
//		billingStreetField.sendKeys(street);
		billingCityField.sendKeys(city);
		billingCodeField.sendKeys(code);
		billingStateField.sendKeys(state);
		billingCountryField.sendKeys(country);
	}

	public void enterDescriptionInformation(String terms, String description) {
		specialTermField.sendKeys(terms);
		descriptionField.sendKeys(description);
	}

	public void clickOnBtn(String btn) {
		if (btn.equalsIgnoreCase("save") || btn.equalsIgnoreCase("Cancel"))
			driver.findElement(By.xpath("(//span[text()='" + btn + "'])[2]")).click();
		else
			driver.findElement(By.xpath("//span[text()='Save & New']")).click();
	}
}
