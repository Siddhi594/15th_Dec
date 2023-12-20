package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_page_2_testcase extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		login.loginToApplication();
	}
	@Test
	public void appLogoTest()
	{
		String expTitle="Swag Labs";
		String actTitle=invent.appLogo();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Tile of application = " + actTitle);
	}
	@Test(priority=4,enabled=true, groups = "Sanity")
	public void verifyproductsLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel=ReadData.readExcel(0, 3);//(0,3)
		String actLabel=invent.verifyproductsLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of Inventory Page = " + actLabel);
	}
	@Test(priority=1,enabled=true,groups = "Retesting")
	public void verifytwitterLogoTest()
	{
		Boolean result=invent.verifytwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Twitter Logo = " + result);
	}
	@Test
	public void verifyfacebookLogo()
	{
		Boolean result=invent.verifyfacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Facebook Logo = " + result);
	}
	@Test
	public void verifylinkedinLogoTest()
	{
		Boolean result=invent.verifylinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Lindked In Logo " + result);
	}
	@Test
	public void FooterTest()
	{
		String expFooter="© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actFooter=invent.Footer();
		Assert.assertEquals(expFooter, actFooter);
		Reporter.log("Visibility of Footer = " + actFooter);
	}
	@Test(priority=2,enabled=true, groups = {"Retesting","Regression"})
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4);//(0,4)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products added to cart = " + actCount);
	}
	@Test(priority=3,enabled=true, groups = {"Retesting","Regression"})
	public void remove2PproductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 5);//(0,5)
		String actCount=invent.remove2Pproducts();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count of producta after removing = " + actCount);
	}
	@Test
	public void LoginToYourCartTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 8);
		String actURL=invent.LoginToYourCart();
		Assert.assertEquals(expURL, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	

}
