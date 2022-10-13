package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratedContracts extends BaseClass{
	@FindBy(xpath = "//span[text()='Details']")
	private WebElement detailsTab;
	@FindBy(xpath = "//span[text()='Contract Owner']//parent::div//following-sibling::div//child::a")
	private WebElement contractOwner;
	@FindBy(xpath = "(//span[text()='Contract Number']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement contractNumber;
	@FindBy(xpath = "(//span[text()='Account Name']//parent::div//following-sibling::div//child::a)[2]")
	private WebElement accountName;
	@FindBy(xpath = "//span[text()='Customer Signed By']//parent::div//following-sibling::div//child::a")
	private WebElement customerSignedBy;

	@FindBy(xpath = "(//span[text()='Customer Signed Title']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement customerSignedTitle;
	
	@FindBy(xpath = "(//span[text()='Customer Signed Date']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement customerSignedDate;
	@FindBy(xpath = "//span[text()='Billing Address']//parent::div//following-sibling::div//child::a")
	private WebElement billingAddr;
	@FindBy(xpath = "(//span[text()='Status']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement status;
	@FindBy(xpath = "(//span[text()='Contract Start Date']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement contractStartDate;
	
	@FindBy(xpath = "(//span[text()='Contract End Date']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement contractEndDate;
	@FindBy(xpath = "(//span[text()='Contract Term (months)']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement contractTerm;
	@FindBy(xpath = "(//span[text()='Owner Expiration Notice']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement ownerExpiryNotice;
	@FindBy(xpath = "//span[text()='Company Signed By']//parent::div//following-sibling::div//child::a")
	private WebElement companySignedBy;
	@FindBy(xpath = "(//span[text()='Company Signed Date']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement compnaySignedDate;
	
	@FindBy(xpath = "(//span[text()='Special Terms']//parent::div//following-sibling::div//child::span)[2]")
	private WebElement specialTerms;
	@FindBy(xpath = "//span[text()='Description']//parent::div//following-sibling::div//child::span//child::span")
	private WebElement description;
	
	public GeneratedContracts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void displayInfo() {
		detailsTab.click();
		System.out.println("contract Owner:           "+contractOwner.getText());
		System.out.println("contract Number:          "+contractNumber.getText());
		System.out.println("Account Name:             "+accountName.getText());
		System.out.println("customer Signed By:       "+customerSignedBy.getText());
		System.out.println("customer Signed Title:    "+customerSignedTitle.getText());
		System.out.println("customer Signed Date:     "+customerSignedDate.getText());
		System.out.println("Billing Addr:             "+billingAddr.getAttribute("title"));
		System.out.println("status:                   "+status.getText());
		System.out.println("Contract Start Date:      "+contractStartDate.getText());
		System.out.println("Contract End Date:        "+contractEndDate.getText());
		System.out.println("Contract term:            "+contractTerm.getText());
		System.out.println("Owner expiration notice:  "+ownerExpiryNotice.getText());
		System.out.println("Company Signed By:        "+companySignedBy.getText());
		System.out.println("Company Signed Date:      "+compnaySignedDate.getText());
		System.out.println("Special Term:             "+specialTerms.getText());
		System.out.println("Description:              "+description.getText());
	}
}
