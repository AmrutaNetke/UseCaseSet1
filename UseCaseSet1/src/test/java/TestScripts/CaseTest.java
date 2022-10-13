package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewCasePage;
import Pages.BaseClass;
import Pages.CasePage;

public class CaseTest extends BaseClass{
	HomePage hPage;
	CasePage case1;
	NewCasePage newcase;
	@BeforeClass
	public void openBrowser() {
		openBrowserTest();
		LoginPage lPage = new LoginPage(driver);
		lPage.enterCredentials("teststandarduser@cloudy.com", "Batch@01");
		lPage.clickOnLogin();
	}

	@Test
	public void createAccountTest() {
		hPage = new HomePage(driver);
		hPage.clickOnTab("Cases");
		case1 = new CasePage(driver);
		case1.clickOnNew();
		
		newcase = new NewCasePage(driver);
		newcase.selectNewCaseType("Product Support");
		newcase.clickOnBtn("Next");
		newcase.enterCaseInformation("Nayan Nene", "Account123",4,3,3,3,1,2);
//		newcase.enterAdditionalInformation("12345", 1, 1);
//		newcase.enterDescriptionInformation("subject1", "description1", "Comment1");
//		newcase.clickBtn("Save");
	}
}