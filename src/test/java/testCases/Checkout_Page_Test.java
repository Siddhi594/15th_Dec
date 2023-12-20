package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import base.TestBase;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.Inventory_page_2;
import pages.LoginPage;

public class Checkout_Page_Test extends TestBase
{	
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	Checkout_Page checko;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart= new Cart_Page();
		checko=new Checkout_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn();
	}
	@Test
	public void verifyURLOfCheckoutPageTest()
	{
	String expURL="https://www.saucedemo.com/checkout-step-one.html";
	String actURL=checko.verifyURLOfCheckoutPage();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("URL of checkout page = " + actURL);
	}
	@Test
	public void verifyTitleofApplicationTest()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=checko.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Tile of check out page = " + actTitle);
	}
	@Test
	public void InputInforationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=checko.InputInformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Title of Checkout page 2" + actURL);
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	}
}
