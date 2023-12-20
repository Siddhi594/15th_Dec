	package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	// object repository
	@FindBy(xpath="//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);;
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Application");
		userTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));//(0,6)
		logger.log(Status.INFO, "User Name is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));//(0,7)
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.PASS, "Login is Successfull");
		return driver.getCurrentUrl();
	}
	public String loginToAppWithMultiCreds(String un,String pass)
	{
		userTxtBox.sendKeys(un);//(0,6)
		passwordTxtBox.sendKeys(pass);//(0,7)
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitileOfApplication()
	{
		return driver.getTitle();
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	

}
