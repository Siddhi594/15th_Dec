package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Page extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement compcheckoutLabel;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement img;
	@FindBy(xpath="//h2[text()='Thank you for your order!']") private WebElement thankLabel;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement compLabel;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement backBtn;
	
	public Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public Boolean verifyimg()
	{
		return img.isDisplayed();
	}
	public String thankLabel()
	{
		return thankLabel.getText();
	}
	public String compLabel()
	{
		return compLabel.getText();
	}
	public String clickOnbackBtn()
	{
		backBtn.click();
		return driver.getCurrentUrl();
	}
	
}


