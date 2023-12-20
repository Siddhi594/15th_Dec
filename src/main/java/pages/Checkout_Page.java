package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page extends TestBase
{
	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement titleOfCheckout;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCode;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	//constructor
	public Checkout_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURLOfCheckoutPage()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleofApplication()
	{
		return titleOfCheckout.getText();
	}
	public String InputInformation()
	{
		firstName.sendKeys("SIS");
		lastName.sendKeys("DIS");
		zipCode.sendKeys("410206");
		continueBtn.click();
		return driver.getCurrentUrl();
	}

}
