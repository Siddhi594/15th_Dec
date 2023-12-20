package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.LoginPage;
import pages.Inventory_page_2;
import utility.ReadData;

public class Cart_page_TestCase extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		cart= new Cart_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.LoginToYourCart();
	}
	@Test
	public void verifyappLogoTextTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(2, 0);
		String actLabel=cart.appLogoText();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of application logo = " + actLabel);
	}
	@Test
	public void verifyYourCartLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(2, 1);
		String actLabel=cart.YourCartText();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of cart = " + actLabel);
	}
	@Test
	public void verifyQtyLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(2, 2);//(2,2)
		String actLabel=cart.QtyLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of quantity = " + actLabel);
	}
	@Test
	public void verifydescLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(2, 3);
		String actLabel=cart.descLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Labe of description = " + actLabel);
	}
	@Test
	public void verifycontinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel(2, 4); //https://www.saucedemo.com/inventory.html
		String actUrl=cart.verifycontinueShoppingBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("After clicking on continue shopping button = " + actUrl);;
	}
	@Test
	public void verifycheckoutBtnTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel(2, 5); //https://www.saucedemo.com/checkout-step-one.html
		String actUrl=cart.verifycheckoutBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("After clicking on checkour button = " + actUrl);
	}
	@Test
	public void LoginToYourCartTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readExcel(0, 8);//(0,8)
		String actUrl=cart.LoginToYourCart();
		Assert.assertEquals(expUrl, actUrl);
	}
	@Test
	public void verifyremove3productsTest()
	{
		String expCounts="3";
		String actCounts=cart.remove3products();
		Assert.assertEquals(expCounts, actCounts);
		Reporter.log("Counts after removing products =" + actCounts);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
}
