package TestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.GeneratedServiceAppoPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewServiceAppointment;
import Pages.ServiceAppointmentPage;

public class ServiceAppointmentScript extends BaseClass {
	HomePage hPage;
	NewServiceAppointment newPage;

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
		hPage.clickOnTab("Service Appointments");
		ServiceAppointmentPage serPage = new ServiceAppointmentPage(driver);
		serPage.clickOnNew();
		newPage = new NewServiceAppointment(driver);
		newPage.enterDescription("This is New Service Appointment");
		newPage.searchContact("Nayan Nene");
		newPage.earliestStartPermittedDate("7/January/2020");
		newPage.earliestStartPermittedTime("1:00 AM");
		newPage.searchParentRecord("Account1");
		newPage.enterDueDate("30/DECEMBER/2021");
		newPage.enterDueTime("2:30 AM");
		newPage.enterGeneralInformation("5", "Street no. 5", "Ahmadabad", "Gujrat", "998989", "India","Subject1");
		newPage.selectDurationType(2, driver);
		newPage.selectStatus(6, driver);
		newPage.enterScheduledTimes("5/MARCH/2003", "12:30 AM", "10/DECEMBER/2003", "1:30 AM", "15/FEBRUARY/2019",
				"5:30 PM", "20/DECEMBER/2019", "3:30 PM");
		newPage.enterActualTimes("5/MARCH/2022", "12:30 AM", "5/MARCH/2022", "1:30 AM", "60");
		newPage.clickOnBtn("Save");
		
		GeneratedServiceAppoPage genPage= new GeneratedServiceAppoPage(driver);
		genPage.displayInfo();
	}
	@AfterClass
	public void CloseBrowser() {
		tearDown();
	}
}