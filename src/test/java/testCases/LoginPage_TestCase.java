package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.Capture_Screenshot;
import utility.ReadData;

public class LoginPage_TestCase extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test(priority=1,enabled=true, groups = "Sanity")
	public void verifyTitileOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0); //Swag Labs(0,0)
		String actTitle=login.verifyTitileOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(priority=3,enabled=true, groups = {"Sanity","Retesting"})
	public void verifyURLOfApplication() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1);//https://www.saucedemo.com/(0,1)
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(priority=3,enabled=true)
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);//(0,2)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Capture_Screenshot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}

}
