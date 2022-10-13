package TestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewContracts;
import Pages.BaseClass;
import Pages.ContractsPage;
import Pages.GeneratedContracts;

public class ContractsTest extends BaseClass {
	HomePage hPage;
	NewContracts newContract;

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
		hPage.clickOnTab("Contracts");
		ContractsPage conPage = new ContractsPage(driver);
		conPage.clickOnNew();
		newContract = new NewContracts(driver);
		newContract.enterContractInformation("Account123", "Account1231", "Manager", "3/March/2015", 2,
				"3/December/2020", "24", 4, "TestingStandard", "5/November/2020");
		newContract.enterAddressInformation("Street no.5", "Nagpur", "565656", "MH", "India");
		newContract.enterDescriptionInformation("some terms", "This is a new Contract added");
		newContract.clickOnBtn("Save");
		
		GeneratedContracts genContract= new GeneratedContracts(driver);
		genContract.displayInfo();
	}
	@AfterClass
	public void CloseBrowser() {
		tearDown();
	}
}