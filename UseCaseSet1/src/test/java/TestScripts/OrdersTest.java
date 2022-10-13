package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewOrders;
import Pages.OrdersPage;

public class OrdersTest extends BaseClass {
	HomePage hPage;
	NewOrders newOrder;

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
		hPage.clickOnTab("Orders");
		OrdersPage order = new OrdersPage(driver);
		order.clickOnNew();
		newOrder = new NewOrders(driver);
		newOrder.enterOrderInformation("00000103","Account123", "3/September/2022",1);
		newOrder.enterShippingAddr("Street no.5", "Nagpur", "565656", "MH", "India","Nayan Nene","TestingStandard User");
		newOrder.enterBillingAddr("street no.5", "Mumbai", "787878", "MH", "India");
		newOrder.enterDescription("New Order is created");
		newOrder.clickOnBtn("Save");
}
}
