package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.Capture_Screenshot;


public class VerifyMultipleCredentialsTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@DataProvider(name="Credentials")
	public Object[][] getData()
	{
		return new Object[][]
				{
			        {"standard_user","secret_sauce"},//RU RP
			        {"standard_user1","secret_sauce"},//WU RP
			        {"standard_user","secret_sauce2"},//RU WP
			        {"standard_user1","secret_sauce2"},//WU WP
				};
	}
	@Test(dataProvider = "Credentials")
	public void loginToAppWithMultiCredsTest(String un,String pass)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToAppWithMultiCreds(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
}
