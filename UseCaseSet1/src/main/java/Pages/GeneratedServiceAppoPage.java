package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratedServiceAppoPage extends BaseClass {
	
	@FindBy(xpath = "//span[text()='Description']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement description;
	@FindBy(xpath = "//span[text()='Earliest Start Permitted']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement earliestStartPermited;
	@FindBy(xpath = "//span[text()='Due Date']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement dueDate;
	@FindBy(xpath = "//span[text()='Contact']//parent::div//following-sibling::div//child::span//child::a")
	private WebElement contact;
	@FindBy(xpath = "//span[text()='Parent Record']//parent::div//following-sibling::div//child::span//child::a")
	private WebElement parentRecordtype;
	@FindBy(xpath = "//span[text()='Duration']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement duration;
	@FindBy(xpath = "//span[text()='Subject']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement subject;
	@FindBy(xpath = "//span[text()='Status Category']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement statusCategory;
	
	@FindBy(xpath = "//span[text()='Arrival Window Start']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement arrivalWindowStart;
	@FindBy(xpath = "//span[text()='Arrival Window End']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement arrivalWindowEnd;
	@FindBy(xpath = "//span[text()='Scheduled Start']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement scheduledStart;
	@FindBy(xpath = "//span[text()='Scheduled End']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement scheduledEnd;
	
	@FindBy(xpath = "//span[text()='Actual Start']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement actualStart;
	@FindBy(xpath = "//span[text()='Actual End']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement actualEnd;
	@FindBy(xpath = "//span[text()='Actual Duration (Minutes)']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement durationinMin;
	@FindBy(xpath = "//span[text()='Created By']//parent::div//following-sibling::div//child::span//child::a")
	private WebElement createdBy;
	
	public GeneratedServiceAppoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void displayInfo() {
		
		System.out.println("Description:           "+description.getText());
		System.out.println("earliestStartPermited: "+earliestStartPermited.getText());
		System.out.println("dueDate:               "+dueDate.getText());
		System.out.println("contact:               "+contact.getText());
		System.out.println("parentRecordtype:      "+parentRecordtype.getText());
		System.out.println("duration:              "+duration.getText());
		System.out.println("subject:               "+subject.getText());
		System.out.println("statusCategory:        "+statusCategory.getText());
		System.out.println("arrivalWindowStart:    "+arrivalWindowStart.getText());
		System.out.println("arrivalWindowEnd:      "+arrivalWindowEnd.getText());
		System.out.println("scheduledStart:        "+scheduledStart.getText());
		System.out.println("scheduledEnd:          "+scheduledEnd.getText());
		System.out.println("actualStart:           "+actualStart.getText());
		System.out.println("actualEnd:             "+actualEnd.getText());
		System.out.println("durationinMin:         "+durationinMin.getText());
		System.out.println("createdBy:             "+createdBy.getText());
	}
}
