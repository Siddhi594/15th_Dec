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
import pages.Inventory_page_2;
import pages.LoginPage;

public class CheckOut_Page2_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	Checkout_Page checko;
	CheckOut_Page2 check2;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart=new Cart_Page();
		checko=new Checkout_Page();
		check2=new CheckOut_Page2();
		login.loginToApplication();
		invent.add6Products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn(); 
		checko.InputInformation();
	}
	@Test
	public void verifytitleOfCheckoutpage2Test()
	{
		String expLabel="Checkout: Overview";
		String actLabel=check2.verifytitleOfCheckoutpage2();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of CheckOutPage2 = " + actLabel);
	}
	@Test
	public void verifyqtyLabelTest()
	{
		String expLabel="QTY";
		String actLabel=check2.verifyqtyLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for quantity = " + actLabel);
	}
	@Test
	public void descLabelTest()
	{
		String expLabel="Description";
		String actLabel=check2.verifydescLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for description = " + actLabel);
	}
	@Test
	public void paymentLabelTest()
	{
		String expLabel="Payment Information";
		String actLabel=check2.verifypaymentLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for payment infor =" + actLabel);
	}
	@Test
	public void shippingLabel()
	{
		String expLabel="Shipping Information";
		String actLabel=check2.verifyshippingLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for shipping info = " + actLabel);
	}
	@Test
	public void priceLabel()
	{
		String expLabel="Price Total";
		String actLabel=check2.verifypriceLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label for price = " + actLabel);
	}
	@Test
	public void cancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=check2.clickOncancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Url for cancel button = " + actURL);
	}
	@Test
	public void clickOnfinishBtn()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.clickOnfinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of complete Page = " + actURL);
		
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
	

}
