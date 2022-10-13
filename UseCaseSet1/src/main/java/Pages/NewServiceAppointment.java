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

public class NewServiceAppointment extends BaseClass {
	@FindBy(xpath = "//span[text()='Description']//parent::label//following-sibling::textarea")
	private WebElement descriptionField;
	@FindBy(xpath = "//input[@title='Search Contacts']")
	private WebElement contactField;
	@FindBy(xpath = "(//label[text()='Date']//following-sibling::input)[1]")
	private WebElement startPermittedDateField;
	@FindBy(xpath = "(//label[text()='Time']//following-sibling::input)[1]")
	private WebElement startPermittedTimeField;
	@FindBy(xpath = "//input[@placeholder='Search Accounts...']")
	private WebElement parentRecord;
	@FindBy(xpath = "(//label[text()='Date']//following-sibling::input)[2]")
	private WebElement dueDateField;
	@FindBy(xpath = "(//label[text()='Time']//following-sibling::input)[2]")
	private WebElement dueTimeField;
	@FindBy(xpath = "(//input[@class='input uiInputSmartNumber'])[1]")
	private WebElement durationField;
	@FindBy(xpath = "//textarea[@placeholder='Street']")
	private WebElement streetField;
	@FindBy(xpath = "//input[@placeholder='City']")
	private WebElement cityField;
	@FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
	private WebElement codeField;
	@FindBy(xpath = "//input[@placeholder='State/Province']")
	private WebElement stateField;
	@FindBy(xpath = "//input[@placeholder='Country']")
	private WebElement countryField;

	@FindBy(xpath = "(//span[text()='Duration Type']//parent::span//parent::div//child::div)[1]")
	private WebElement durationTypeField;
	@FindBy(xpath = "(//a[text()='None']//parent::div//parent::div)[1]")
	private WebElement statusField;
	@FindBy(xpath = "//span[text()='Subject']//parent::label//following-sibling::input")
	private WebElement subjectField;

//	Scheduled Times
	@FindBy(xpath = "(//label[text()='Date'])[3]//following-sibling::input")
	private WebElement arrivalStartDateField;
	@FindBy(xpath = "(//label[text()='Time'])[3]//following-sibling::input")
	private WebElement arrivalStartTimeField;

	@FindBy(xpath = "(//label[text()='Date'])[4]//following-sibling::input")
	private WebElement scheduledStartDateField;
	@FindBy(xpath = "(//label[text()='Time'])[4]//following-sibling::input")
	private WebElement scheduledStartTimeField;

	@FindBy(xpath = "(//label[text()='Date'])[5]//following-sibling::input")
	private WebElement arrivalEndDateField;
	@FindBy(xpath = "(//label[text()='Time'])[5]//following-sibling::input")
	private WebElement arrivalEndTimeField;

	@FindBy(xpath = "(//label[text()='Date'])[6]//following-sibling::input")
	private WebElement scheduledEndDateField;
	@FindBy(xpath = "(//label[text()='Time'])[6]//following-sibling::input")
	private WebElement scheduledEndTimeField;

//	Actual Times
	@FindBy(xpath = "(//label[text()='Date'])[7]//following-sibling::input")
	private WebElement actualStartDateField;
	@FindBy(xpath = "(//label[text()='Time'])[7]//following-sibling::input")
	private WebElement actualStartTimeField;

	@FindBy(xpath = "(//label[text()='Date'])[8]//following-sibling::input")
	private WebElement actualEndDateField;
	@FindBy(xpath = "(//label[text()='Time'])[8]//following-sibling::input")
	private WebElement actualEndTimeField;

	@FindBy(xpath = "//span[text()='Actual Duration (Minutes)']//parent::label//following-sibling::input")
	private WebElement actualDurationField;

	@FindBy(xpath = "//select[@class='slds-select picklist__label']")
	private WebElement yearField;
	@FindBy(xpath = "//a[@title='Go to previous month']")
	private WebElement previousMonthArrow;
	@FindBy(xpath = "//a[@title='Go to next month']")
	private WebElement nextMonthArrow;
	@FindBy(xpath = "//h2[@class='monthYear']")
	private WebElement actualMonth;

	public NewServiceAppointment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterDescription(String desc) {
		descriptionField.sendKeys(desc);
	}

	public void searchContact(String contact) {
		contactField.sendKeys(contact);
		driver.findElement(By.xpath("//div[@title='"+contact+"']")).click();
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

	public void enterDate(String date) { // date/month/year
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

	public void earliestStartPermittedDate(String date) {
		startPermittedDateField.click();
		enterDate(date);
	}

	public void enterTime(WebElement element, String time) {
		element.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//li[text()='" + time + "']"));
		js.executeScript("arguments[0].click();", ele);
	}

	public void earliestStartPermittedTime(String time) {
		enterTime(startPermittedTimeField, time);
	}

	public void enterDueDate(String date) {
		dueDateField.click();
		enterDate(date);
	}

	public void enterDueTime(String time) {
		dueTimeField.clear();
		dueTimeField.sendKeys(time);
	}

	public void searchParentRecord(String record) {
		parentRecord.sendKeys(record);
		driver.findElement(By.xpath("//mark[text()='" + record + "']//ancestor::a")).click();
	}

	public void enterGeneralInformation(String duration, String street, String city, String state, String code,
			String country, String subject) {
		durationField.sendKeys(duration);
		streetField.sendKeys(street);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		codeField.sendKeys(code);
		countryField.sendKeys(country);
		subjectField.sendKeys(subject);
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

	public void selectDurationType(int position, WebDriver driver) {
		selectCombobox(durationTypeField, position, driver);
	}

	public void selectStatus(int position, WebDriver driver) {
		selectCombobox(statusField, position, driver);
	}

	public void enterArrivalStartDate(String date) {
		arrivalStartDateField.click();
		enterDate(date);
	}

	public void enterArrivalStartTime(String time) {
		arrivalStartTimeField.clear();
		arrivalStartTimeField.sendKeys(time);
	}

	public void enterArrivalEndDate(String date) {
		arrivalEndDateField.click();
		enterDate(date);
	}

	public void enterArrivalEndTime(String time) {
		arrivalEndTimeField.clear();
		arrivalEndTimeField.sendKeys(time);
	}

	public void enterScheduledStartDate(String date) {
		scheduledStartDateField.click();
		enterDate(date);
	}

	public void enterScheduledStartTime(String time) {
		scheduledStartTimeField.clear();
		scheduledStartTimeField.sendKeys(time);
	}

	public void enterScheduledEndDate(String date) {
		scheduledEndDateField.click();
		enterDate(date);
	}

	public void enterScheduledEndTime(String time) {
		scheduledEndTimeField.clear();
		scheduledEndTimeField.sendKeys(time);
	}

	public void enterScheduledTimes(String aStartDate, String aStartTime, String aEndDate, String aEndTime,
			String sStartDate, String sStartTime, String sEndDate, String sEndTime) {
		enterArrivalStartDate(aStartDate);
		enterArrivalStartTime(aStartTime);
		enterArrivalEndDate(aEndDate);
		enterArrivalEndTime(aEndTime);
		enterScheduledStartDate(sStartDate);
		enterScheduledStartTime(sStartTime);
		enterScheduledEndDate(sEndDate);
		enterScheduledEndTime(sEndTime);
	}

	public void enterActualStartDate(String date) {
		actualStartDateField.click();
		enterDate(date);
	}

	public void enterActualStartTime(String time) {
		actualStartTimeField.clear();
		actualStartTimeField.sendKeys(time);
	}

	public void enterActualEndDate(String date) {
		actualEndDateField.click();
		enterDate(date);
	}

	public void enterActualEndTime(String time) {
		actualEndTimeField.clear();
		actualEndTimeField.sendKeys(time);
	}

	public void enterActualTimes(String aStartDate, String aStartTime, String aEndDate, String aEndTime,
			String duration) {
		enterActualStartDate(aStartDate);
		enterActualStartTime(aStartTime);
		enterActualEndDate(aEndDate);
		enterActualEndTime(aEndTime);
		actualDurationField.sendKeys(duration);
	}

	public void clickOnBtn(String btn) {
		if(btn.equalsIgnoreCase("save")|| btn.equalsIgnoreCase("Cancel"))
			driver.findElement(By.xpath("(//span[text()='"+btn+"'])[2]")).click();
		else
			driver.findElement(By.xpath("//span[text()='Save & New']")).click();
	}
}
