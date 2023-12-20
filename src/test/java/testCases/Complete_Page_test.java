package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Page2;
import pages.Checkout_Page;
import pages.Complete_Page;
import pages.Inventory_page_2;
import pages.LoginPage;

public class Complete_Page_test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	Checkout_Page checko;
	CheckOut_Page2 check2;
	Complete_Page comp;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart=new Cart_Page();
		checko= new Checkout_Page();
		check2=new CheckOut_Page2();
		comp=new Complete_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn();
		checko.InputInformation();
		check2.clickOnfinishBtn();
	}
	@Test
	public void imgTest()
	{
		Boolean result =comp.verifyimg();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of img = " + result);
	}
	@Test
	public void thankLabelTest()
	{
		String expLabel="Thank you for your order!";
		String actLabel=comp.thankLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for thank you = " + actLabel);
	}
	@Test
	public void compLabelTest()
	{
		String expLabel="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actLabel=comp.compLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for thanking = " + actLabel);
	}
	@Test
	public void clickOnbackBtnTest()
	{
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actUrl=comp.clickOnbackBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Clicking on back button = " + actUrl);
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	}
	

}
